package br.com.kiman.kiprev.ki.xp.jaxws.security;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

//$Id: KiprevAuthenticationManagerJdbcDaoImpl.java 13263 2014-07-01 01:38:56Z cgoncalves $
public class KiprevAuthenticationManagerJdbcDaoImpl extends JdbcDaoImpl {



	@Override
	protected JdbcTemplate createJdbcTemplate(DataSource dataSource) {
		return super.createJdbcTemplate(dataSource);
	}

	public final static String DEF_USERS_BY_USERNAME_QUERY = "select login_usuario as username, senha as password, decode(status, 'A', 1, 0) as enabled "
			+ " from ncl_usuarios where UPPER(login_usuario) = UPPER(?)";

	public final static String DEF_AUTHORITIES_BY_USERNAME_QUERY = "select login_usuario as username, nome_perfil as authority from ncl_usuarios where UPPER(login_usuario) = UPPER(?)";

	public KiprevAuthenticationManagerJdbcDaoImpl() {
		super();

		setUsersByUsernameQuery(DEF_USERS_BY_USERNAME_QUERY);
		setAuthoritiesByUsernameQuery(DEF_AUTHORITIES_BY_USERNAME_QUERY);
		setGroupAuthoritiesByUsernameQuery(DEF_GROUP_AUTHORITIES_BY_USERNAME_QUERY);
	}

}
