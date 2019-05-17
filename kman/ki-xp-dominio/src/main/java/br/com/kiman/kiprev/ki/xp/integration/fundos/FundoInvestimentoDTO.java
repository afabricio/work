package br.com.kiman.kiprev.ki.xp.integration.fundos;

public class FundoInvestimentoDTO {

	private String id;
	private String name;
	private String code;
	private Integer investmentQuotationDays;
	private Integer redemptionQuotationDays;
	private String cnpj;
	private FundoProperties properties;
	private Integer redemptionSettlementDays;
	private String startDate;
	private Integer quotaType;
	private FundoAdministrator administrator;
	private FundoManager manager;
	private String updatedOn;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getInvestmentQuotationDays() {
		return investmentQuotationDays;
	}

	public void setInvestmentQuotationDays(Integer investmentQuotationDays) {
		this.investmentQuotationDays = investmentQuotationDays;
	}

	public Integer getRedemptionQuotationDays() {
		return redemptionQuotationDays;
	}

	public void setRedemptionQuotationDays(Integer redemptionQuotationDays) {
		this.redemptionQuotationDays = redemptionQuotationDays;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public FundoProperties getProperties() {
		return properties;
	}

	public void setProperties(FundoProperties properties) {
		this.properties = properties;
	}

	public Integer getRedemptionSettlementDays() {
		return redemptionSettlementDays;
	}

	public void setRedemptionSettlementDays(Integer redemptionSettlementDays) {
		this.redemptionSettlementDays = redemptionSettlementDays;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Integer getQuotaType() {
		return quotaType;
	}

	public void setQuotaType(Integer quotaType) {
		this.quotaType = quotaType;
	}

	public FundoAdministrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(FundoAdministrator administrator) {
		this.administrator = administrator;
	}

	public FundoManager getManager() {
		return manager;
	}

	public void setManager(FundoManager manager) {
		this.manager = manager;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

}
