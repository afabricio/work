package br.com.kiman.kiprev.ki.xp.integration.folheterias;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.kiman.kiprev.ki.xp.dominio.adapter.ZDateAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Proposal {

	@XmlElement(name = "proposalCode")
	private String proposalCode = null;

	@XmlElement(name = "proposalStatus")
	private Integer proposalStatus = null;

	@XmlElement(name = "proposalStatusDate")
	@XmlJavaTypeAdapter(ZDateAdapter.class)
	private Date proposalStatusDate = null;

	@XmlElement(name = "plan")
	private Plan plan = null;

	@XmlElement(name = "insured")
	private Insured insured = null;

	@XmlElement(name = "portabilities")
	private List<Portability> portabilities = null;

	@XmlElement(name = "beneficiaries")
	private List<Beneficiary> beneficiaries = null;

	@XmlElement(name = "paymentData")
	private PaymentData paymentData = null;

	public Proposal proposalCode(String proposalCode) {
		this.proposalCode = proposalCode;
		return this;
	}

	public String getProposalCode() {
		return proposalCode;
	}

	public void setProposalCode(String proposalCode) {
		this.proposalCode = proposalCode;
	}

	public Proposal proposalStatus(Integer proposalStatus) {
		this.proposalStatus = proposalStatus;
		return this;
	}

	public Integer getProposalStatus() {
		return proposalStatus;
	}

	public void setProposalStatus(Integer proposalStatus) {
		this.proposalStatus = proposalStatus;
	}

	public Proposal proposalStatusDate(Date proposalStatusDate) {
		this.proposalStatusDate = proposalStatusDate;
		return this;
	}

	public Date getProposalStatusDate() {
		return proposalStatusDate;
	}

	public void setProposalStatusDate(Date proposalStatusDate) {
		this.proposalStatusDate = proposalStatusDate;
	}

	public Proposal plan(Plan plan) {
		this.plan = plan;
		return this;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Proposal insured(Insured insured) {
		this.insured = insured;
		return this;
	}

	public Insured getInsured() {
		return insured;
	}

	public void setInsured(Insured insured) {
		this.insured = insured;
	}

	public Proposal portabilities(List<Portability> portabilities) {
		this.portabilities = portabilities;
		return this;
	}

	public Proposal addPortabilitiesItem(Portability portabilitiesItem) {
		if (this.portabilities == null) {
			this.portabilities = new ArrayList<Portability>();
		}
		this.portabilities.add(portabilitiesItem);
		return this;
	}

	public List<Portability> getPortabilities() {
		return portabilities;
	}

	public void setPortabilities(List<Portability> portabilities) {
		this.portabilities = portabilities;
	}

	public Proposal beneficiaries(List<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
		return this;
	}

	public Proposal addBeneficiariesItem(Beneficiary beneficiariesItem) {
		if (this.beneficiaries == null) {
			this.beneficiaries = new ArrayList<Beneficiary>();
		}
		this.beneficiaries.add(beneficiariesItem);
		return this;
	}

	public List<Beneficiary> getBeneficiaries() {
		return beneficiaries;
	}

	public void setBeneficiaries(List<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	public Proposal paymentData(PaymentData paymentData) {
		this.paymentData = paymentData;
		return this;
	}

	public PaymentData getPaymentData() {
		return paymentData;
	}

	public void setPaymentData(PaymentData paymentData) {
		this.paymentData = paymentData;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Proposal proposal = (Proposal) o;
		return Objects.equals(this.proposalCode, proposal.proposalCode)
				&& Objects.equals(this.proposalStatus, proposal.proposalStatus)
				&& Objects.equals(this.proposalStatusDate, proposal.proposalStatusDate)
				&& Objects.equals(this.plan, proposal.plan) && Objects.equals(this.insured, proposal.insured)
				&& Objects.equals(this.portabilities, proposal.portabilities)
				&& Objects.equals(this.beneficiaries, proposal.beneficiaries)
				&& Objects.equals(this.paymentData, proposal.paymentData);
	}

	@Override
	public int hashCode() {
		return Objects.hash(proposalCode, proposalStatus, proposalStatusDate, plan, insured, portabilities,
				beneficiaries, paymentData);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Proposal {\n");

		sb.append("    proposalCode: ").append(toIndentedString(proposalCode)).append("\n");
		sb.append("    proposalStatus: ").append(toIndentedString(proposalStatus)).append("\n");
		sb.append("    proposalStatusDate: ").append(toIndentedString(proposalStatusDate)).append("\n");
		sb.append("    plan: ").append(toIndentedString(plan)).append("\n");
		sb.append("    insured: ").append(toIndentedString(insured)).append("\n");
		sb.append("    portabilities: ").append(toIndentedString(portabilities)).append("\n");
		sb.append("    beneficiaries: ").append(toIndentedString(beneficiaries)).append("\n");
		sb.append("    paymentData: ").append(toIndentedString(paymentData)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
