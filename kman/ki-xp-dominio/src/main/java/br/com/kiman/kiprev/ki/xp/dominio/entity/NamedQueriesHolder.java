package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity

@NamedStoredProcedureQuery(
		name = "P_REQUEST_LOGGER_AUTONOMOUS", 
		procedureName = "KPVCUST11.PCK_DB_KI_UTIL.P_REQUEST_LOGGER_AUTONOMOUS", 
		parameters = { 
			@StoredProcedureParameter (name ="pnCodHist", type =Integer.class, mode =  ParameterMode.INOUT),
			@StoredProcedureParameter (name ="pURL", type =String.class, mode =  ParameterMode.IN),
			@StoredProcedureParameter (name ="pOPERACAO", type =String.class, mode =  ParameterMode.IN),		
			@StoredProcedureParameter (name ="pXML_REQUEST", type =String.class, mode =  ParameterMode.IN),
			@StoredProcedureParameter (name ="pXML_RESPONSE", type =String.class, mode =  ParameterMode.IN),
			@StoredProcedureParameter (name ="pNUM_INTERFACE", type =Integer.class, mode =  ParameterMode.INOUT),
			@StoredProcedureParameter (name ="pNUM_DOCUMENTO", type =String.class, mode =  ParameterMode.IN),
			@StoredProcedureParameter (name ="pDT_REQUISICAO", type =Date.class, mode =  ParameterMode.IN),
			@StoredProcedureParameter (name ="pTS_ENVIO", type =Date.class, mode =  ParameterMode.IN),
			@StoredProcedureParameter (name ="pTS_RETORNO", type =Date.class, mode =  ParameterMode.IN),
			@StoredProcedureParameter (name ="pMSG_ERRO", type =String.class, mode =  ParameterMode.IN),
			@StoredProcedureParameter (name ="pSTATUS", type =String.class, mode =  ParameterMode.IN)
		}
	)

public class NamedQueriesHolder {
	
	@Id
	int id;

}
