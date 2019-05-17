package br.com.kiman.kiprev.ki.xp.dominio.dao;

public interface JPQLs {

	String N_PESSOA_FISICA = "PessoaFisica";

	String Q_PESSOA_FISICA = "SELECT p FROM Pessoa p join fetch p.documentos dc "
			+ "WHERE p.isPessoaFisica = 'S' AND  dc.codTipoDocumento = function('kiprev.pa_utl.f_obt_tipoid_principal','FISICA') "
			+ "  AND p.status = 'A' ";

	String N_SOLICITACAO_PORTABILIDADE = "SolicitacaoPortabilidade";

	String Q_SOLICITACAO_PORTABILIDADE = "SELECT p FROM SolicitacaoPortabilidade p WHERE p.codEmpresa = :codEmpresa AND p.numPortabilidade = :numPortabilidade";

	String N_SOLICITACAO_TRANSFERENCIA = "SolicitacaoTransferencia";

	String Q_SOLICITACAO_TRANSFERENCIA = "SELECT t FROM SolicitacaoTransferencia t WHERE t.codEmpresa = :codEmpresa AND t.numTransferencia = :numTransferencia";

}
