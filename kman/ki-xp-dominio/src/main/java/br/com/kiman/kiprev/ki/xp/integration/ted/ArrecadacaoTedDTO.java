
package br.com.kiman.kiprev.ki.xp.integration.ted;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ArrecadacaoTedDTO {

	private String invoiceCode;
	private Double value;
	private String transferDate;
	private String depositDate;
	private Integer status;
	private Customer customer;
	private Insurer insurer;
	private String certificateCode;
	private String transferId;
	private String transactionKey;

	DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	public String getInvoiceCode() {
		return invoiceCode;
	}

	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getTransferDate() {

		return transferDate;

	}

	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}

	public Date getTransferDateAsDate() {

		try {
			return format.parse(transferDate);
		} catch (ParseException e) {
			return null;
		}

	}

	public String getDepositDate() {

		return this.depositDate;

	}

	public void setDepositDate(String depositDate) {
		this.depositDate = depositDate;
	}

	public Date getDepositDateAsDate() {

		try {
			return format.parse(depositDate);
		} catch (ParseException e) {
			return null;
		}
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Insurer getInsurer() {
		return insurer;
	}

	public void setInsurer(Insurer insurer) {
		this.insurer = insurer;
	}

	public String getCertificateCode() {
		return certificateCode;
	}

	public void setCertificateCode(String certificateCode) {
		this.certificateCode = certificateCode;
	}

	public String getTransferId() {
		return transferId;
	}

	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}

	public String getTransactionKey() {
		return transactionKey;
	}

	public void setTransactionKey(String transactionKey) {
		this.transactionKey = transactionKey;
	}

	public String getInsurerBankNumber() {

		if (getInsurer() != null && getInsurer().getBankAccount() != null) {

			return getInsurer().getBankAccount().getBankNumber();

		} else {

			return "";

		}

	}

	public String getInsurerAgency() {
		if (getInsurer() != null && getInsurer().getBankAccount() != null) {

			return getInsurer().getBankAccount().getAgency();
		} else {

			return "";

		}
	}

	public String getInsurerAgencyDigit() {
		if (getInsurer() != null && getInsurer().getBankAccount() != null) {

			return getInsurer().getBankAccount().getAgencyDigit();
		} else {

			return "";

		}

	}

	public String getInsurerAccount() {
		if (getInsurer() != null && getInsurer().getBankAccount() != null) {

			return getInsurer().getBankAccount().getAccount();
		} else {

			return "";

		}
	}

	public String getInsurerAccountDigit() {
		if (getInsurer() != null && getInsurer().getBankAccount() != null) {

			return getInsurer().getBankAccount().getAccountDigit();
		} else {

			return "";

		}
	}

	public String getInsurerDocument() {
		if (getInsurer() != null) {

			return getInsurer().getDocument();
		} else {

			return "";

		}
	}

	public String getCustomerBankNumber() {

		if (getCustomer() != null && getCustomer().getBankAccount() != null) {

			return getCustomer().getBankAccount().getBankNumber();

		} else {

			return "";

		}

	}

	public String getCustomerAgency() {

		if (getCustomer() != null && getCustomer().getBankAccount() != null) {

			return getCustomer().getBankAccount().getAgency();

		} else {

			return "";

		}

	}

	public String getCustomerAgencyDigit() {

		if (getCustomer() != null && getCustomer().getBankAccount() != null) {

			return getCustomer().getBankAccount().getAgencyDigit();
		} else {

			return "";

		}

	}

	public String getCustomerAccount() {

		if (getCustomer() != null && getCustomer().getBankAccount() != null) {

			return getCustomer().getBankAccount().getAccount();
		} else {

			return "";

		}

	}

	public String getCustomerAccountDigit() {

		if (getCustomer() != null && getCustomer().getBankAccount() != null) {

			return getCustomer().getBankAccount().getAccountDigit();
		} else {

			return "";

		}

	}

	public String getCustomerDocument() {

		if (getCustomer() != null) {

			return getCustomer().getDocument();
		} else {

			return "";

		}

	}

}
