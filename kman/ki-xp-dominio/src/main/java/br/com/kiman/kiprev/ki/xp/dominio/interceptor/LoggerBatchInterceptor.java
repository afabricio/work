package br.com.kiman.kiprev.ki.xp.dominio.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;

public class LoggerBatchInterceptor {

	private static final Logger logger = Logger.getLogger(LoggerBatchInterceptor.class);

	private static final String MSG_INICIO = "Batch %s iniciado";
	private static final String MSG_FIM = "Batch %s finalizado";
	private static final String MSG_TEMPO_EXEC = "Batch executado em %s segundos. Status %s";

	@AroundInvoke
	public Object methodInterceptor(InvocationContext context) throws Exception {

		long inicio = System.currentTimeMillis();
		logaInicioBatch(context);

		Object proceed = context.proceed();

		long fim = System.currentTimeMillis();
		logaFimBatch(context, proceed, (fim - inicio) / 1000);

		return proceed;
	}

	private void logaInicioBatch(InvocationContext context) {
		try {
			logger.debug(String.format(MSG_INICIO, getNomeBatch(context)));
		} catch (Exception e) {
			logger.error("Erro ao logar inicio do batch", e);
		}
	}

	private void logaFimBatch(InvocationContext context, Object proceed, long tempoDeExecucao) {
		try {
			logger.debug(String.format(MSG_FIM, getNomeBatch(context)));
			logger.debug(String.format(MSG_TEMPO_EXEC, tempoDeExecucao, proceed));
		} catch (Exception e) {
			logger.error("Erro ao logar fim do batch", e);
		}
	}

	private String getNomeBatch(InvocationContext context) {
		return context.getParameters().length > 0 ? context.getParameters()[0].toString() : null;
	}

}
