package br.com.kiman.kiprev.ki.xp.integration.indices;

import java.math.BigDecimal;

public class ValorIndice {

	private String id;
	private String indexId;
	private BigDecimal value;
	private Double profitability;
	private String date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIndexId() {
		return indexId;
	}

	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Double getProfitability() {
		return profitability;
	}

	public void setProfitability(Double profitability) {
		this.profitability = profitability;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
