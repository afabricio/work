package br.com.kiman.kiprev.ki.xp.jaxws;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Entidade representativa do erro ocorrido.
 * 
 * @author cabreu - Kiman Solutions
 * @version 1.0.0
 * @since 1.0.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://kiman.com.br/ki/xp/service/canonical", name = "FaultInfo")
@XmlRootElement
public class FaultInfo implements Serializable {

    private static final long serialVersionUID = -73859314554634147L;
    private String errorCode;
    private List<AdditionalInfo> additionalInfos;

    /**
     * Construtor da classe <code>FaultInfo.java</code>.
     */
    public FaultInfo() {
    }

    /**
     * Definir valor do parâmetro <code>errorCode</code>.
     * 
     * @param errorCode
     *            <code>String</code>
     * @author hferro - Kiman Solutions
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Retornar valor do parâmetro <code>errorCode</code>.
     * 
     * @return errorCode <code>String</code>
     * @author hferro - Kiman Solutions
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Definir valor do parâmetro <code>additionalInfos</code>.
     * 
     * @param additionalInfos
     *            <code>List<AdditionalInfo></code>
     * @author hferro - Kiman Solutions
     */
    public void setAdditionalInfos(List<AdditionalInfo> additionalInfos) {
        this.additionalInfos = additionalInfos;
    }

    /**
     * Retornar valor do parâmetro <code>additionalInfos</code>.
     * 
     * @return additionalInfos <code>List<AdditionalInfo></code>
     * @author hferro - Kiman Solutions
     */
    public List<AdditionalInfo> getAdditionalInfos() {
        return additionalInfos;
    }

}


