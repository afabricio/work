package br.com.kiman.kiprev.ki.xp.jaxws.documento;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.interceptor.InInterceptors;

@WebService(serviceName = "DocumentoWS", targetNamespace = DocumentoWS.NAMESPACE)
@InInterceptors(interceptors = { "br.com.kiman.kiprev.ki.xp.jaxws.interceptor.WSSecurityInterceptor" })
public interface DocumentoWS {

	public static final String NAMESPACE = "http://kiman.com.br/ki/xp/jaxws/documento";

	@WebMethod
	public DocumentoPropostaResult documentoProposta(@WebParam(name = "numProposta") Long numProposta);

	@WebMethod
	public DocumentoCertificadoResult documentoCertificado(@WebParam(name = "numCertificado") String numCertificado);

	@WebMethod
	public DocumentoPortabilidadeResult documentoPortabilidade(@WebParam(name = "numPortabilidade") String numPortabilidade);

	@WebMethod
	public DocumentoTransferenciaResult documentoTransferencia(@WebParam(name = "numTransferencia") Long numTransferencia);

}
