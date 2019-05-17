package br.com.kiman.kiprev.ki.xp.integration.folheterias;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Attachment {

	@XmlElement(name = "fileName")
	private String fileName = null;

	@XmlElement(name = "fileExtension")
	private String fileExtension = null;

	@XmlElement(name = "base64")
	private byte[] base64 = null;

	@XmlElement(name = "fileId")
	private String fileId = null;

	@XmlElement(name = "archiveType")
	private Integer archiveType = null;

	public Attachment fileName(String fileName) {
		this.fileName = fileName;
		return this;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Attachment fileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
		return this;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public Attachment base64(byte[] base64) {
		this.base64 = base64;
		return this;
	}

	public byte[] getBase64() {
		return base64;
	}

	public void setBase64(byte[] base64) {
		this.base64 = base64;
	}

	public Attachment fileId(String fileId) {
		this.fileId = fileId;
		return this;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public Attachment archiveType(Integer archiveType) {
		this.archiveType = archiveType;
		return this;
	}

	public Integer getArchiveType() {
		return archiveType;
	}

	public void setArchiveType(Integer archiveType) {
		this.archiveType = archiveType;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Attachment attachment = (Attachment) o;
		return Objects.equals(this.fileName, attachment.fileName)
				&& Objects.equals(this.fileExtension, attachment.fileExtension)
				&& Objects.equals(this.base64, attachment.base64) && Objects.equals(this.fileId, attachment.fileId)
				&& Objects.equals(this.archiveType, attachment.archiveType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(fileName, fileExtension, base64, fileId, archiveType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Attachment {\n");

		sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
		sb.append("    fileExtension: ").append(toIndentedString(fileExtension)).append("\n");
		sb.append("    base64: ").append(toIndentedString(base64)).append("\n");
		sb.append("    fileId: ").append(toIndentedString(fileId)).append("\n");
		sb.append("    archiveType: ").append(toIndentedString(archiveType)).append("\n");
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