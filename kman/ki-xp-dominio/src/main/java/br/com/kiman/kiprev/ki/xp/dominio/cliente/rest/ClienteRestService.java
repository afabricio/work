package br.com.kiman.kiprev.ki.xp.dominio.cliente.rest;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.web.util.UriUtils;

import com.google.common.collect.Maps;

public class ClienteRestService {

	private static final Logger LOGGER = Logger.getLogger(ClienteRestService.class);

	public Response get(String url, Map<String, Object> headers, List<?> filtros) {
		Client client = ClientBuilder.newClient();

		if (filtros != null) {
			filtros.stream().forEach(f -> client.register(f));
		}
		return client.target(getUrlEncoded(url)).request().headers(new MultivaluedHashMap<String, Object>(headers))
				.get();

	}

	public Response get(String url, List<?> filtros) {
		return get(url, Maps.newHashMap(), filtros);
	}

	public Response get(String url, Map<String, Object> headers) {
		return get(url, headers, null);
	}

	public Response get(String url) {
		return get(url, Maps.newHashMap(), null);
	}

	public Response post(String url, Entity<?> entity, Map<String, Object> headers, List<?> filtros) {

		Client client = ClientBuilder.newClient();
		if (filtros != null) {
			filtros.stream().forEach(f -> client.register(f));
		}
		Builder builder = client.target(url).request().headers(new MultivaluedHashMap<String, Object>(headers));
		return builder.post(entity);

	}

	public Response post(String url, Entity<?> entity, Map<String, Object> headers) {
		return post(url, entity, headers, null);
	}

	public Response post(String url, Entity<?> entity, List<?> filtros) {
		return post(url, entity, Maps.newHashMap(), filtros);
	}

	public Response post(String url, Entity<?> entity) {
		return post(url, entity, Maps.newHashMap(), null);
	}

	private String getUrlEncoded(String url) {
		String urlEncoded = null;
		try {
			urlEncoded = UriUtils.encodeUri(url, StandardCharsets.UTF_8.toString());
		} catch (Exception e) {
			LOGGER.error("Erro ao fazer o encode da URL", e);
			urlEncoded = url;
		}
		return urlEncoded;
	}

}
