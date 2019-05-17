/*
 * Copyright (c) 2009 Kiman Solutions
 * This software is the proprietary information of Kiman Solutions
 */
package br.com.kiman.kiprev.ki.xp.jaxws;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Entidade representativa de informações adicionas do erro ocorrido.
 * 
 * @author hferro - Kiman Solutions
 * @version 1.0.0
 * @since 1.0.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://kiman.com.br/ki/xp/service/canonical", name = "AdditionalInfo")
public class AdditionalInfo implements Serializable {

    private static final long serialVersionUID = -453272413169309675L;
    private String errorDescription;

    public AdditionalInfo(){
    }
    
    public AdditionalInfo(String errorDescription){
    	super();
    	this.errorDescription = errorDescription;
    }

    /**
     * Retornar valor do parâmetro <code>errorDescription</code>.
     * 
     * @return errorDescription <code>String</code>
     * @author hferro - Kiman Solutions
     */
    public String getErrorDescription() {
        return errorDescription;
    }

}



