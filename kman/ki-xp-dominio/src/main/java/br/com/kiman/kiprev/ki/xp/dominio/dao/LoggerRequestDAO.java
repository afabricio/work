package br.com.kiman.kiprev.ki.xp.dominio.dao;

import static java.util.Optional.ofNullable;

import java.io.StringReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Date;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import br.com.kiman.kiprev.ki.xp.dominio.dto.RequestHistDTO;

public class LoggerRequestDAO {

	private static final Logger logger = Logger.getLogger(LoggerRequestDAO.class);

	@Resource(lookup = "kiprevDS")
	private DataSource dataSource;

	public void logRequest(RequestHistDTO params) {

		Connection connection = null;
		CallableStatement cs = null;
		try {
			connection = dataSource.getConnection();
			cs = connection.prepareCall(
					"{call kpvcust11.pck_db_ki_util.p_request_logger_autonomous(?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setString(2, params.getUrl());
			cs.setString(3, params.getOperacao());
			cs.setClob(4, new StringReader(ofNullable(params.getRequest()).orElse("")));
			cs.setClob(5, new StringReader(ofNullable(params.getResponse()).orElse("")));
			cs.setInt(6, params.getNumInterf());
			cs.setString(7, ofNullable(params.getNumDoc()).orElse(""));
			cs.setDate(8, new java.sql.Date(params.getDataCal().getTime()));
			cs.setTimestamp(9, new Timestamp(params.getDataReq().getTime()));
			cs.setTimestamp(10, new Timestamp(ofNullable(params.getDataResp()).orElse(new Date()).getTime()));
			cs.setString(11, ofNullable(params.getMsgErro()).orElse(""));
			cs.setString(12, params.getStatus());
			cs.execute();
			logger.info("Log: " + cs.getObject(1));

		} catch (Exception e) {
			logger.error("Erro ao logar a requisicao.", e);
			logger.error(params.toString());
		} finally {
			try {
				if (cs != null) {
					cs.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				logger.error("Erro ao fechar a conexao.", e);
			}
		}
	}

}
