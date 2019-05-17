package br.com.kiman.kiprev.ki.xp.jaxws.interceptor;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.dom.DOMSource;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.service.Service;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.com.kiman.kiprev.ki.xp.jaxws.exception.ResourceWSException;

public abstract class BaseInterceptor extends
		AbstractPhaseInterceptor<SoapMessage> {

	static protected final Object[] EMPTY_ARRAY = {};

	public BaseInterceptor(String phase) {
		super(phase);
		if (!phase.equals(Phase.USER_LOGICAL)) {
			addAfter(SAAJInInterceptor.class.getName());
		}
	}

	protected Object getAttribute(SoapMessage message, Class<?> clazz,
			String attributeName) {
		// objeto que vai ser retornado
		Object object = null;

		// itera sobre o conteúdo da mensagem
		List<?> contentList = (List<?>) message.getContent(List.class);
		for (Iterator<?> it = contentList.iterator(); it.hasNext()
				&& object == null;) {

			// instância do objeto
			Object next = it.next();

			// itera sobre os métodos do objeto
			Method methods[] = next.getClass().getMethods();
			for (int i = 0; i < methods.length && object == null; i++) {

				// verifica se o retorno é igual a classe passada como parâmetro
				if (methods[i].getReturnType().equals(clazz)) {
					// verifica se o metodo é um getter para este atributo
					String methodName = methods[i].getName().toLowerCase();
					if (methodName.endsWith(attributeName.toLowerCase())) {
						try {
							// define o objeto
							object = methods[i].invoke(next, EMPTY_ARRAY);
						} catch (Exception e) {
							throw new ResourceWSException(e.getMessage(), e);
						}
					}
				}
			}
		}

		return object;
	}

	protected Object getEntity(SoapMessage message, Class<?> clazz) {
		// objeto que vai ser retornado
		Object object = null;

		// itera sobre o conteúdo da mensagem
		List<?> contentList = (List<?>) message.getContent(List.class);
		for (Iterator<?> it = contentList.iterator(); it.hasNext()
				&& object == null;) {

			// instância do objeto
			Object next = it.next();

			// itera sobre os métodos do objeto
			Method methods[] = next.getClass().getMethods();
			for (int i = 0; i < methods.length && object == null; i++) {

				// verifica se o retorno é igual a classe passada como parâmetro
				if (methods[i].getReturnType().equals(clazz)) {
					try {
						// define o objeto
						object = methods[i].invoke(next, EMPTY_ARRAY);
					} catch (Exception e) {
						throw new ResourceWSException(e.getMessage(), e);
					}
				}
			}
		}

		if (object != null
				&& object.getClass().isAnnotationPresent(XmlType.class))
			return object;
		return null;
	}

	protected HttpServletRequest getRequest(SoapMessage message) {
		HttpServletRequest request = (HttpServletRequest) message
				.get("HTTP.REQUEST");
		return request;
	}

	protected HttpServletResponse getResponse(SoapMessage message) {
		HttpServletResponse response = (HttpServletResponse) message
				.get("HTTP.RESPONSE");
		return response;
	}

	protected Class<?> getServiceInterface(SoapMessage message) {
		Exchange exchange = message.getExchange();
		Service service = (Service) exchange.get(Service.class.getName());
		Class<?> serviceInterface = (Class<?>) service.get("endpoint.class");

		return serviceInterface;
	}

	protected String getServiceOperation(SoapMessage message) {
		String operation = null;
		if (getPhase().equals(Phase.USER_LOGICAL)) {
			QName operationQname = (QName) message
					.get(SoapMessage.WSDL_OPERATION);
			operation = operationQname.getLocalPart();
		} else {
			try {
				// soap message fornecido pelo SAAJInInterceptor
				SOAPMessage soapMessage = message.getContent(SOAPMessage.class);

				// instancia um objeto dom
				DOMSource domSource = new DOMSource(soapMessage.getSOAPBody());
				Node bodyNode = domSource.getNode();
				NodeList childNodes = bodyNode.getChildNodes();

				// itera sobre os nós filhos de "Body" procurando pelo primeiro
				// nó filho do tipo "Element"
				for (int i = 0; i < childNodes.getLength() && operation == null; i++) {
					Node childNode = childNodes.item(i);
					if (childNode.getNodeType() == Node.ELEMENT_NODE) {

						// acessa o nome do nó
						operation = childNode.getLocalName();
					}
				}

			} catch (Exception e) {
				String exceptionMessage;
				if (e instanceof NullPointerException) {
					exceptionMessage = "org.apache.cxf.binding.soap.saaj.SAAJInInterceptor não está na cadeia de interceptadores";
				} else {
					exceptionMessage = e.getMessage();
				}
				throw new ResourceWSException(exceptionMessage, e);
			}
		}

		return operation;
	}
}
