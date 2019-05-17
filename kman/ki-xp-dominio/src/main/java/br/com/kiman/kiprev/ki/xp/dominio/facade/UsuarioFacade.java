package br.com.kiman.kiprev.ki.xp.dominio.facade;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import br.com.kiman.kiprev.ki.xp.dominio.autenticacao.AutenticadorAD;
import br.com.kiman.kiprev.ki.xp.dominio.dao.GenericDAO;
import br.com.kiman.kiprev.ki.xp.dominio.entity.UsuarioKiprev;
import br.com.kiman.kiprev.ki.xp.dominio.exception.NegocioException;
import br.com.kiman.kiprev.ki.xp.dominio.interceptor.SetaAmbienteInterceptor;

@Stateless
@Interceptors(value = { SetaAmbienteInterceptor.class })
public class UsuarioFacade {

	private static final String USUARIO_SEM_PERFIL = "Usuário não possui perfil cadastrado no kiprev.";
	private static final String USUARIO_INATIVO = "Usuário inativo no kiprev.";
	private static final String USUARIO_NAO_ENCONTRADO = "Usuário não encontrado no kiprev.";

	@Inject
	private AutenticadorAD autenticadorAD;

	@Inject
	private GenericDAO genericDAO;

	public UsuarioKiprev validaUsuario(String codUsuario) {
		codUsuario = Optional.ofNullable(codUsuario).map(u -> u.toUpperCase()).orElse("");
		UsuarioKiprev usuario = genericDAO.find(codUsuario, UsuarioKiprev.class);
		if (usuario == null) {
			throw new NegocioException(USUARIO_NAO_ENCONTRADO);
		}
		if (usuario.isInativo()) {
			throw new NegocioException(USUARIO_INATIVO);
		}
		if (usuario.getRoles().isEmpty()) {
			throw new NegocioException(USUARIO_SEM_PERFIL);
		}
		return usuario;
	}

	public UsuarioKiprev autenticaModuloRelatorioGerencial(String codUsuario, String senha) {
		autenticadorAD.autentica(codUsuario, senha);
		UsuarioKiprev usuario = validaUsuario(codUsuario);

		usuario.setToken(GeradorToken.geraToken(codUsuario));
		return usuario;
	}

}
