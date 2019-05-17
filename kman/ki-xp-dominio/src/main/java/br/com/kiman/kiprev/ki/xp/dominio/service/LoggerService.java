package br.com.kiman.kiprev.ki.xp.dominio.service;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import br.com.kiman.kiprev.ki.xp.dominio.dao.LoggerRequestDAO;
import br.com.kiman.kiprev.ki.xp.dominio.dto.RequestHistDTO;

@Stateless
public class LoggerService {
	private static final Logger logger = Logger.getLogger(LoggerService.class);

	@Inject
	private LoggerRequestDAO dao;

	@Asynchronous
	public void asyncLogRequest(RequestHistDTO params) {
		try {
			dao.logRequest(params);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}
