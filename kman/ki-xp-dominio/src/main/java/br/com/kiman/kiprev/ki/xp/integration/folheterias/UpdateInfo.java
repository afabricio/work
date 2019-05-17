package br.com.kiman.kiprev.ki.xp.integration.folheterias;

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
public class UpdateInfo {

	@XmlElement(name = "customerItem")
	private Integer customerItem = null;

	@XmlElement(name = "updatedOn")
	@XmlJavaTypeAdapter(ZDateAdapter.class)
	private Date updatedOn = null;

	public UpdateInfo customerItem(Integer customerItem) {
		this.customerItem = customerItem;
		return this;
	}

	public Integer getCustomerItem() {
		return customerItem;
	}

	public void setCustomerItem(Integer customerItem) {
		this.customerItem = customerItem;
	}

	public UpdateInfo updatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
		return this;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		UpdateInfo updateInfo = (UpdateInfo) o;
		return Objects.equals(this.customerItem, updateInfo.customerItem)
				&& Objects.equals(this.updatedOn, updateInfo.updatedOn);
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerItem, updatedOn);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class UpdateInfo {\n");

		sb.append("    customerItem: ").append(toIndentedString(customerItem)).append("\n");
		sb.append("    updatedOn: ").append(toIndentedString(updatedOn)).append("\n");
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
