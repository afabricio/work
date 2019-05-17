package br.com.kiman.kiprev.ki.xp.integration.fundos;

public class FundoProperties {

	private Boolean active;

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getActiveAsString() {
		return active ? "S" : "N";
	}

}
