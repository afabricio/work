package br.com.kiman.kiprev.ki.xp.integration.ged;

import static br.com.kiman.kiprev.ki.xp.dominio.dao.QueryParameters.with;
import static br.com.kiman.kiprev.ki.xp.dominio.entity.Ged.BUSCA_TODOS_POR_STATUS;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.Status.Family;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import br.com.kiman.kiprev.ki.xp.dominio.cliente.rest.ClienteRestLogger;
import br.com.kiman.kiprev.ki.xp.dominio.cliente.rest.ClienteRestService;
import br.com.kiman.kiprev.ki.xp.dominio.constants.Interface;
import br.com.kiman.kiprev.ki.xp.dominio.constants.ParametroEnum;
import br.com.kiman.kiprev.ki.xp.dominio.constants.StatusGed;
import br.com.kiman.kiprev.ki.xp.dominio.constants.TipoLocalArquivoGed;
import br.com.kiman.kiprev.ki.xp.dominio.dao.GenericDAO;
import br.com.kiman.kiprev.ki.xp.dominio.entity.Ged;
import br.com.kiman.kiprev.ki.xp.dominio.entity.ParametroInterface;
import br.com.kiman.kiprev.ki.xp.dominio.exception.NegocioException;

@Stateless
public class GEDService {

	private Logger logger = Logger.getLogger(GEDService.class);
	private static final String ERRO_AO_RECUPERAR_O_ARQUIVO = "Erro ao recuperar o arquivo - Id: %s - %s - Status: %s ";

	@Inject
	private GenericDAO dao;
	@Inject
	private ClienteRestService restService;

	public List<Ged> buscaPendentes() {
		return dao.findByNamedQuery(BUSCA_TODOS_POR_STATUS, with("pStatus", StatusGed.PENDENTE));
	}

	public boolean processaGed(Ged ged, List<ParametroInterface> parametros) {
		boolean processado = true;
		try {
			carregaArquivo(ged);
			postaArquivo(ged, parametros);
			ged.setStatus(StatusGed.SUCESSO);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			ged.setMensagemErro(e.getMessage());
			ged.setStatus(StatusGed.ERRO);
			processado = false;
		} finally {
			dao.update(ged);
		}
		return processado;
	}

	private void carregaArquivo(Ged ged) {
		TipoLocalArquivoGed tipoLocalArquivo = ged.getTipoLocalArquivo();

		InputStream is = null;
		if (TipoLocalArquivoGed.URL.equals(tipoLocalArquivo)) {
			is = buscaArquivoURL(ged);

		} else if (TipoLocalArquivoGed.DIRETORIO.equals(tipoLocalArquivo)) {
			is = buscaArquivoDiretorio(ged);

		}
		if (is != null) {
			ged.setArquivoBase64(is);
		}
	}

	private void postaArquivo(Ged ged, List<ParametroInterface> parametros) {
		ArchiveModel archiveModel = getArchiveModel(ged);

		Map<String, Object> headers = Maps.newHashMap();
		headers.put(CONTENT_TYPE, APPLICATION_JSON);
		headers.put(ACCEPT, APPLICATION_JSON);

		List<?> filtros = Lists.newArrayList(new ClienteRestLogger(Interface.GED, ged.getId()));
		Response response = restService.post(getURL(parametros), Entity.entity(archiveModel, APPLICATION_JSON), headers,
				filtros);

		if (!response.getStatusInfo().getFamily().equals(Family.SUCCESSFUL)) {
			throw new NegocioException(response.getStatusInfo().getReasonPhrase() + " - " + response.readEntity(String.class));
		}

	}

	private String getURL(List<ParametroInterface> parametros) {
		return ParametroEnum.URI_POST_ARQUIVO_GED.extraiValorParametro(parametros);
	}

	private ArchiveModel getArchiveModel(Ged ged) {
		ArchiveModel archiveModel = new ArchiveModel();
		archiveModel.setCustomerDocument(ged.getNumDoctoCliente());
		archiveModel.setArchiveId(ged.getNumDocumento());
		archiveModel.setArchiveType(ged.getTipoArquivo());
		archiveModel.setFileBase64(ged.getArquivo());
		archiveModel.setFileExtension(ged.getExtensaoArquivo());
		return archiveModel;
	}

	private InputStream buscaArquivoDiretorio(Ged ged) {
		try {
			File file = new File(ged.getDiretorioArquivo());
			return new FileInputStream(file);
		} catch (Exception e) {
			throw new NegocioException(ExceptionUtils.getRootCauseMessage(e), e);
		}
	}

	private InputStream buscaArquivoURL(Ged ged) {
		Map<String, Object> headers = Maps.newHashMap();
		List<?> filtros = Lists.newArrayList(new ClienteRestLogger(Interface.GED, ged.getId()));
		headers.put(ACCEPT, "application/pdf");
		Response response = restService.get(ged.getUrlArquivo(), headers, filtros);
		if (response.getStatus() != Status.OK.getStatusCode()) {
			String mensagem = String.format(ERRO_AO_RECUPERAR_O_ARQUIVO, ged.getId(), ged.getUrlArquivo(),
					response.getStatus());
			throw new NegocioException(mensagem);
		}

		return response.readEntity(InputStream.class);
	}

}
