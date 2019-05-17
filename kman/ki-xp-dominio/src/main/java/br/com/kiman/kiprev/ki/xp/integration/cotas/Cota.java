package br.com.kiman.kiprev.ki.xp.integration.cotas;

import java.math.BigDecimal;
import java.util.Date;

public class Cota implements Comparable<Cota>{

	private BigDecimal value;
	private Date date;
	private String investmentFundId;
	private BigDecimal netEquity;

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getInvestmentFundId() {
		return investmentFundId;
	}

	public void setInvestmentFundId(String investmentFundId) {
		this.investmentFundId = investmentFundId;
	}

	public BigDecimal getNetEquity() {
		return netEquity;
	}

	public void setNetEquity(BigDecimal netEquity) {
		this.netEquity = netEquity;
	}



	@Override
	public int compareTo(Cota other) {
		
		return this.date.compareTo(other.getDate());
	}

}
