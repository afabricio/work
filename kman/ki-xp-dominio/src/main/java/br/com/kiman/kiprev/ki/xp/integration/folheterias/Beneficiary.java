package br.com.kiman.kiprev.ki.xp.integration.folheterias;

import java.math.BigDecimal;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Beneficiary {

	@XmlElement(name = "beneficiaryName")
	private String beneficiaryName = null;

	@XmlElement(name = "relationshipDegree")
	private Integer relationshipDegree = null;

	@XmlElement(name = "participationPercentage")
	private BigDecimal participationPercentage = null;

	public Beneficiary beneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
		return this;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public Beneficiary relationshipDegree(Integer relationshipDegree) {
		this.relationshipDegree = relationshipDegree;
		return this;
	}

	public Integer getRelationshipDegree() {
		return relationshipDegree;
	}

	public void setRelationshipDegree(Integer relationshipDegree) {
		this.relationshipDegree = relationshipDegree;
	}

	public Beneficiary participationPercentage(BigDecimal participationPercentage) {
		this.participationPercentage = participationPercentage;
		return this;
	}

	public BigDecimal getParticipationPercentage() {
		return participationPercentage;
	}

	public void setParticipationPercentage(BigDecimal participationPercentage) {
		this.participationPercentage = participationPercentage;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Beneficiary beneficiary = (Beneficiary) o;
		return Objects.equals(this.beneficiaryName, beneficiary.beneficiaryName)
				&& Objects.equals(this.relationshipDegree, beneficiary.relationshipDegree)
				&& Objects.equals(this.participationPercentage, beneficiary.participationPercentage);
	}

	@Override
	public int hashCode() {
		return Objects.hash(beneficiaryName, relationshipDegree, participationPercentage);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Beneficiary {\n");

		sb.append("    beneficiaryName: ").append(toIndentedString(beneficiaryName)).append("\n");
		sb.append("    relationshipDegree: ").append(toIndentedString(relationshipDegree)).append("\n");
		sb.append("    participationPercentage: ").append(toIndentedString(participationPercentage)).append("\n");
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
