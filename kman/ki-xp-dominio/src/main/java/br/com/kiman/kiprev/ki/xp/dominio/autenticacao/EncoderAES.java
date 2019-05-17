package br.com.kiman.kiprev.ki.xp.dominio.autenticacao;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.codec.binary.Base64;

import br.com.kiman.kiprev.ki.xp.dominio.exception.NegocioException;

public class EncoderAES extends AbstractAES {

	private static final String ERRO_AO_CRIPTOGRAFAR_A_SENHA = "Ocorreu um erro ao criptografar a senha.";
	private String iVector;

	public String encryt(String string) {
		try {
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] encrypted = cipher.doFinal(string.getBytes(ENCODING));
			byte[] iv = cipher.getParameters()
					.getParameterSpec(IvParameterSpec.class).getIV();
			this.iVector = new String(Base64.encodeBase64(iv), ENCODING);
			return bytesToString(encrypted);
		} catch (Exception e) {
			logger.error(ERRO_AO_CRIPTOGRAFAR_A_SENHA, e);
			throw new NegocioException(ERRO_AO_CRIPTOGRAFAR_A_SENHA);
		}
	}

	public String getIVector() {
		return iVector;
	}

}
