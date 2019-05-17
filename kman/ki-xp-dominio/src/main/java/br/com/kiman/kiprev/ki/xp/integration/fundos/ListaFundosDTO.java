package br.com.kiman.kiprev.ki.xp.integration.fundos;

import java.util.List;

import com.google.common.collect.Lists;

public class ListaFundosDTO {

	private List<FundoInvestimentoDTO> investmentFunds;

	public List<FundoInvestimentoDTO> getInvestmentFunds() {
		if (investmentFunds == null) {
			investmentFunds = Lists.newArrayList();
		}
		return investmentFunds;
	}

	public void setInvestmentFunds(List<FundoInvestimentoDTO> investmentFunds) {
		this.investmentFunds = investmentFunds;
	}

}
