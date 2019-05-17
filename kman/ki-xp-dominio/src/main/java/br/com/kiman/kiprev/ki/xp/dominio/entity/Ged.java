package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.util.FileCopyUtils;

import br.com.kiman.kiprev.ki.xp.dominio.constants.StatusGed;
import br.com.kiman.kiprev.ki.xp.dominio.constants.TipoLocalArquivoGed;
import br.com.kiman.kiprev.ki.xp.dominio.exception.NegocioException;

@Entity
@Table(schema = "KPVCUST11", name = "INT_031_GED")
@NamedQuery(name = Ged.BUSCA_TODOS_POR_STATUS, query = "SELECT g FROM Ged g WHERE g.status = :pStatus ")
public class Ged {

	public static final String BUSCA_TODOS_POR_STATUS = "Ged.buscaTodosStatus";

	@Id
	@Column(name = "ID_GED")
	private Long id;
	@Column(name = "NUM_DOCTO_CLIENTE")
	private String numDoctoCliente;
	@Column(name = "TIP_ARQUIVO")
	private Long tipoArquivo;
	@Column(name = "NUM_DOCUMENTO")
	private String numDocumento;
	@Lob
	@Column(name = "ARQUIVO")
	private String arquivo;
	@Column(name = "URL_ARQUIVO")
	private String urlArquivo;
	@Column(name = "DIRETORIO_ARQUIVO")
	private String diretorioArquivo;
	@Column(name = "TIP_LOCAL_ARQUIVO")
	private TipoLocalArquivoGed tipoLocalArquivo;
	@Column(name = "EXT_ARQUIVO")
	private String extensaoArquivo;
	@Column(name = "MENSAGEM_ERRO")
	private String mensagemErro;
	@Column(name = "STATUS")
	private StatusGed status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumDoctoCliente() {
		return numDoctoCliente;
	}

	public void setNumDoctoCliente(String numDoctoCliente) {
		this.numDoctoCliente = numDoctoCliente;
	}

	public Long getTipoArquivo() {
		return tipoArquivo;
	}

	public void setTipoArquivo(Long tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public String getUrlArquivo() {
		return urlArquivo;
	}

	public void setUrlArquivo(String urlArquivo) {
		this.urlArquivo = urlArquivo;
	}

	public String getDiretorioArquivo() {
		return diretorioArquivo;
	}

	public void setDiretorioArquivo(String diretorioArquivo) {
		this.diretorioArquivo = diretorioArquivo;
	}

	public TipoLocalArquivoGed getTipoLocalArquivo() {
		return tipoLocalArquivo;
	}

	public void setTipoLocalArquivo(TipoLocalArquivoGed tipoLocalArquivo) {
		this.tipoLocalArquivo = tipoLocalArquivo;
	}

	public String getExtensaoArquivo() {
		return extensaoArquivo;
	}

	public void setExtensaoArquivo(String extensaoArquivo) {
		this.extensaoArquivo = extensaoArquivo;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

	public StatusGed getStatus() {
		return status;
	}

	public void setStatus(StatusGed status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).build();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Ged) {
			Ged other = (Ged) obj;
			return new EqualsBuilder().append(id, other.id).build();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.SHORT_PREFIX_STYLE).append("id", id).build();
	}

	public void setArquivoBase64(InputStream inputStream) {

		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			FileCopyUtils.copy(inputStream, out);
			String arquivoBase64 = Base64.encodeBase64String(out.toByteArray());
			out.close();
			arquivo = arquivoBase64;
		} catch (Exception e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

}
