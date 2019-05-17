package br.com.kiman.kiprev.ki.xp.dominio.interceptor;

import static br.com.kiman.kiprev.ki.xp.dominio.dao.QueryParameters.with;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import br.com.kiman.kiprev.ki.xp.dominio.constants.SystemConfEnum;
import br.com.kiman.kiprev.ki.xp.dominio.dao.GenericDAO;

public class SetaAmbienteInterceptor {

	
	@Inject
	private GenericDAO dao;

	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {
		
		dao.executeProcedure("KPVCUST11.PCK_DB_KI_UTIL.P_SETA_AMBIENTE", 
				with("pcEmpresa",SystemConfEnum.DEFAULT_COMPANY.getValue(),String.class)
				.and("pcAgencia", SystemConfEnum.DEFAULT_AGENCY.getValue(),String.class));
		
		
		
		return context.proceed();
	}
}




