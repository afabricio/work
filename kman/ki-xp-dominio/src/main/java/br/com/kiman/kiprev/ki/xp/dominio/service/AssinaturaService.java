package br.com.kiman.kiprev.ki.xp.dominio.service;

import static br.com.kiman.kiprev.ki.xp.dominio.dao.QueryParameters.with;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.StoredProcedureQuery;

import br.com.kiman.kiprev.ki.xp.dominio.constants.SystemConfEnum;
import br.com.kiman.kiprev.ki.xp.dominio.dao.GenericDAO;
import br.com.kiman.kiprev.ki.xp.dominio.dao.OutMap;
import br.com.kiman.kiprev.ki.xp.dominio.dto.AssinaturaTermoDTO;

@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class AssinaturaService {
	

	@Inject
	private GenericDAO dao;

	public List<AssinaturaTermoDTO>  assinaProposta(String numProposta, String cpfRespFinanceiro, String enderecoIP, String browser) {
		OutMap out = dao.executeProcedure("kpvcust11.pck_db_ki_xp_int036.p_assinatura_proposta",
				with("pcCodEmpresa", SystemConfEnum.DEFAULT_COMPANY.getValue(), String.class)
						.and("pnNumProposta", Long.parseLong(numProposta), Long.class)
						.and("pcCpfRespFinan", cpfRespFinanceiro, String.class)
						.and("pcEnderecoIp", enderecoIP, String.class).and("pcIdBrowser", browser, String.class)
						.out("pcIndValidado", String.class)
						.out("pcIndEfetivado", String.class)
						.out("pcMsgRetorno", String.class));
		
		List<AssinaturaTermoDTO> lista = new ArrayList<AssinaturaTermoDTO>();
		
		AssinaturaTermoDTO dto = new AssinaturaTermoDTO();
		dto.setNumProposta(numProposta);
		dto.setIndValidado(out.getOut("pcIndValidado"));
		dto.setIndEfetivado(out.getOut("pcIndEfetivado"));
		dto.setMsgRetorno(out.getOut("pcMsgRetorno"));
		lista.add(dto);
		
		return lista;
		
	}

	public List<AssinaturaTermoDTO>  assinaTransferencias(String numCertificado, List<String> listNumPortabilidade,
			String cpfRespFinanceiro, String enderecoIP, String browser) {
		
		StoredProcedureQuery procedure = dao.registerProcedure("kpvcust11.pck_db_ki_xp_int036.p_assinatura_transferencia",
				with("pcCodEmpresa", SystemConfEnum.DEFAULT_COMPANY.getValue(), String.class)
						.and("pcNumCertificado", String.class)
						.and("pnNumTransferencia", String.class)
						.and("pcCpfRespFinan", String.class)
						.and("pcEnderecoIp",  String.class)
						.and("pcIdBrowser",  String.class)
						.out("pcIndValidado", String.class)
						.out("pcIndEfetivado", String.class)
						.out("pcMsgRetorno", String.class));
		
		return listNumPortabilidade.stream().map(transferencia->{
			
			OutMap out = dao.executeStoredProcedure(procedure,
					with("pcCodEmpresa", SystemConfEnum.DEFAULT_COMPANY.getValue())
							.and("pcNumCertificado",numCertificado)
							.and("pnNumTransferencia",transferencia)
							.and("pcCpfRespFinan",cpfRespFinanceiro)
							.and("pcEnderecoIp", enderecoIP)
							.and("pcIdBrowser", browser)
							.out("pcIndValidado", String.class)
							.out("pcIndEfetivado", String.class)
							.out("pcMsgRetorno", String.class));
					
			AssinaturaTermoDTO dto = new AssinaturaTermoDTO();	
			dto.setNumCertificado(numCertificado);
			dto.setNumTransferencia(transferencia);
			dto.setIndValidado(out.getOut("pcIndValidado"));
			dto.setIndEfetivado(out.getOut("pcIndEfetivado"));
			dto.setMsgRetorno(out.getOut("pcMsgRetorno"));
			
			return dto;
								
		}).collect(Collectors.toList());
	}

	public List<AssinaturaTermoDTO>  assinaPortabilidades(String numCertificado, List<String> listNumPortabilidade,
			String cpfRespFinanceiro, String enderecoIP, String browser) {
		StoredProcedureQuery procedure = dao.registerProcedure("kpvcust11.pck_db_ki_xp_int036.p_assinatura_portabilidade",
				with("pcCodEmpresa", SystemConfEnum.DEFAULT_COMPANY.getValue(), String.class)
						.and("pcNumCertificado", String.class)
						.and("pnNumPortabilidade", String.class)
						.and("pcCpfRespFinan", String.class)
						.and("pcEnderecoIp",  String.class)
						.and("pcIdBrowser",  String.class)
						.out("pcIndValidado", String.class)
						.out("pcIndEfetivado", String.class)
						.out("pcMsgRetorno", String.class));
					
		return listNumPortabilidade.stream().map(portabilidade->{
			
			OutMap out = dao.executeStoredProcedure(procedure,
					with("pcCodEmpresa", SystemConfEnum.DEFAULT_COMPANY.getValue())
							.and("pcNumCertificado",numCertificado)
							.and("pnNumPortabilidade",portabilidade)
							.and("pcCpfRespFinan",cpfRespFinanceiro)
							.and("pcEnderecoIp", enderecoIP)
							.and("pcIdBrowser", browser)
							.out("pcIndValidado", String.class)
							.out("pcIndEfetivado", String.class)
							.out("pcMsgRetorno", String.class));
			
			AssinaturaTermoDTO dto = new AssinaturaTermoDTO();			
			dto.setNumCertificado(numCertificado);
			dto.setNumPortabilidade(portabilidade);
			dto.setIndValidado(out.getOut("pcIndValidado"));
			dto.setIndEfetivado(out.getOut("pcIndEfetivado"));
			dto.setMsgRetorno(out.getOut("pcMsgRetorno"));
			
			return dto;
				
		}).collect(Collectors.toList());
	}


}
