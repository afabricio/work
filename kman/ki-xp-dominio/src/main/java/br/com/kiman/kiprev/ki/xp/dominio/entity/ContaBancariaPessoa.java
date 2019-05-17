package br.com.kiman.kiprev.ki.xp.dominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.ContaBancariaPK;

@Entity
@IdClass(ContaBancariaPK.class)
@Table(name = "PA_CONTAS_X_PESSOA", schema = "KIPREV")
public class ContaBancariaPessoa {

	public static final String SEQUENCE = "KIPREV.S_PA_CONTAS_X_PESSOA";

	@Id
	@Column(name = "COD_PESSOA")
	private String codPessoa;

	@Id
	@Column(name = "COD_CONTABAN")
	private String codContaBancaria;

	@Column(name = "COD_BANCO")
	private String codBanco;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_BANCO", referencedColumnName = "COD_ENTE", insertable = false, updatable = false)
	private EntidadeExterna banco;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_PESSOA", referencedColumnName = "COD_PERSONA", insertable = false, updatable = false)
	private Pessoa pessoa;

	@Column(name = "NUM_CONTA")
	private String numeroConta;

	@Column(name = "NOME_TITULAR")
	private String nomeTitular;

	@Column(name = "DIGITO_VERIFICADOR")
	private String digitoVerificacao;

	@Column(name = "TIP_CONTA_BAN")
	private String tipContaBancaria;

	@Column(name = "NUMERO_AGENCIA")
	private String numeroAgencia;

	@Column(name = "DIGITO_AGENCIA")
	private String digitoAgencia;

	@Column(name = "MG_REMESSA_LINHA")
	private String mgRemessaLinha;

	public String getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(String codPessoa) {
		this.codPessoa = codPessoa;
	}

	public String getCodContaBancaria() {
		return codContaBancaria;
	}

	public void setCodContaBancaria(String codContaBancaria) {
		this.codContaBancaria = codContaBancaria;
	}

	public String getCodBanco() {
		return codBanco;
	}

	public void setCodBanco(String codBanco) {
		this.codBanco = codBanco;
	}

	public EntidadeExterna getBanco() {
		return banco;
	}

	public void setBanco(EntidadeExterna banco) {
		this.banco = banco;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getDigitoVerificacao() {
		return digitoVerificacao;
	}

	public void setDigitoVerificacao(String digitoVerificacao) {
		this.digitoVerificacao = digitoVerificacao;
	}

	public String getTipContaBancaria() {
		return tipContaBancaria;
	}

	public void setTipContaBancaria(String tipContaBancaria) {
		this.tipContaBancaria = tipContaBancaria;
	}

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public String getDigitoAgencia() {
		return digitoAgencia;
	}

	public void setDigitoAgencia(String digitoAgencia) {
		this.digitoAgencia = digitoAgencia;
	}

	public String getMgRemessaLinha() {
		return mgRemessaLinha;
	}

	public void setMgRemessaLinha(String mgRemessaLinha) {
		this.mgRemessaLinha = mgRemessaLinha;
	}

	public boolean comparaConta(String codBanco, String codAgencia,
			String numConta) {
		String padrao = "%s%s%s";
		String formatoPadrao = String.format(padrao, this.getCodBanco(),
				this.getNumeroAgencia(), this.getNumeroConta());
		return formatoPadrao.equals(String.format(padrao, codBanco, codAgencia,
				numConta));
	}

}
