package br.com.kiman.kiprev.ki.xp.dominio.batch;

import javax.enterprise.util.AnnotationLiteral;

import br.com.kiman.kiprev.ki.xp.dominio.anotation.Batch;

public class BatchLiteral extends AnnotationLiteral<Batch> implements Batch {

	private static final long serialVersionUID = -3576004875078679624L;
	private String name;

	public BatchLiteral(String name) {
		this.name = name;
		System.out.println(name);
	}

	@Override
	public String name() {
		return name;
	}

}
