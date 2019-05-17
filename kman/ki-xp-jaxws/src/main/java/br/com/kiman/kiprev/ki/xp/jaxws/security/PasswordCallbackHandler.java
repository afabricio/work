package br.com.kiman.kiprev.ki.xp.jaxws.security;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;
import org.springframework.stereotype.Component;

import br.com.kiman.kiprev.ki.xp.jaxws.exception.ResourceWSException;
import br.com.kiman.kiprev.ki.xp.jaxws.util.SpringBeanUtil;

@Component("passwordCallbackHandler")
public class PasswordCallbackHandler implements CallbackHandler {

	public PasswordCallbackHandler() {
	}

	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		try {

			String user = pc.getIdentifier();
			String password = pc.getPassword();
			KiprevAuthenticationManager kiprevAuthenticationManager = (KiprevAuthenticationManager) SpringBeanUtil
					.getBean("kiprevAuthenticationManager");
			boolean valid = kiprevAuthenticationManager.authenticate(user,
					password);

			if (!valid)
				throw new ResourceWSException("Failed authentication for "
						+ user + ".");
		} catch (Exception e) {
			throw new ResourceWSException(e.getMessage(), e.getCause());
		}
	}

}