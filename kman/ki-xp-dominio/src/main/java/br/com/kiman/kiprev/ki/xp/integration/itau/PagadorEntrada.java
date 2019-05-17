package br.com.kiman.kiprev.ki.xp.integration.itau;

import java.util.List;

public class PagadorEntrada {
	private String cpf_cnpj_pagador;
	private String nome_pagador;
	private String logradouro_pagador;
	private String bairro_pagador;
	private String cidade_pagador;
	private String uf_pagador;
	private String cep_pagador;
	private List<Grupo_email_pagador> grupo_email_pagador;
	public String getCpf_cnpj_pagador() {
		return cpf_cnpj_pagador;
	}
	public void setCpf_cnpj_pagador(String cpf_cnpj_pagador) {
		this.cpf_cnpj_pagador = cpf_cnpj_pagador;
	}
	public String getNome_pagador() {
		return nome_pagador;
	}
	public void setNome_pagador(String nome_pagador) {
		this.nome_pagador = nome_pagador;
	}
	public String getLogradouro_pagador() {
		return logradouro_pagador;
	}
	public void setLogradouro_pagador(String logradouro_pagador) {
		this.logradouro_pagador = logradouro_pagador;
	}
	public String getBairro_pagador() {
		return bairro_pagador;
	}
	public void setBairro_pagador(String bairro_pagador) {
		this.bairro_pagador = bairro_pagador;
	}
	public String getCidade_pagador() {
		return cidade_pagador;
	}
	public void setCidade_pagador(String cidade_pagador) {
		this.cidade_pagador = cidade_pagador;
	}
	public String getUf_pagador() {
		return uf_pagador;
	}
	public void setUf_pagador(String uf_pagador) {
		this.uf_pagador = uf_pagador;
	}
	public String getCep_pagador() {
		return cep_pagador;
	}
	public void setCep_pagador(String cep_pagador) {
		this.cep_pagador = cep_pagador;
	}
	public List<Grupo_email_pagador> getGrupo_email_pagador() {
		return grupo_email_pagador;
	}
	public void setGrupo_email_pagador(List<Grupo_email_pagador> grupo_email_pagador) {
		this.grupo_email_pagador = grupo_email_pagador;
	}
	
	
	




}
