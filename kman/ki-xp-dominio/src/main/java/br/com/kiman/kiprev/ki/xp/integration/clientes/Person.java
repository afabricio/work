package br.com.kiman.kiprev.ki.xp.integration.clientes;

import java.util.Date;

public class Person {

	private String customerCode;
	private String name;
	private String email;
	private Date birthDate;
	private String document;
	private String maritalStatus;
	private PoliticallyExposed politicallyExposed;
	private Boolean lawsuit;
	private Boolean decease;
	private Boolean negativeRepercussion;
	
	

	

	public PoliticallyExposed getPoliticallyExposed() {
		return politicallyExposed;
	}

	public void setPoliticallyExposed(PoliticallyExposed politicallyExposed) {
		this.politicallyExposed = politicallyExposed;
	}

	public Boolean getLawsuit() {
		return lawsuit;
	}

	public void setLawsuit(Boolean lawsuit) {
		this.lawsuit = lawsuit;
	}

	public Boolean getDecease() {
		return decease;
	}

	public void setDecease(Boolean decease) {
		this.decease = decease;
	}

	public Boolean getNegativeRepercussion() {
		return negativeRepercussion;
	}

	public void setNegativeRepercussion(Boolean negativeRepercussion) {
		this.negativeRepercussion = negativeRepercussion;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

}
