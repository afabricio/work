package br.com.kiman.kiprev.ki.xp.integration.clientes;

public class Financial {

	private Attorney attorney;
	private Boolean taxExempt;
	private Long taxIdentifierNumber;
	private Double salary;
	private Double financialApplicationValue;
	private Double propertyGoodsValue;
	private Double otherGoodsValue;
	private Double movableGoodsValue;
	private Boolean pensionFunds;
	private UsPerson usPerson;
	

	
	
	public UsPerson getUsPerson() {
		return usPerson;
	}
	public void setUsPerson(UsPerson usPerson) {
		this.usPerson = usPerson;
	}
	public Attorney getAttorney() {
		return attorney;
	}
	public void setAttorney(Attorney attorney) {
		this.attorney = attorney;
	}
	public Boolean getTaxExempt() {
		return taxExempt;
	}
	public void setTaxExempt(Boolean taxExempt) {
		this.taxExempt = taxExempt;
	}
	public Long getTaxIdentifierNumber() {
		return taxIdentifierNumber;
	}
	public void setTaxIdentifierNumber(Long taxIdentifierNumber) {
		this.taxIdentifierNumber = taxIdentifierNumber;
	}

	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Double getFinancialApplicationValue() {
		return financialApplicationValue;
	}
	public void setFinancialApplicationValue(Double financialApplicationValue) {
		this.financialApplicationValue = financialApplicationValue;
	}
	public Double getPropertyGoodsValue() {
		return propertyGoodsValue;
	}
	public void setPropertyGoodsValue(Double propertyGoodsValue) {
		this.propertyGoodsValue = propertyGoodsValue;
	}
	public Double getOtherGoodsValue() {
		return otherGoodsValue;
	}
	public void setOtherGoodsValue(Double otherGoodsValue) {
		this.otherGoodsValue = otherGoodsValue;
	}
	public Double getMovableGoodsValue() {
		return movableGoodsValue;
	}
	public void setMovableGoodsValue(Double movableGoodsValue) {
		this.movableGoodsValue = movableGoodsValue;
	}
	public Boolean getPensionFunds() {
		return pensionFunds;
	}
	public void setPensionFunds(Boolean pensionFunds) {
		this.pensionFunds = pensionFunds;
	}

	
	
	
}
