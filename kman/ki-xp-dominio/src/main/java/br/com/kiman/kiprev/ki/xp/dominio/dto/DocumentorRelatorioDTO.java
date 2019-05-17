package br.com.kiman.kiprev.ki.xp.dominio.dto;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;

public class DocumentorRelatorioDTO {

	private String documentoBase64;
	private List<String> numPortabilidades;
	private List<Long> numTransferencias;

	public String getDocumentoBase64() {
		return Optional.ofNullable(documentoBase64).orElse("");
	}

	public void setDocumentoBase64(String documentoBase64) {
		this.documentoBase64 = documentoBase64;
	}

	public List<String> getNumPortabilidades() {
		return Optional.ofNullable(numPortabilidades).orElse(Lists.newArrayList());
	}

	public void setNumPortabilidades(List<String> numPortabilidades) {
		this.numPortabilidades = numPortabilidades;
	}

	public List<Long> getNumTransferencias() {
		return Optional.ofNullable(numTransferencias).orElse(Lists.newArrayList());
	}

	public void setNumTransferencias(List<Long> numTransferencias) {
		this.numTransferencias = numTransferencias;
	}

}
