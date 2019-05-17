package br.com.kiman.kiprev.ki.xp.dominio.dto.builder;

import java.util.Date;

import br.com.kiman.kiprev.ki.xp.dominio.dto.RequestHistDTO;

public class RequestHistBuilder {

	public static final String BUILDER = "builder";
	private Date tempoEnvio;
	private String mensagemRequest;
	private String url;
	private String metodoOperacao;
	private String requestStatus;
	private String mensagemResponse;
	private String chaveDocumento;
	private String mensagemErro;
	private Integer numeroInterface;
	private Date tempoRetorno;

	private RequestHistBuilder() {
	}

	public static RequestHistBuilder newInstance() {
		return new RequestHistBuilder();
	}

	public RequestHistBuilder tempoEnvio(Date dataRequest) {
		this.tempoEnvio = dataRequest;
		return this;
	}

	public RequestHistBuilder mensagemRequest(String mensagemRequest) {
		this.mensagemRequest = mensagemRequest;
		return this;
	}

	public RequestHistBuilder url(String url) {
		this.url = url;
		return this;
	}

	public RequestHistBuilder nomeOperacao(String metodoOperacao) {
		this.metodoOperacao = metodoOperacao;
		return this;
	}

	public RequestHistBuilder status(String requestStatus) {
		this.requestStatus = requestStatus;
		return this;
	}

	public RequestHistBuilder mensagemResponse(String mensagemResponse) {
		this.mensagemResponse = mensagemResponse;
		return this;

	}

	public RequestHistBuilder chaveDocumento(String chave) {
		this.chaveDocumento = chave;
		return this;
	}

	public RequestHistBuilder mensagemErro(String mensagemErro) {
		if (mensagemErro == null) {
			return this;
		}

		if (mensagemErro.length() < 4000) {
			this.mensagemErro = mensagemErro;
		} else {
			this.mensagemErro = mensagemErro.substring(0, 4000);
		}

		return this;
	}

	public RequestHistBuilder numeroInterface(Integer numeroInterface) {
		this.numeroInterface = numeroInterface;
		return this;
	}

	public RequestHistBuilder dataResponse(Date dataResponse) {
		this.tempoRetorno = dataResponse;
		return this;
	}

	public RequestHistDTO build() {
		RequestHistDTO requestHistDTO = new RequestHistDTO();
		requestHistDTO.setUrl(url);
		requestHistDTO.setOperacao(metodoOperacao);
		requestHistDTO.setRequest(mensagemRequest);
		requestHistDTO.setResponse(mensagemResponse);
		requestHistDTO.setNumInterf(numeroInterface);
		requestHistDTO.setNumDoc(chaveDocumento);
		requestHistDTO.setDataReq(tempoEnvio);
		requestHistDTO.setDataResp(tempoRetorno);
		requestHistDTO.setMsgErro(mensagemErro);
		if (requestStatus != null) {
			requestHistDTO.setStatus(requestStatus);
		}
		return requestHistDTO;
	}

}
