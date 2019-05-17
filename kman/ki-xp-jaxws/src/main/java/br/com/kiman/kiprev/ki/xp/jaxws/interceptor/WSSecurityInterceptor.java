package br.com.kiman.kiprev.ki.xp.jaxws.interceptor;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.ws.security.handler.WSHandlerConstants;

import br.com.kiman.kiprev.ki.xp.jaxws.security.PasswordCallbackHandler;

public class WSSecurityInterceptor extends BaseInterceptor {

	private WSS4JInInterceptor wss4jInHandler;
	private PasswordCallbackHandler defaultPasswordHandler;

	public WSSecurityInterceptor() {
		super(Phase.PRE_PROTOCOL);
		wss4jInHandler = new WSS4JInInterceptor();
	}

	public WSSecurityInterceptor(WSS4JInInterceptor defaultInterceptor,
			PasswordCallbackHandler defaultPasswordHandler) {
		super(Phase.PRE_PROTOCOL);
		this.wss4jInHandler = defaultInterceptor;
		this.defaultPasswordHandler = defaultPasswordHandler;
	}

	public void handleMessage(SoapMessage message) throws Fault {
		Map<String, Object> props = new HashMap<String, Object>();
		props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		props.put(WSHandlerConstants.PW_CALLBACK_REF,
				getPasswordHandler(message));
		wss4jInHandler.setProperties(props);
		message.getInterceptorChain().add(wss4jInHandler);
	}

	private PasswordCallbackHandler getPasswordHandler(SoapMessage message) {
		PasswordCallbackHandler handler = defaultPasswordHandler != null ? defaultPasswordHandler
				: new PasswordCallbackHandler();
		return handler;
	}

}
