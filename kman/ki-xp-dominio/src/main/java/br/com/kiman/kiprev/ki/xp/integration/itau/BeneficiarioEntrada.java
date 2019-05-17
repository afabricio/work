package br.com.kiman.kiprev.ki.xp.integration.itau;

import com.google.common.base.Strings;

public class BeneficiarioEntrada {
	public String cpf_cnpj_beneficiario;
	public String agencia_beneficiario;
	public String conta_beneficiario;
	public String digito_verificador_conta_beneficiario;

	public BeneficiarioEntrada(String cpf_cnpj_beneficiario, String agencia_beneficiario, String conta_beneficiario,
			String digito_verificador_conta_beneficiario) {
		setCpf_cnpj_beneficiario(cpf_cnpj_beneficiario);
		setAgencia_beneficiario(agencia_beneficiario);
		setConta_beneficiario(conta_beneficiario);
		setDigito_verificador_conta_beneficiario(digito_verificador_conta_beneficiario);
	}

	public BeneficiarioEntrada() {
	}

	public String getCpf_cnpj_beneficiario() {
		return cpf_cnpj_beneficiario;
	}

	public void setCpf_cnpj_beneficiario(String cpf_cnpj_beneficiario) {
		this.cpf_cnpj_beneficiario = cpf_cnpj_beneficiario;
	}

	public String getAgencia_beneficiario() {
		return agencia_beneficiario;
	}

	public void setAgencia_beneficiario(String agencia_beneficiario) {
		this.agencia_beneficiario = agencia_beneficiario;
	}

	public String getConta_beneficiario() {
		return conta_beneficiario;
	}

	public void setConta_beneficiario(String conta_beneficiario) {
		this.conta_beneficiario = Strings.padStart(conta_beneficiario, 7, '0');
	}

	public String getDigito_verificador_conta_beneficiario() {
		return digito_verificador_conta_beneficiario;
	}

	public void setDigito_verificador_conta_beneficiario(String digito_verificador_conta_beneficiario) {
		this.digito_verificador_conta_beneficiario = digito_verificador_conta_beneficiario;
	}

}