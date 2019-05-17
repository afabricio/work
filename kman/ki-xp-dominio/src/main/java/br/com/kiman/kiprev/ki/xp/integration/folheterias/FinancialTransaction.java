package br.com.kiman.kiprev.ki.xp.integration.folheterias;

import java.util.Date;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.kiman.kiprev.ki.xp.dominio.adapter.ZDateAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FinancialTransaction {

	@XmlElement(name = "transactionType")
	private Integer transactionType = null;
	@XmlElement(name = "transactionId")
	private String transactionId = null;
	@XmlElement(name = "transactionStatus")
	private Integer transactionStatus = null;
	@XmlElement(name = "transactionStatusDate")
	@XmlJavaTypeAdapter(ZDateAdapter.class)
	private Date transactionStatusDate = null;
	@XmlElement(name = "paymentData")
	private PaymentData paymentData = null;

	public FinancialTransaction transactionType(Integer transactionType) {
		this.transactionType = transactionType;
		return this;
	}

	public Integer getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(Integer transactionType) {
		this.transactionType = transactionType;
	}

	public FinancialTransaction transactionId(String transactionId) {
		this.transactionId = transactionId;
		return this;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public FinancialTransaction transactionStatus(Integer transactionStatus) {
		this.transactionStatus = transactionStatus;
		return this;
	}

	public Integer getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(Integer transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public FinancialTransaction transactionStatusDate(Date transactionStatusDate) {
		this.transactionStatusDate = transactionStatusDate;
		return this;
	}

	public Date getTransactionStatusDate() {
		return transactionStatusDate;
	}

	public void setTransactionStatusDate(Date transactionStatusDate) {
		this.transactionStatusDate = transactionStatusDate;
	}

	public FinancialTransaction paymentData(PaymentData paymentData) {
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
		FinancialTransaction financialTransaction = (FinancialTransaction) o;
		return Objects.equals(this.transactionType, financialTransaction.transactionType)
				&& Objects.equals(this.transactionId, financialTransaction.transactionId)
				&& Objects.equals(this.transactionStatus, financialTransaction.transactionStatus)
				&& Objects.equals(this.transactionStatusDate, financialTransaction.transactionStatusDate)
				&& Objects.equals(this.paymentData, financialTransaction.paymentData);
	}

	@Override
	public int hashCode() {
		return Objects.hash(transactionType, transactionId, transactionStatus, transactionStatusDate, paymentData);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class FinancialTransaction {\n");

		sb.append("    transactionType: ").append(toIndentedString(transactionType)).append("\n");
		sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
		sb.append("    transactionStatus: ").append(toIndentedString(transactionStatus)).append("\n");
		sb.append("    transactionStatusDate: ").append(toIndentedString(transactionStatusDate)).append("\n");
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
