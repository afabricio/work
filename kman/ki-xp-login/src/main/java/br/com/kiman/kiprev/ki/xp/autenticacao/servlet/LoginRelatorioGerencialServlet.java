package br.com.kiman.kiprev.ki.xp.autenticacao.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import br.com.kiman.kiprev.ki.xp.dominio.constants.Grupo;
import br.com.kiman.kiprev.ki.xp.dominio.constants.Interface;
import br.com.kiman.kiprev.ki.xp.dominio.constants.ParametroEnum;
import br.com.kiman.kiprev.ki.xp.dominio.entity.UsuarioKiprev;
import br.com.kiman.kiprev.ki.xp.dominio.exception.NegocioException;
import br.com.kiman.kiprev.ki.xp.dominio.facade.ParametroFacade;
import br.com.kiman.kiprev.ki.xp.dominio.facade.UsuarioFacade;

@WebServlet(urlPatterns = { "/relatorioGerencial" })
public class LoginRelatorioGerencialServlet extends HttpServlet {

	private static final long serialVersionUID = 3719282530950007260L;

	private static final Logger logger = Logger.getLogger(LoginRelatorioGerencialServlet.class);

	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private static final String LOGIN_JSP = "/relatorioGerencialLogin.jsp";
	private static final String ERRO = "ERRO";
	private static final String ERRO_NO_LOGIN = "Erro ao tentar login.";
	private static final String URL_COMPLETA = "%s/#/loginExterno?interfaceToken=%s";

	@EJB
	private UsuarioFacade usuarioFacade;
	@EJB
	private ParametroFacade parametroFacade;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher(LOGIN_JSP);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String codUsuario = req.getParameter(USERNAME);
			String senha = req.getParameter(PASSWORD);

			UsuarioKiprev usuario = usuarioFacade.autenticaModuloRelatorioGerencial(codUsuario, senha);

			String urlAplicacao = parametroFacade.buscaParametro(Interface.LOGIN_AD, Grupo.PARAMETRO_FIXO,
					ParametroEnum.URL_REL_GERENCIAL);

			String urlCompleta = String.format(URL_COMPLETA, urlAplicacao, usuario.getToken());

			resp.sendRedirect(urlCompleta);

		} catch (NegocioException e) {
			req.setAttribute(ERRO, e.getMessage());
			doGet(req, resp);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			req.setAttribute(ERRO, ERRO_NO_LOGIN);
			doGet(req, resp);
		}
	}

}
