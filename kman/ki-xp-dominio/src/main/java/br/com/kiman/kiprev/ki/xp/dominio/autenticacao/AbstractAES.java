package br.com.kiman.kiprev.ki.xp.dominio.autenticacao;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import br.com.kiman.kiprev.ki.xp.dominio.exception.NegocioException;

public abstract class AbstractAES {

	protected static final Logger logger = Logger.getLogger(AbstractAES.class);

	private static final String AES = "AES";
	private final String ENCRYPT_METHOD = "AES/CBC/PKCS5PADDING";
	private final String AESKEY = "u2iYlnFdmhM24q3/sUBi8g==";
	protected final String ENCODING = "UTF-8";
	protected final Cipher cipher;
	protected final SecretKeySpec secretKey;
	protected final static String ERRO_AO_INSTANCIAR = "Ocorreu um erro ao tentar criptografar/descriptografar a senha.";

	AbstractAES() {
		try {
			this.cipher = Cipher.getInstance(ENCRYPT_METHOD);
			this.secretKey = new SecretKeySpec(getKey(), AES);
		} catch (Exception e) {
			logger.error(ERRO_AO_INSTANCIAR, e);
			throw new NegocioException(ERRO_AO_INSTANCIAR, e);
		}
	}

	protected byte[] getKey() throws UnsupportedEncodingException {
		return stringToBytes(AESKEY);
	}

	protected String generateKey() throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance(AES);
		kgen.init(128);
		SecretKey aesKey = kgen.generateKey();
		return bytesToString(aesKey.getEncoded());
	}

	protected byte[] stringToBytes(String str)
			throws UnsupportedEncodingException {
		return Base64.decodeBase64(str.getBytes(ENCODING));
	}

	protected String bytesToString(byte[] bytes)
			throws UnsupportedEncodingException {
		return new String(Base64.encodeBase64(bytes), ENCODING);
	}
}
