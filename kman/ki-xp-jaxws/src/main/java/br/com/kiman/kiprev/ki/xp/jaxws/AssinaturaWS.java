package br.com.kiman.kiprev.ki.xp.jaxws;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.interceptor.InInterceptors;

import br.com.kiman.kiprev.ki.xp.dominio.dto.AssinaturaTermoDTO;
import br.com.kiman.kiprev.ki.xp.dominio.facade.AssinaturaFacade;

@WebService
@InInterceptors(interceptors = { "br.com.kiman.kiprev.ki.xp.jaxws.interceptor.WSSecurityInterceptor" })
public class AssinaturaWS {

	@EJB(mappedName = "ejb/AssinaturaFacade")
	AssinaturaFacade facade;

	@WebMethod
	public List<AssinaturaTermoPropostaResult> assinaTermo(@WebParam(name = "numProposta") String numProposta,
			@WebParam(name = "numCertificado") String numCertificado,
			@WebParam(name = "numPortabilidade") List<String> listNumPortabilidade,
			@WebParam(name = "numTransferencia") List<String> listNumTransferencia,
			@WebParam(name = "cpfRespFinanceiro") String cpfRespFinanceiro,
			@WebParam(name = "enderecoIp") String enderecoIp, @WebParam(name = "browser") String browser) {


		List<AssinaturaTermoDTO> listaDTO = facade.assinaTermo(numProposta, numCertificado, listNumPortabilidade,
				listNumTransferencia, cpfRespFinanceiro, enderecoIp, browser);

		return buildResult(listaDTO);

	}

	private List<AssinaturaTermoPropostaResult> buildResult(List<AssinaturaTermoDTO> listaDTO) {

		List<AssinaturaTermoPropostaResult> resultLista = new ArrayList<AssinaturaTermoPropostaResult>();

		for (AssinaturaTermoDTO dto : listaDTO) {
			AssinaturaTermoPropostaResult result = new AssinaturaTermoPropostaResult();
			result.setIndEfetivado(dto.getIndEfetivado());
			result.setIndValidado(dto.getIndValidado());
			result.setMsgRetorno(dto.getMsgRetorno());
			result.setNumCertificado(dto.getNumCertificado());
			result.setNumPortabilidade(dto.getNumPortabilidade());
			result.setNumProposta(dto.getNumProposta());
			result.setNumTransferencia(dto.getNumTransferencia());

			resultLista.add(result);
		}

		return resultLista;

	}

}
