package br.com.kiman.kiprev.ki.xp.rest.resource;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.ClientResponse.Status;

import br.com.kiman.kiprev.ki.xp.dominio.constants.Interface;
import br.com.kiman.kiprev.ki.xp.dominio.dto.RetornoSimplesDTO;
import br.com.kiman.kiprev.ki.xp.dominio.facade.ItauFacade;
import br.com.kiman.kiprev.ki.xp.rest.interceptor.RequestServerInterceptor;

@Path("/itau")
public class ItauResource {

	@EJB(beanName = ItauFacade.NAME_EJB)
	private ItauFacade facade;
	
	@Inject
	private HttpServletRequest req;

	@GET
	@Path("/boleto/registro")
	@Produces(MediaType.APPLICATION_JSON)
	public Response registraBoleto(@QueryParam("boletoid") Long boletoID) {
		
		req.setAttribute(RequestServerInterceptor.LOG_CHAVE, boletoID);
		req.setAttribute(RequestServerInterceptor.LOG_NUMERO_INTERFACE, Interface.ENVIO_BOLETO_ONLINE.getNumero());
		

		RetornoSimplesDTO result = facade.registraBoletoByBoletoID(boletoID);

		if (result.isSucesso()) {
			return Response.ok("S").build();
		} else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("N \n" + result.getMensagem()).build();
		}
	}

}
