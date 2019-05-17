package br.com.kiman.kiprev.ki.xp.dominio.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ZDateAdapter extends XmlAdapter<String, Date> {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ'Z'");

	public Date unmarshal(String v) throws Exception {

		return sdf.parse(v);

	}

	public String marshal(Date v) throws Exception {

		return sdf.format(v);

	}

}
