package br.com.kiman.kiprev.ki.xp.rest.interceptor;

import static br.com.kiman.kiprev.ki.xp.dominio.dao.QueryParameters.with;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;

import br.com.kiman.kiprev.ki.xp.dominio.dao.GenericDAO;




@Provider
public class RequestServerInterceptor
		implements ReaderInterceptor, WriterInterceptor, ContainerRequestFilter, ContainerResponseFilter {

	private static final Logger logger = Logger.getLogger(RequestServerInterceptor.class);
	private static final String ENTITY_STREAM_PROPERTY = "EntityLoggingFilter.entityStream";
	
	public static final String LOG_CHAVE = "logChave";
	public static final String LOG_NUMERO_INTERFACE = "logNumeroInterface";

	@Inject
	private GenericDAO hist;

	@Override
	public void filter(ContainerRequestContext context) throws IOException {

		context.setProperty("METHOD", context.getMethod());
		context.setProperty("URI", context.getUriInfo().getRequestUri());
		context.setProperty("DTREQUEST", new Timestamp(new Date().getTime()));

	}

	@Override
	public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		byte[] buffer = new byte[1024];
		int len;
		while ((len = context.getInputStream().read(buffer)) > -1) {
			baos.write(buffer, 0, len);
		}
		baos.flush();

		context.setInputStream(new ByteArrayInputStream(baos.toByteArray()));

		InputStream is2 = new ByteArrayInputStream(baos.toByteArray());

		String body = new BufferedReader(new InputStreamReader(is2)).lines().collect(Collectors.joining("\n"));

		context.setProperty("JSONREQUEST", body);

		return context.proceed();
	}

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		if (responseContext.hasEntity()) {

			final OutputStream stream = new LoggingStream(responseContext.getEntityStream());
			responseContext.setEntityStream(stream);
			requestContext.setProperty(ENTITY_STREAM_PROPERTY, stream);
			requestContext.setProperty("MSGRETORNO", responseContext.getStatusInfo().getReasonPhrase().toString());

			if (responseContext.getStatus() >= 300) {
				requestContext.setProperty("STATUS", "E");
			} else {
				requestContext.setProperty("STATUS", "S");
			}

		} else {

			String status = "", erro = "";
			if (responseContext.getStatus() >= 300) {
				status = "E";
				erro = responseContext.getStatusInfo().getReasonPhrase().toString();
			} else {
				status = "S";
			}

			hist.executeProcedureByNamedProcedure("P_REQUEST_LOGGER_AUTONOMOUS", 
					with("pnCodHist",null)
					.and("pURL", requestContext.getUriInfo().getRequestUri().toString())
					.and("pOPERACAO", requestContext.getMethod())
					.and("pXML_REQUEST", requestContext.getProperty("JSONREQUEST").toString())
					.and("pXML_RESPONSE", "")
					.and("pNUM_INTERFACE", requestContext.getProperty(LOG_NUMERO_INTERFACE))
					.and("pNUM_DOCUMENTO", String.valueOf(requestContext.getProperty(LOG_CHAVE)))
					.and("pDT_REQUISICAO", DateUtils.truncate(new Date(), Calendar.DATE))
					.and("pTS_ENVIO", (Timestamp) requestContext.getProperty("DTREQUEST"))
					.and("pTS_RETORNO", new Timestamp(new Date().getTime()))
					.and("pMSG_ERRO", erro)
					.and("pSTATUS", status));

		}
	}

	@Override
	public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
		final LoggingStream stream = (LoggingStream) context.getProperty(ENTITY_STREAM_PROPERTY);
		context.proceed();

		if (stream != null) {

			String jsonRequest = context.getProperty("JSONREQUEST") == null ? ""
					: context.getProperty("JSONREQUEST").toString();
			String jsonResponse = stream.getAsString();

			String status = context.getProperty("STATUS").toString();
			String erro = "";
			if ("E".equals(status)) {
				erro = context.getProperty("MSGRETORNO").toString();
			}
	
			hist.executeProcedureByNamedProcedure("P_REQUEST_LOGGER_AUTONOMOUS", 					
					with("pnCodHist",null)
					.and("pURL", context.getProperty("URI").toString())
					.and("pOPERACAO", context.getProperty("METHOD").toString())
					.and("pXML_REQUEST", jsonRequest)
					.and("pXML_RESPONSE", jsonResponse)
					.and("pNUM_INTERFACE", context.getProperty(LOG_NUMERO_INTERFACE))
					.and("pNUM_DOCUMENTO", String.valueOf(context.getProperty(LOG_CHAVE)))
					.and("pDT_REQUISICAO", DateUtils.truncate(new Date(), Calendar.DATE))
					.and("pTS_ENVIO", (Timestamp) context.getProperty("DTREQUEST"))
					.and("pTS_RETORNO", new Timestamp(new Date().getTime()))
					.and("pMSG_ERRO", erro)
					.and("pSTATUS", context.getProperty("STATUS").toString()));

		}
	}

	private class LoggingStream extends FilterOutputStream {

		private final ByteArrayOutputStream baos = new ByteArrayOutputStream();

		LoggingStream(OutputStream out) {
			super(out);
		}

		String getAsString() {

			try {

				return baos.toString(StandardCharsets.UTF_8.name());
			} catch (UnsupportedEncodingException e) {
				logger.error(e);
				return null;
			}
		}

		@Override
		public void write(final int i) throws IOException {
			baos.write(i);
			out.write(i);

		}
	}
}
