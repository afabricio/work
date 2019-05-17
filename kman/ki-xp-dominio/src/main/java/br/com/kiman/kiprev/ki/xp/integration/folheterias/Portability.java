package br.com.kiman.kiprev.ki.xp.integration.folheterias;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.kiman.kiprev.ki.xp.dominio.adapter.ZDateAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Portability {

	@XmlElement(name = "portabilityCode")
	private String portabilityCode = null;
	@XmlElement(name = "portabilityStatus")
	private Integer portabilityStatus = null;
	@XmlElement(name = "portabilityStatusDate")
	@XmlJavaTypeAdapter(ZDateAdapter.class)
	private Date portabilityStatusDate = null;
	@XmlElement(name = "value")
	private BigDecimal value = null;
	@XmlElement(name = "originPlan")
	private Plan originPlan = null;
	@XmlElement(name = "destinationPlan")
	private Plan destinationPlan = null;

	public Portability portabilityCode(String portabilityCode) {
		this.portabilityCode = portabilityCode;
		return this;
	}

	public String getPortabilityCode() {
		return portabilityCode;
	}

	public void setPortabilityCode(String portabilityCode) {
		this.portabilityCode = portabilityCode;
	}

	public Portability portabilityStatus(Integer portabilityStatus) {
		this.portabilityStatus = portabilityStatus;
		return this;
	}

	public Integer getPortabilityStatus() {
		return portabilityStatus;
	}

	public void setPortabilityStatus(Integer portabilityStatus) {
		this.portabilityStatus = portabilityStatus;
	}

	public Portability portabilityStatusDate(Date portabilityStatusDate) {
		this.portabilityStatusDate = portabilityStatusDate;
		return this;
	}

	public Date getPortabilityStatusDate() {
		return portabilityStatusDate;
	}

	public void setPortabilityStatusDate(Date portabilityStatusDate) {
		this.portabilityStatusDate = portabilityStatusDate;
	}

	public Portability value(BigDecimal value) {
		this.value = value;
		return this;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Portability originPlan(Plan originPlan) {
		this.originPlan = originPlan;
		return this;
	}

	public Plan getOriginPlan() {
		return originPlan;
	}

	public void setOriginPlan(Plan originPlan) {
		this.originPlan = originPlan;
	}

	public Portability destinationPlan(Plan destinationPlan) {
		this.destinationPlan = destinationPlan;
		return this;
	}

	public Plan getDestinationPlan() {
		return destinationPlan;
	}

	public void setDestinationPlan(Plan destinationPlan) {
		this.destinationPlan = destinationPlan;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Portability portability = (Portability) o;
		return Objects.equals(this.portabilityCode, portability.portabilityCode)
				&& Objects.equals(this.portabilityStatus, portability.portabilityStatus)
				&& Objects.equals(this.portabilityStatusDate, portability.portabilityStatusDate)
				&& Objects.equals(this.value, portability.value)
				&& Objects.equals(this.originPlan, portability.originPlan)
				&& Objects.equals(this.destinationPlan, portability.destinationPlan);
	}

	@Override
	public int hashCode() {
		return Objects.hash(portabilityCode, portabilityStatus, portabilityStatusDate, value, originPlan,
				destinationPlan);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Portability {\n");

		sb.append("    portabilityCode: ").append(toIndentedString(portabilityCode)).append("\n");
		sb.append("    portabilityStatus: ").append(toIndentedString(portabilityStatus)).append("\n");
		sb.append("    portabilityStatusDate: ").append(toIndentedString(portabilityStatusDate)).append("\n");
		sb.append("    value: ").append(toIndentedString(value)).append("\n");
		sb.append("    originPlan: ").append(toIndentedString(originPlan)).append("\n");
		sb.append("    destinationPlan: ").append(toIndentedString(destinationPlan)).append("\n");
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
