package br.com.kiman.kiprev.ki.xp.dominio.cliente.rest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response.Status.Family;
import javax.ws.rs.core.Response.StatusType;

import org.apache.log4j.Logger;
import org.apache.log4j.lf5.util.StreamUtils;

import br.com.kiman.kiprev.ki.xp.dominio.constants.Interface;
import br.com.kiman.kiprev.ki.xp.dominio.dto.builder.RequestHistBuilder;
import br.com.kiman.kiprev.ki.xp.dominio.service.LoggerService;
import br.com.kiman.kiprev.ki.xp.dominio.util.BeanUtil;
import br.com.kiman.kiprev.ki.xp.integration.WrapperOutputStream;

public class ClienteRestLogger implements ClientRequestFilter, ClientResponseFilter {

	private final Interface interf;
	private final String numDocumento;
	private static final Logger logger = Logger.getLogger(ClienteRestLogger.class);
	
	public ClienteRestLogger(Interface interf) {
		this(interf, null);
	}

	public ClienteRestLogger(Interface interf, Object numDocumento) {
		this.interf = interf;
		this.numDocumento = Optional.ofNullable(numDocumento).map(o -> o.toString()).orElse("");
	}

	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		RequestHistBuilder builder = RequestHistBuilder.newInstance();
		builder.chaveDocumento(numDocumento).numeroInterface(interf.getNumero())
				.tempoEnvio(new Date(System.currentTimeMillis())).url(requestContext.getUri().toString());

		requestContext.setProperty(RequestHistBuilder.BUILDER, builder);

		if (requestContext.hasEntity()) {
			requestContext.setEntityStream(new WrapperOutputStream(requestContext.getEntityStream()));

		}
	}

	@Override
	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {

		byte[] responseEntity = StreamUtils.getBytes(responseContext.getEntityStream());
		String response = new String(responseEntity);
		if (responseContext.getHeaders().containsKey(HttpHeaders.CONTENT_TYPE)
				&& responseContext.getHeaders().get(HttpHeaders.CONTENT_TYPE).contains("application/pdf")) {
			response = Base64.getEncoder().encodeToString(responseEntity);
		}
		responseContext.setEntityStream(new ByteArrayInputStream(responseEntity));

		try {
			RequestHistBuilder builder = (RequestHistBuilder) requestContext.getProperty(RequestHistBuilder.BUILDER);
			builder.dataResponse(new Date(System.currentTimeMillis())).nomeOperacao(requestContext.getMethod());

			if (requestContext.hasEntity()) {
				builder.mensagemRequest(((WrapperOutputStream) requestContext.getEntityStream()).getAsString());
			}

			StatusType statusInfo = responseContext.getStatusInfo();

			
			if (statusInfo.getFamily().equals(Family.SUCCESSFUL)) {
				builder.status("S").mensagemResponse(response);
			} else if (statusInfo.getFamily().equals(Family.CLIENT_ERROR)) {
				
				builder.status("C").mensagemResponse(response).mensagemErro(statusInfo.getStatusCode() + " - " +statusInfo.getFamily()+ " " + statusInfo.getReasonPhrase());
			} else {
				builder.status("E").mensagemResponse(response).mensagemErro(statusInfo.getStatusCode() + " - " +statusInfo.getFamily()+ " " +  statusInfo.getReasonPhrase());
			}
			
			 LoggerService service = BeanUtil.getBean(LoggerService.class);

			service.asyncLogRequest(builder.build());

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}
