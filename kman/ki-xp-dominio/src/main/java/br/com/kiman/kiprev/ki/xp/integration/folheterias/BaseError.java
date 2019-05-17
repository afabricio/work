package br.com.kiman.kiprev.ki.xp.integration.folheterias;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BaseError {

	@XmlElement(name = "message")
	private String message = null;

	@XmlElement(name = "errorCode")
	private Integer errorCode = null;

	public BaseError message(String message) {
		this.message = message;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BaseError errorCode(Integer errorCode) {
		this.errorCode = errorCode;
		return this;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BaseError baseError = (BaseError) o;
		return Objects.equals(this.message, baseError.message) && Objects.equals(this.errorCode, baseError.errorCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(message, errorCode);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class BaseError {\n");

		sb.append("    message: ").append(toIndentedString(message)).append("\n");
		sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
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
