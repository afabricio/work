package br.com.kiman.kiprev.ki.xp.jaxws.exception;

import javax.xml.ws.WebFault;

import br.com.kiman.kiprev.ki.xp.jaxws.FaultInfo;


@WebFault(name = "ResourceWSException", targetNamespace = "http://kiman.com.br/ki/xp/service/exception")
public class ResourceWSException extends RuntimeException {

	private static final long serialVersionUID = 6260756481393441536L;

	private FaultInfo faultInfo;

	public ResourceWSException(String message) {
		super(message);
	}

	public ResourceWSException(final String message, final FaultInfo faultInfo) {
		super();
		this.faultInfo = faultInfo;
	}

	public ResourceWSException(final String message, final FaultInfo faultInfo,
			final Throwable cause) {
		super();
		this.faultInfo = faultInfo;
	}

	public ResourceWSException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public void setFaultInfo(FaultInfo faultInfo) {
		this.faultInfo = faultInfo;
	}

	public FaultInfo getFaultInfo() {
		return this.faultInfo;
	}

}
