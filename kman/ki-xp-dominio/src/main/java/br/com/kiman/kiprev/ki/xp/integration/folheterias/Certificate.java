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
public class Certificate {

	@XmlElement(name = "certificateCode")
	private String certificateCode = null;

	@XmlElement(name = "totalBalance")
	private BigDecimal totalBalance = null;

	@XmlElement(name = "balances")
	private List<CertificateBalance> balances = null;

	@XmlElement(name = "certificateStatus")
	private Integer certificateStatus = null;

	@XmlElement(name = "certificateStatusDate")
	@XmlJavaTypeAdapter(ZDateAdapter.class)
	private Date certificateStatusDate = null;

	@XmlElement(name = "contributionReport")
	private Boolean contributionReport = null;

	@XmlElement(name = "taxReturnReport")
	private Boolean taxReturnReport = null;

	@XmlElement(name = "beneficiaries")
	private List<Beneficiary> beneficiaries = null;

	@XmlElement(name = "paymentData")
	private PaymentData paymentData = null;

	@XmlElement(name = "financialTransactions")
	private List<FinancialTransaction> financialTransactions = null;

	public Certificate certificateCode(String certificateCode) {
		this.certificateCode = certificateCode;
		return this;
	}

	public String getCertificateCode() {
		return certificateCode;
	}

	public void setCertificateCode(String certificateCode) {
		this.certificateCode = certificateCode;
	}

	public Certificate totalBalance(BigDecimal totalBalance) {
		this.totalBalance = totalBalance;
		return this;
	}

	public BigDecimal getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(BigDecimal totalBalance) {
		this.totalBalance = totalBalance;
	}

	public Certificate balances(List<CertificateBalance> balances) {
		this.balances = balances;
		return this;
	}

	public Certificate addBalancesItem(CertificateBalance balancesItem) {
		if (this.balances == null) {
			this.balances = new ArrayList<CertificateBalance>();
		}
		this.balances.add(balancesItem);
		return this;
	}

	public List<CertificateBalance> getBalances() {
		return balances;
	}

	public void setBalances(List<CertificateBalance> balances) {
		this.balances = balances;
	}

	public Certificate certificateStatus(Integer certificateStatus) {
		this.certificateStatus = certificateStatus;
		return this;
	}

	public Integer getCertificateStatus() {
		return certificateStatus;
	}

	public void setCertificateStatus(Integer certificateStatus) {
		this.certificateStatus = certificateStatus;
	}

	public Certificate certificateStatusDate(Date certificateStatusDate) {
		this.certificateStatusDate = certificateStatusDate;
		return this;
	}

	public Date getCertificateStatusDate() {
		return certificateStatusDate;
	}

	public void setCertificateStatusDate(Date certificateStatusDate) {
		this.certificateStatusDate = certificateStatusDate;
	}

	public Certificate contributionReport(Boolean contributionReport) {
		this.contributionReport = contributionReport;
		return this;
	}

	public Boolean isisContributionReport() {
		return contributionReport;
	}

	public void setContributionReport(Boolean contributionReport) {
		this.contributionReport = contributionReport;
	}

	public Certificate taxReturnReport(Boolean taxReturnReport) {
		this.taxReturnReport = taxReturnReport;
		return this;
	}

	public Boolean isisTaxReturnReport() {
		return taxReturnReport;
	}

	public void setTaxReturnReport(Boolean taxReturnReport) {
		this.taxReturnReport = taxReturnReport;
	}

	public Certificate beneficiaries(List<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
		return this;
	}

	public Certificate addBeneficiariesItem(Beneficiary beneficiariesItem) {
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

	public Certificate paymentData(PaymentData paymentData) {
		this.paymentData = paymentData;
		return this;
	}

	public PaymentData getPaymentData() {
		return paymentData;
	}

	public void setPaymentData(PaymentData paymentData) {
		this.paymentData = paymentData;
	}

	public Certificate financialTransactions(List<FinancialTransaction> financialTransactions) {
		this.financialTransactions = financialTransactions;
		return this;
	}

	public Certificate addFinancialTransactionsItem(FinancialTransaction financialTransactionsItem) {
		if (this.financialTransactions == null) {
			this.financialTransactions = new ArrayList<FinancialTransaction>();
		}
		this.financialTransactions.add(financialTransactionsItem);
		return this;
	}

	public List<FinancialTransaction> getFinancialTransactions() {
		return financialTransactions;
	}

	public void setFinancialTransactions(List<FinancialTransaction> financialTransactions) {
		this.financialTransactions = financialTransactions;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Certificate certificate = (Certificate) o;
		return Objects.equals(this.certificateCode, certificate.certificateCode)
				&& Objects.equals(this.totalBalance, certificate.totalBalance)
				&& Objects.equals(this.balances, certificate.balances)
				&& Objects.equals(this.certificateStatus, certificate.certificateStatus)
				&& Objects.equals(this.certificateStatusDate, certificate.certificateStatusDate)
				&& Objects.equals(this.contributionReport, certificate.contributionReport)
				&& Objects.equals(this.taxReturnReport, certificate.taxReturnReport)
				&& Objects.equals(this.beneficiaries, certificate.beneficiaries)
				&& Objects.equals(this.paymentData, certificate.paymentData)
				&& Objects.equals(this.financialTransactions, certificate.financialTransactions);
	}

	@Override
	public int hashCode() {
		return Objects.hash(certificateCode, totalBalance, balances, certificateStatus, certificateStatusDate,
				contributionReport, taxReturnReport, beneficiaries, paymentData, financialTransactions);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Certificate {\n");

		sb.append("    certificateCode: ").append(toIndentedString(certificateCode)).append("\n");
		sb.append("    totalBalance: ").append(toIndentedString(totalBalance)).append("\n");
		sb.append("    balances: ").append(toIndentedString(balances)).append("\n");
		sb.append("    certificateStatus: ").append(toIndentedString(certificateStatus)).append("\n");
		sb.append("    certificateStatusDate: ").append(toIndentedString(certificateStatusDate)).append("\n");
		sb.append("    contributionReport: ").append(toIndentedString(contributionReport)).append("\n");
		sb.append("    taxReturnReport: ").append(toIndentedString(taxReturnReport)).append("\n");
		sb.append("    beneficiaries: ").append(toIndentedString(beneficiaries)).append("\n");
		sb.append("    paymentData: ").append(toIndentedString(paymentData)).append("\n");
		sb.append("    financialTransactions: ").append(toIndentedString(financialTransactions)).append("\n");
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
