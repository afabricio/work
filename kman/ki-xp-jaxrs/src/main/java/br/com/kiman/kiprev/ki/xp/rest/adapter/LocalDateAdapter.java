package br.com.kiman.kiprev.ki.xp.rest.adapter;
//package br.com.kiman.kiprev.ki.porto.jaxws.cliente.adapter;
//
//import java.time.DateTimeException;
//import java.time.LocalDate;
//
//import javax.xml.bind.annotation.adapters.XmlAdapter;
//
//import br.com.kiman.kiprev.ki.porto.dominio.exception.ValidacaoException;
//import br.com.kiman.kiprev.ki.porto.dominio.util.ConversorDataUtil;
//
//public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
//
//	public LocalDate unmarshal(String v) throws Exception {
//		try {
//			return ConversorDataUtil.conveterLocalDateDefault(v);
//		} catch (DateTimeException e) {
//			throw new ValidacaoException("Data inválida: " + v);
//		}
//	}
//
//	public String marshal(LocalDate v) throws Exception {
//		return ConversorDataUtil.converteToString(v);
//	}
//
//}
