package br.com.kiman.kiprev.ki.xp.integration.clientes;

import java.util.Date;
import java.util.List;

public class Customer {

	private Long id;
	private String advisorCode;
	private Person person;
	private Profession profession;
	private CellPhone cellPhone;
	private Telephone telephone;
	private List<BankAccount> bankAccounts;
	private Date dateContractAcceptance;
	private int versionInfo;
	private Financial financial;
	private ResidentialAddress residentialAddress;
	private CommercialAddress commercialAddress;
	private TaxAddress taxAddress;
	private String gender;
	private Document document;
	private Parental parental;
	private RegistrationStepModel registrationStepModel;
	private String customerStatement;
	private String branchCode;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdvisorCode() {
		return advisorCode;
	}
	public void setAdvisorCode(String advisorCode) {
		this.advisorCode = advisorCode;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Profession getProfession() {
		return profession;
	}
	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	public CellPhone getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(CellPhone cellPhone) {
		this.cellPhone = cellPhone;
	}
	public Telephone getTelephone() {
		return telephone;
	}
	public void setTelephone(Telephone telephone) {
		this.telephone = telephone;
	}
	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}
	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	public Date getDateContractAcceptance() {
		return dateContractAcceptance;
	}
	public void setDateContractAcceptance(Date dateContractAcceptance) {
		this.dateContractAcceptance = dateContractAcceptance;
	}
	public int getVersionInfo() {
		return versionInfo;
	}
	public void setVersionInfo(int versionInfo) {
		this.versionInfo = versionInfo;
	}
	public Financial getFinancial() {
		return financial;
	}
	public void setFinancial(Financial financial) {
		this.financial = financial;
	}
	public ResidentialAddress getResidentialAddress() {
		return residentialAddress;
	}
	public void setResidentialAddress(ResidentialAddress residentialAddress) {
		this.residentialAddress = residentialAddress;
	}
	public CommercialAddress getCommercialAddress() {
		return commercialAddress;
	}
	public void setCommercialAddress(CommercialAddress commercialAddress) {
		this.commercialAddress = commercialAddress;
	}
	public TaxAddress getTaxAddress() {
		return taxAddress;
	}
	public void setTaxAddress(TaxAddress taxAddress) {
		this.taxAddress = taxAddress;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	public Parental getParental() {
		return parental;
	}
	public void setParental(Parental parental) {
		this.parental = parental;
	}
	public RegistrationStepModel getRegistrationStepModel() {
		return registrationStepModel;
	}
	public void setRegistrationStepModel(RegistrationStepModel registrationStepModel) {
		this.registrationStepModel = registrationStepModel;
	}
	public String getCustomerStatement() {
		return customerStatement;
	}
	public void setCustomerStatement(String customerStatement) {
		this.customerStatement = customerStatement;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	
	
	
	
	//*************WRAPPER********************************
	
	public String getPersonCustomerCode() {
		if (getPerson() != null) {
			return getPerson().getCustomerCode();
		} else {
			return null;
		}
	}

	public Long getPersonDocument() {
		if (getPerson() != null) {
			return Long.valueOf(getPerson().getDocument());
		} else {
			return null;
		}
	}

	public String getPersonName() {
		if (getPerson() != null) {
			return getPerson().getName();
		} else {
			return null;
		}
	}

	public Date getPersonBirthdate() {

		if (getPerson() != null) {
			return getPerson().getBirthDate();
		} else {
			return null;
		}
	}

	public String getPersonMaritalStatus() {
		if (getPerson() != null) {

			return getPerson().getMaritalStatus();
		} else {
			return null;
		}
	}

	public Double getFinancialSalary() {
		if (getFinancial() != null) {
			return getFinancial().getSalary();
		} else {
			return null;
		}
	}

	public String getProfessionId() {
		if (getProfession() != null) {
			return getProfession().getId().toString();
		} else {
			return null;
		}
	}

	public String getTelephoneAreaCode() {
		if (getTelephone() != null) {
			return getTelephone().getAreaCode();
		} else {
			return null;
		}
	}

	public String getTelephoneNumber() {
		if (getTelephone() != null) {
			return getTelephone().getNumber().toString();
		} else {
			return null;
		}
	}

	public String getCellPhoneAreaCode() {
		if (getCellPhone() != null) {
			return getCellPhone().getAreaCode().toString();
		} else {
			return null;
		}
	}

	public String getCellPhoneNumber() {
		if (getCellPhone() != null) {
			return getCellPhone().getNumber().toString();
		} else {
			return null;
		}
	}

	public String getPersonEmail() {
		if (getPerson() != null) {
			return getPerson().getEmail();
		} else {
			return null;
		}
	}

	public String getProfessionDescription() {
		if (getProfession() != null) {
			return getProfession().getDescription();
		} else {
			return null;
		}
	}

	public String getPoliticallyExposedAgency() {
		if (getPerson() != null && getPerson().getPoliticallyExposed() != null) {
			return getPerson().getPoliticallyExposed().getAgency();
		} else {
			return null;
		}
	}

	public Date getPoliticallyExposedStartDate() {
		if (getPerson() != null && getPerson().getPoliticallyExposed()!= null) {
			return getPerson().getPoliticallyExposed().getStartDate();
		} else {
			return null;
		}
	}

	public Date getPoliticallyExposedExpirationDate() {
		if (getPerson() != null && getPerson().getPoliticallyExposed()!= null) {
			return getPerson().getPoliticallyExposed().getExpirationDate();
		} else {
			return null;
		}
	}

	public String getTaxIdentifierNumber() {
		if (getFinancial() != null && getFinancial().getTaxIdentifierNumber() != null) {
			return getFinancial().getTaxIdentifierNumber().toString();
		} else {
			return null;
		}
	}

	public String getUsPersonGreenCardNumber() {
		if (getFinancial() != null && getFinancial().getUsPerson()!= null) {
			return getFinancial().getUsPerson().getGreenCardNumber();
		} else {
			return null;
		}
	}

	public String getUsPersonSocialSecurityNumber() {
		if (getFinancial() != null && getFinancial().getUsPerson()!= null) {
			return getFinancial().getUsPerson().getSocialSecurityNumber();
		} else {
			return null;
		}
	}

	public String getResidentialAddressStreet() {
		if (getResidentialAddress() != null) {
			return getResidentialAddress().getStreet();
		} else {
			return null;
		}
	}

	public String getResidentialAddressNumber() {
		if (getResidentialAddress() != null) {
			return getResidentialAddress().getNumber();
		} else {
			return null;
		}
	}

	public String getResidentialAddressComplementation() {
		if (getResidentialAddress() != null) {
			return getResidentialAddress().getComplementation();
		} else {
			return null;
		}
	}

	public String getResidentialAddressNeighborhood() {
		if (getResidentialAddress() != null) {
			return getResidentialAddress().getNeighborhood();
		} else {
			return null;
		}
	}

	public String getResidentialAddressCity() {
		if (getResidentialAddress() != null) {
			return getResidentialAddress().getCity();
		} else {
			return null;
		}
	}

	public String getResidentialAddressZipCode() {
		if (getResidentialAddress() != null) {
			return getResidentialAddress().getZipCode();
		} else {
			return null;
		}
	}

	public String getResidentialAddressFederalUnit() {
		if (getResidentialAddress() != null) {
			return getResidentialAddress().getFederalUnit();
		} else {
			return null;
		}
	}

	public String getCommercialAddressStreet() {
		if (getCommercialAddress() != null) {
			return getCommercialAddress().getStreet();
		} else {
			return null;
		}
	}

	public String getCommercialAddressNumber() {
		if (getCommercialAddress() != null) {
			return getCommercialAddress().getNumber();
		} else {
			return null;
		}
	}

	public String getCommercialAddressComplementation() {
		if (getCommercialAddress() != null) {
			return getCommercialAddress().getComplementation();
		} else {
			return null;
		}
	}

	public String getCommercialAddressNeighborhood() {
		if (getCommercialAddress() != null) {
			return getCommercialAddress().getNeighborhood();
		} else {
			return null;
		}
	}

	public String getCommercialAddressCity() {
		if (getCommercialAddress() != null) {
			return getCommercialAddress().getCity();
		} else {
			return null;
		}
	}

	public String getCommercialAddressZipCode() {
		if (getCommercialAddress() != null) {
			return getCommercialAddress().getZipCode();
		} else {
			return null;
		}
	}

	public String getCommercialAddressFederalUnit() {
		if (getCommercialAddress() != null) {
			return getCommercialAddress().getFederalUnit();
		} else {
			return null;
		}
	}

	public String getTaxAddressStreet() {
		if (getTaxAddress() != null) {
			return getTaxAddress().getStreet();
		} else {
			return null;
		}
	}

	public String getTaxAddressNumber() {
		if (getTaxAddress() != null) {
			return getTaxAddress().getNumber();
		} else {
			return null;
		}
	}

	public String getTaxAddressComplementation() {
		if (getTaxAddress() != null) {
			return getTaxAddress().getComplementation();
		} else {
			return null;
		}
	}

	public String getTaxAddressNeighborhood() {
		if (getTaxAddress() != null) {
			return getTaxAddress().getNeighborhood();
		} else {
			return null;
		}
	}

	public String getTaxAddressCity() {
		if (getTaxAddress() != null) {
			return getTaxAddress().getCity();
		} else {
			return null;
		}
	}

	public String getTaxAddressZipCode() {
		if (getTaxAddress() != null) {
			return getTaxAddress().getZipCode();
		} else {
			return null;
		}
	}

	public String getTaxAddressFederalUnit() {
		if (getTaxAddress() != null) {
			return getTaxAddress().getFederalUnit();
		} else {
			return null;
		}
	}
	

}
