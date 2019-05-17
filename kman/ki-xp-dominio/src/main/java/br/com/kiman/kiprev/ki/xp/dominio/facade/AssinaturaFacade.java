package br.com.kiman.kiprev.ki.xp.dominio.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import br.com.kiman.kiprev.ki.xp.dominio.dto.AssinaturaTermoDTO;
import br.com.kiman.kiprev.ki.xp.dominio.exception.NegocioException;
import br.com.kiman.kiprev.ki.xp.dominio.interceptor.SetaAmbienteInterceptor;
import br.com.kiman.kiprev.ki.xp.dominio.service.AssinaturaService;

@Stateless(name = "AssinaturaFacade", mappedName = "ejb/AssinaturaFacade")
@Interceptors(value = { SetaAmbienteInterceptor.class })
public class AssinaturaFacade {

	@Inject
	private AssinaturaService service;

	public List<AssinaturaTermoDTO> assinaTermo(String numProposta, String numCertificado,
			List<String> listNumPortabilidade, List<String> listNumTransferencia, String cpfRespFinanceiro,
			String enderecoIP, String browser) {

		if (numProposta != null && !numProposta.isEmpty() ) {
			
			return service.assinaProposta(numProposta, cpfRespFinanceiro, enderecoIP, browser);
			
		} else if (numCertificado != null && !numCertificado.isEmpty()) {
			
			boolean foundList = false;
			
			List<AssinaturaTermoDTO> listaDTO = new ArrayList<AssinaturaTermoDTO>();

			if (listNumPortabilidade != null && !listNumPortabilidade.isEmpty()) {

				foundList=true;
				listaDTO .addAll(service.assinaPortabilidades(numCertificado, listNumPortabilidade, cpfRespFinanceiro, enderecoIP,
						browser));

			}

			if (listNumTransferencia != null && !listNumTransferencia.isEmpty()) {
				foundList=true;
				listaDTO .addAll(service.assinaTransferencias(numCertificado, listNumTransferencia, cpfRespFinanceiro, enderecoIP,
						browser));

			}
			
			
			
			if (foundList) {
				return listaDTO;
			}else {
				
				throw new NegocioException("É necessário informar itens da portabilidade ou transferencia ");
			}

			

		}

		throw new NegocioException("É necessário informar o numero da proposta ou certificado ");

	}

}
