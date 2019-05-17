package br.com.kiman.kiprev.ki.xp.dominio.facade;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import org.apache.log4j.Logger;

import br.com.kiman.kiprev.ki.xp.dominio.dto.RetornoSimplesDTO;
import br.com.kiman.kiprev.ki.xp.dominio.interceptor.SetaAmbienteInterceptor;
import br.com.kiman.kiprev.ki.xp.dominio.service.GeradorBoletoItauService;
import br.com.kiman.kiprev.ki.xp.integration.itau.BoletoItauRetorno;

@Stateless(name = ItauFacade.NAME_EJB)
@Interceptors(value = { SetaAmbienteInterceptor.class })
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ItauFacade {

	public static final String NAME_EJB = "ItauFacade";

	@Inject
	private GeradorBoletoItauService service;
	
	private static final Logger logger = Logger.getLogger(ItauFacade.class);

	public RetornoSimplesDTO registraBoletoByBoletoID(Long boletoID) {

		RetornoSimplesDTO retorno = new RetornoSimplesDTO();
		
		
		try {
			BoletoItauRetorno boletoRetorno = service.geraBoletoByBoletoID(boletoID);
			
			if(boletoRetorno.getHttpResponseCode() == 200) {
				retorno.setSucesso(true);
			} else {

				
				String msg = boletoRetorno.getRetornoErro().getMensagem();				
				retorno.setSucesso(false);
				retorno.setMensagem(msg);
								
				logger.error("Recusado o registro do boleto "+boletoID+" com a mensagem: "+msg);
				if(boletoRetorno.getRetornoErro().getCampos() != null && boletoRetorno.getRetornoErro().getCodigo() != null) {
					
					logger.error("Código"+boletoRetorno.getRetornoErro().getCodigo() );
					boletoRetorno.getRetornoErro().getCampos().stream().forEach(c-> logger.error(c.getCampo()+":"+c.getValor()+" -> "+c.getMensagem()));
					
					
				}
			}
			
		} catch (Exception e) {

			retorno.setSucesso(false);
			retorno.setMensagem(e.getMessage());
			
			logger.error("Erro ao realizar o registro do boleto "+boletoID+". ", e);

		}
		return retorno;
	}

}
