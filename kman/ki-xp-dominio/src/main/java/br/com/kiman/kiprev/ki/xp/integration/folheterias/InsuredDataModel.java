package br.com.kiman.kiprev.ki.xp.integration.folheterias;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class InsuredDataModel {

	@XmlElement(name = "proposal")
	private Proposal proposal = null;

	@XmlElement(name = "certificate")
	private Certificate certificate = null;

	@XmlElement(name = "updatedItems")
	private List<UpdateInfo> updatedItems = null;

	@XmlElement(name = "attachments")
	private List<Attachment> attachments = null;

	public InsuredDataModel proposal(Proposal proposal) {
		this.proposal = proposal;
		return this;
	}

	public Proposal getProposal() {
		return proposal;
	}

	public void setProposal(Proposal proposal) {
		this.proposal = proposal;
	}

	public InsuredDataModel certificate(Certificate certificate) {
		this.certificate = certificate;
		return this;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	public InsuredDataModel updatedItems(List<UpdateInfo> updatedItems) {
		this.updatedItems = updatedItems;
		return this;
	}

	public InsuredDataModel addUpdatedItemsItem(UpdateInfo updatedItemsItem) {
		if (this.updatedItems == null) {
			this.updatedItems = new ArrayList<UpdateInfo>();
		}
		this.updatedItems.add(updatedItemsItem);
		return this;
	}

	public List<UpdateInfo> getUpdatedItems() {
		return updatedItems;
	}

	public void setUpdatedItems(List<UpdateInfo> updatedItems) {
		this.updatedItems = updatedItems;
	}

	public InsuredDataModel attachments(List<Attachment> attachments) {
		this.attachments = attachments;
		return this;
	}

	public InsuredDataModel addAttachmentsItem(Attachment attachmentsItem) {
		if (this.attachments == null) {
			this.attachments = new ArrayList<Attachment>();
		}
		this.attachments.add(attachmentsItem);
		return this;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		InsuredDataModel insuredDataModel = (InsuredDataModel) o;
		return Objects.equals(this.proposal, insuredDataModel.proposal)
				&& Objects.equals(this.certificate, insuredDataModel.certificate)
				&& Objects.equals(this.updatedItems, insuredDataModel.updatedItems)
				&& Objects.equals(this.attachments, insuredDataModel.attachments);
	}

	@Override
	public int hashCode() {
		return Objects.hash(proposal, certificate, updatedItems, attachments);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class InsuredDataModel {\n");

		sb.append("    proposal: ").append(toIndentedString(proposal)).append("\n");
		sb.append("    certificate: ").append(toIndentedString(certificate)).append("\n");
		sb.append("    updatedItems: ").append(toIndentedString(updatedItems)).append("\n");
		sb.append("    attachments: ").append(toIndentedString(attachments)).append("\n");
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
