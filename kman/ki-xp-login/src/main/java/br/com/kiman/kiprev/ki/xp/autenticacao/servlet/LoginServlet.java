package br.com.kiman.kiprev.ki.xp.autenticacao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.kiman.kiprev.ki.xp.autenticacao.KiprevConnector;
import br.com.kiman.kiprev.ki.xp.dominio.autenticacao.AutenticadorAD;
import br.com.kiman.kiprev.ki.xp.dominio.entity.UsuarioKiprev;
import br.com.kiman.kiprev.ki.xp.dominio.exception.NegocioException;
import br.com.kiman.kiprev.ki.xp.dominio.facade.UsuarioFacade;

@WebServlet(urlPatterns = { "/login", "/index.html" })
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 8908047101740910785L;

	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private static final String LOGIN_PAGE = "/index.jsp";
	private static final String ERRO = "ERRO";
	private static final String ERRO_CONEXAO_KIPREV = "Ocorreu um erro e não foi possível conectar ao kiprev.";

	@Inject
	private AutenticadorAD autenticadorAD;
	@Inject
	private KiprevConnector kiprevConnector;
	@EJB
	private UsuarioFacade usuarioFacade;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher(LOGIN_PAGE);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String codUsuario = req.getParameter(USERNAME);
		String senha = req.getParameter(PASSWORD);
		try {
			autenticadorAD.autentica(codUsuario, senha);

			UsuarioKiprev usuario = usuarioFacade.validaUsuario(codUsuario);

			String resultado = kiprevConnector.conectaNoKiprev(usuario);

			PrintWriter writer = resp.getWriter();
			writer.write(resultado);
			writer.close();
		} catch (NegocioException e) {
			req.setAttribute(ERRO, e.getMessage());
			doGet(req, resp);
		} catch (Exception e) {
			req.setAttribute(ERRO, ERRO_CONEXAO_KIPREV);
			doGet(req, resp);
		}
	}

}
