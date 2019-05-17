package br.com.kiman.kiprev.ki.xp.integration.folheterias;

import java.math.BigDecimal;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CertificateBalance {

	@XmlElement(name = "value")
	private BigDecimal value = null;

	@XmlElement(name = "quotaQuantity")
	private BigDecimal quotaQuantity = null;

	@XmlElement(name = "quotaValue")
	private BigDecimal quotaValue = null;

	@XmlElement(name = "investmentFundDocument")
	private String investmentFundDocument = null;

	public CertificateBalance value(BigDecimal value) {
		this.value = value;
		return this;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public CertificateBalance quotaQuantity(BigDecimal quotaQuantity) {
		this.quotaQuantity = quotaQuantity;
		return this;
	}

	public BigDecimal getQuotaQuantity() {
		return quotaQuantity;
	}

	public void setQuotaQuantity(BigDecimal quotaQuantity) {
		this.quotaQuantity = quotaQuantity;
	}

	public CertificateBalance quotaValue(BigDecimal quotaValue) {
		this.quotaValue = quotaValue;
		return this;
	}

	public BigDecimal getQuotaValue() {
		return quotaValue;
	}

	public void setQuotaValue(BigDecimal quotaValue) {
		this.quotaValue = quotaValue;
	}

	public CertificateBalance investmentFundDocument(String investmentFundDocument) {
		this.investmentFundDocument = investmentFundDocument;
		return this;
	}

	public String getInvestmentFundDocument() {
		return investmentFundDocument;
	}

	public void setInvestmentFundDocument(String investmentFundDocument) {
		this.investmentFundDocument = investmentFundDocument;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CertificateBalance certificateBalance = (CertificateBalance) o;
		return Objects.equals(this.value, certificateBalance.value)
				&& Objects.equals(this.quotaQuantity, certificateBalance.quotaQuantity)
				&& Objects.equals(this.quotaValue, certificateBalance.quotaValue)
				&& Objects.equals(this.investmentFundDocument, certificateBalance.investmentFundDocument);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, quotaQuantity, quotaValue, investmentFundDocument);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CertificateBalance {\n");

		sb.append("    value: ").append(toIndentedString(value)).append("\n");
		sb.append("    quotaQuantity: ").append(toIndentedString(quotaQuantity)).append("\n");
		sb.append("    quotaValue: ").append(toIndentedString(quotaValue)).append("\n");
		sb.append("    investmentFundDocument: ").append(toIndentedString(investmentFundDocument)).append("\n");
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
