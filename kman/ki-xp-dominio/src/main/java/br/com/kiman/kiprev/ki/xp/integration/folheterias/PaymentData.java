
package br.com.kiman.kiprev.ki.xp.integration.folheterias;

import java.math.BigDecimal;
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
public class PaymentData {

	@XmlElement(name = "paymentType")
	private Integer paymentType = null;

	@XmlElement(name = "paymentMethod")
	private String paymentMethod = null;

	@XmlElement(name = "value")
	private BigDecimal value = null;

	@XmlElement(name = "requestDate")
	@XmlJavaTypeAdapter(ZDateAdapter.class)
	private Date requestDate = null;

	@XmlElement(name = "settlementDate")
	@XmlJavaTypeAdapter(ZDateAdapter.class)
	private Date settlementDate = null;

	@XmlElement(name = "investmentFunds")
	private List<String> investmentFunds = null;

	public PaymentData paymentType(Integer paymentType) {
		this.paymentType = paymentType;
		return this;
	}

	public Integer getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}

	public PaymentData paymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
		return this;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public PaymentData value(BigDecimal value) {
		this.value = value;
		return this;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public PaymentData requestDate(Date requestDate) {
		this.requestDate = requestDate;
		return this;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public PaymentData settlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
		return this;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public PaymentData investmentFunds(List<String> investmentFunds) {
		this.investmentFunds = investmentFunds;
		return this;
	}

	public PaymentData addInvestmentFundsItem(String investmentFundsItem) {
		if (this.investmentFunds == null) {
			this.investmentFunds = new ArrayList<String>();
		}
		this.investmentFunds.add(investmentFundsItem);
		return this;
	}

	public List<String> getInvestmentFunds() {
		return investmentFunds;
	}

	public void setInvestmentFunds(List<String> investmentFunds) {
		this.investmentFunds = investmentFunds;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PaymentData paymentData = (PaymentData) o;
		return Objects.equals(this.paymentType, paymentData.paymentType)
				&& Objects.equals(this.paymentMethod, paymentData.paymentMethod)
				&& Objects.equals(this.value, paymentData.value)
				&& Objects.equals(this.requestDate, paymentData.requestDate)
				&& Objects.equals(this.settlementDate, paymentData.settlementDate)
				&& Objects.equals(this.investmentFunds, paymentData.investmentFunds);
	}

	@Override
	public int hashCode() {
		return Objects.hash(paymentType, paymentMethod, value, requestDate, settlementDate, investmentFunds);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PaymentData {\n");

		sb.append("    paymentType: ").append(toIndentedString(paymentType)).append("\n");
		sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
		sb.append("    value: ").append(toIndentedString(value)).append("\n");
		sb.append("    requestDate: ").append(toIndentedString(requestDate)).append("\n");
		sb.append("    settlementDate: ").append(toIndentedString(settlementDate)).append("\n");
		sb.append("    investmentFunds: ").append(toIndentedString(investmentFunds)).append("\n");
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
