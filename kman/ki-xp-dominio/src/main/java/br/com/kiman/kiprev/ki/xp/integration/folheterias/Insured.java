
package br.com.kiman.kiprev.ki.xp.integration.folheterias;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Insured {

	@XmlElement(name = "document")
	private Long document = null;

	@XmlElement(name = "name")
	private String name = null;

	@XmlElement(name = "mainPhone")
	private String mainPhone = null;

	@XmlElement(name = "secondaryPhone")
	private String secondaryPhone = null;

	@XmlElement(name = "email")
	private String email = null;

	public Insured document(Long document) {
		this.document = document;
		return this;
	}

	public Long getDocument() {
		return document;
	}

	public void setDocument(Long document) {
		this.document = document;
	}

	public Insured name(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Insured mainPhone(String mainPhone) {
		this.mainPhone = mainPhone;
		return this;
	}

	public String getMainPhone() {
		return mainPhone;
	}

	public void setMainPhone(String mainPhone) {
		this.mainPhone = mainPhone;
	}

	public Insured secondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
		return this;
	}

	public String getSecondaryPhone() {
		return secondaryPhone;
	}

	public void setSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}

	public Insured email(String email) {
		this.email = email;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Insured insured = (Insured) o;
		return Objects.equals(this.document, insured.document) && Objects.equals(this.name, insured.name)
				&& Objects.equals(this.mainPhone, insured.mainPhone)
				&& Objects.equals(this.secondaryPhone, insured.secondaryPhone)
				&& Objects.equals(this.email, insured.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(document, name, mainPhone, secondaryPhone, email);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Insured {\n");

		sb.append("    document: ").append(toIndentedString(document)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    mainPhone: ").append(toIndentedString(mainPhone)).append("\n");
		sb.append("    secondaryPhone: ").append(toIndentedString(secondaryPhone)).append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
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
