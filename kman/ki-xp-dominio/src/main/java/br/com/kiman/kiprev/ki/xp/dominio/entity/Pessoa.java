package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.collect.Sets;

import br.com.kiman.kiprev.ki.xp.dominio.constants.TipoMeioPagamento;
import br.com.kiman.kiprev.ki.xp.dominio.dao.JPQLs;
import br.com.kiman.kiprev.ki.xp.dominio.service.CnpjVO;
import br.com.kiman.kiprev.ki.xp.dominio.service.CpfVO;
import br.com.kiman.kiprev.ki.xp.dominio.service.DocumentoVO;



@Entity
@Table(name = "PERSONAS", schema = "KIPREV")
//@NamedQueries(value = {
//		@NamedQuery(name = JPQLs.N_PESSOA, query = JPQLs.Q_PESSOA),
//		@NamedQuery(name = JPQLs.N_PESSOA_POR_DOCUMENTO, query = JPQLs.Q_PESSOA_POR_DOCUMENTO) })
@NamedQuery(name = JPQLs.N_PESSOA_FISICA, query = JPQLs.Q_PESSOA_FISICA)
public class Pessoa {

	@Id
	@Column(name = "COD_PERSONA")
	private String codPessoa;
	@Column(name = "NOMBRE")
	private String nome;
	
	@Column(name = "STATUS")
	private String status;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_PERSONA", referencedColumnName = "COD_PERSONA", insertable = false, updatable = false)
	private Set<Documento> documentos = Sets.newHashSet();
	@Column(name = "ES_FISICA")
	private String isPessoaFisica;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_PERSONA", referencedColumnName = "COD_PER_FISICA", insertable = false, updatable = false)
	private PessoaFisica pessoaFisica;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_PERSONA", referencedColumnName = "COD_PER_JURIDICA", insertable = false, updatable = false)
	private PessoaJuridica pessoaJuridica;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_PESSOA", referencedColumnName = "COD_PERSONA", insertable = false, updatable = false)
	private List<ContaBancariaPessoa> listaContaBancaria;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
	private List<Conta> contas;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_PESSOA", referencedColumnName = "COD_PERSONA", insertable = false, updatable = false)
	private Set<CanalPagamentoPessoa> canaisPagamento = Sets.newHashSet();
	
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_PESSOA", referencedColumnName = "COD_PERSONA", insertable = false, updatable = false)
	private Set<EmailPessoa> emails = Sets.newHashSet();



	public String getIsPessoaFisica() {
		return isPessoaFisica;
	}

	public void setIsPessoaFisica(String isPessoaFisica) {
		this.isPessoaFisica = isPessoaFisica;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public List<ContaBancariaPessoa> getListaContaBancaria() {
		return listaContaBancaria;
	}

	public void setListaContaBancaria(
			List<ContaBancariaPessoa> listaContaBancaria) {
		this.listaContaBancaria = listaContaBancaria;
	}

	public String getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(String codPessoa) {
		this.codPessoa = codPessoa;
	}

	public String getNome() {
		return nome;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public Set<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(Set<Documento> documentos) {
		this.documentos = documentos;
	}

	
	
	

	public CpfVO getCPF() {
		Documento documento = documentos.stream().filter(d -> d.isCPF())
				.findFirst().orElse(null);
		return documento != null ? new CpfVO(documento.getNumDocumento(), false)
				: null;
	}

	public CnpjVO getCNPJ() {
		Documento documento = documentos.stream().filter(d -> d.isCNPJ())
				.findFirst().orElse(null);
		return documento != null ? new CnpjVO(documento.getNumDocumento(),
				false) : null;
	}

	public Set<CanalPagamentoPessoa> getCanaisPagamento() {
		return Collections.unmodifiableSet(canaisPagamento);
	}

	public CanalPagamentoPessoa getCanalDePagamentoPor(
			TipoMeioPagamento tipoMeioPagamento) {
		return getCanaisPagamentoTipo(tipoMeioPagamento).stream().findFirst()
				.orElse(null);
	}

	public List<CanalPagamentoPessoa> getCanaisPagamentoTipo(
			TipoMeioPagamento tipoMeioPagamento) {
		return getCanaisPagamento()
				.stream()
				.filter(c -> c.getCanalPagamento().getCodMeioPagamento()
						.equals(tipoMeioPagamento))
				.sorted((canal1, canal2) -> canal2.getCodCanal().compareTo(
						canal1.getCodCanal())).collect(Collectors.toList());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pessoa) {
			Pessoa other = (Pessoa) obj;
			return new EqualsBuilder().append(codPessoa, other.codPessoa)
					.build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codPessoa).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(codPessoa).build();
	}

	public void hasEndereco(String cep, String logradouro, String numero,
			String bairro) {

	}

	public CanalPagamentoPessoa getCanalPagamentoEndereco(String cep,
			String logradouro, String numero, String bairro) {
		return getCanaisPagamentoTipo(TipoMeioPagamento.FICHA)
				.stream()
				.filter(e -> e.getEnderecoPessoa().comparaDadosEndereco(cep,
						logradouro, numero, bairro)).findFirst().orElse(null);
	}

	public CanalPagamentoPessoa getCanalPagamentoDebito(String codBanco,
			String codAgencia, String numConta) {
		return getCanaisPagamentoTipo(TipoMeioPagamento.DEBITO)
				.stream()
				.filter(c -> c.getContaBancariaPessoa() != null
						&& c.getContaBancariaPessoa().comparaConta(codBanco,
								codAgencia, numConta)).findFirst().orElse(null);

	}

	
	public String getEmailPrincipal() {
		EmailPessoa email = emails
				.stream()
				.sorted(Comparator.comparing(EmailPessoa::getCodigoEmail).reversed())
				.findFirst().orElse(null);
		
		return email != null ? email.getEmail() : null;
	}
	
	public Set<EmailPessoa> getEmails() {
		return emails;
	}

	public void setEmails(Set<EmailPessoa> emails) {
		this.emails = emails;
	}

	public DocumentoVO getDocumentoPrincipal() {
		if ("S".equals(isPessoaFisica)) {
			return getCPF();
		} else {
			return getCNPJ();
		}
	}

	public boolean hasCanalPagamento(TipoMeioPagamento formaPagamento) {
		return getCanalDePagamentoPor(formaPagamento) != null;
	}
}
