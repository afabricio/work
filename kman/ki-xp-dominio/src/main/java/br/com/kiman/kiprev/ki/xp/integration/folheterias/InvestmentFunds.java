package br.com.kiman.kiprev.ki.xp.integration.folheterias;

import java.math.BigDecimal;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class InvestmentFunds {

	@XmlElement(name = "name")
	private String name = null;
	@XmlElement(name = "document")
	private String document = null;
	@XmlElement(name = "distributionPercentage")
	private BigDecimal distributionPercentage = null;

	public InvestmentFunds name(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public InvestmentFunds document(String document) {
		this.document = document;
		return this;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public InvestmentFunds distributionPercentage(BigDecimal distributionPercentage) {
		this.distributionPercentage = distributionPercentage;
		return this;
	}

	public BigDecimal getDistributionPercentage() {
		return distributionPercentage;
	}

	public void setDistributionPercentage(BigDecimal distributionPercentage) {
		this.distributionPercentage = distributionPercentage;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		InvestmentFunds investmentFunds = (InvestmentFunds) o;
		return Objects.equals(this.name, investmentFunds.name)
				&& Objects.equals(this.document, investmentFunds.document)
				&& Objects.equals(this.distributionPercentage, investmentFunds.distributionPercentage);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, document, distributionPercentage);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class InvestmentFunds {\n");

		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    document: ").append(toIndentedString(document)).append("\n");
		sb.append("    distributionPercentage: ").append(toIndentedString(distributionPercentage)).append("\n");
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
