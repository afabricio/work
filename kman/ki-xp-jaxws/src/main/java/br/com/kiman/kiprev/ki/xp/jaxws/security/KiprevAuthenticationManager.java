package br.com.kiman.kiprev.ki.xp.jaxws.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("kiprevAuthenticationManager")
@Scope("session")
public class KiprevAuthenticationManager {

	private static final String ANONYMOUS = "anonymousUser";

	@Autowired
	private AuthenticationManager authenticationManager;

	public boolean authenticate(String user, String password) {
		return authenticate(user, password, null, null);
	}

	public boolean authenticate(String user, String password, HttpServletRequest request,
			HttpServletResponse response) {
		boolean authenticated = true;
		try {
			Authentication auth = new UsernamePasswordAuthenticationToken(user, password);
			Authentication result = authenticationManager.authenticate(auth);

			if (request != null) {
				RequestDispatcher dispatcher = (request.getRequestDispatcher("/j_spring_security_check"));
				dispatcher.forward(request, response);
			}

			SecurityContextHolder.getContext().setAuthentication(result);
		} catch (Exception e) {
			authenticated = false;
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return authenticated;
	}

	public String getUsername() {
		String username = null;
		Authentication authentication = getAuthentication();
		if (authentication != null) {
			username = authentication.getName();
			if (ANONYMOUS.equals(username)) {
				username = null;
			}
		}
		return username;
	}

	public List<String> getUserRoles() {
		List<String> userRoles = new ArrayList<String>();
		Authentication authentication = getAuthentication();
		if (authentication != null) {
			Collection<? extends GrantedAuthority> subjectGrants = authentication.getAuthorities();
			if (subjectGrants != null) {
				for (GrantedAuthority granted : subjectGrants) {
					userRoles.add(granted.getAuthority());
				}
			}
		}
		return userRoles;
	}

	private Authentication getAuthentication() {
		Authentication authentication = null;
		if (SecurityContextHolder.getContext() != null) {
			authentication = SecurityContextHolder.getContext().getAuthentication();
		}
		return authentication;
	}

}
