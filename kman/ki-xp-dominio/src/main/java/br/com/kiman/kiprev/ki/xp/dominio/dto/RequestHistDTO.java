package br.com.kiman.kiprev.ki.xp.dominio.dto;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.time.DateUtils;

public class RequestHistDTO {

	public RequestHistDTO(){		
		this.status = "S";
		this.dataCal = DateUtils.truncate(new Date(), Calendar.DATE);        
	}
	
	public RequestHistDTO(Integer n){
		this.numInterf = n;
		this.status = "S";
		this.dataCal = DateUtils.truncate(new Date(), Calendar.DATE);
		

        
	}

	private String status;
	private Integer numInterf;
	private String numDoc;
	private Date dataCal;
	private Date dataReq;
	private Date dataResp;
	private String msgErro;
	private String url;
	private String operacao;
	private String request;
	private String response;
	
	
	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Integer getNumInterf() {
		return numInterf;
	}
	public void setNumInterf(Integer numInterf) {
		this.numInterf = numInterf;
	}
	public String getNumDoc() {
		return numDoc;
	}
	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}
	public Date getDataCal() {
		return dataCal;
	}
	public void setDataCal(Date dataCal) {
		this.dataCal = dataCal;
	}
	public Date getDataReq() {
		return dataReq;
	}
	public void setDataReq(Date dataReq) {
		this.dataReq = dataReq;
	}
	public Date getDataResp() {
		return dataResp;
	}
	public void setDataResp(Date dataResp) {
		this.dataResp = dataResp;
	}
	public String getMsgErro() {
		return msgErro;
	}
	public void setMsgErro(String msgErro) {
		this.msgErro = msgErro;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).build();
	}

}
