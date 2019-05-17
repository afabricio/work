package br.com.kiman.kiprev.ki.xp.integration;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import org.apache.log4j.Logger;

public class WrapperOutputStream extends FilterOutputStream {

	private static final Logger logger = Logger.getLogger(WrapperOutputStream.class);
	private final ByteArrayOutputStream baos = new ByteArrayOutputStream();

	public WrapperOutputStream(OutputStream out) {
		super(out);
	}

	public String getAsString() {
		try {
			return baos.toString(StandardCharsets.UTF_8.name());
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public void write(final int i) throws IOException {
		super.write(i);
		baos.write(i);
	}

	@Override
	public void close() throws IOException {
		super.close();
		baos.close();
	}
	
	@Override
	public void flush() throws IOException {
		super.flush();
		baos.flush();
	}
}
