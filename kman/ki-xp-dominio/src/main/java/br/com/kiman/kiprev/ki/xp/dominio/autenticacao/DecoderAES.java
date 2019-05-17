package br.com.kiman.kiprev.ki.xp.dominio.autenticacao;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;

import br.com.kiman.kiprev.ki.xp.dominio.exception.NegocioException;

public class DecoderAES extends AbstractAES {

	private static final String ERRO_AO_DESCRIPTOGRAFAR_A_SENHA = "Erro ao descriptografar a senha.";

	public String decrypt(String initializationVector, String senhaCriptografada) {
		try {
			IvParameterSpec IVSpec = new IvParameterSpec(
					stringToBytes(initializationVector));
			cipher.init(Cipher.DECRYPT_MODE, secretKey, IVSpec);
			byte[] decrypted = cipher
					.doFinal(stringToBytes(senhaCriptografada));
			return new String(decrypted, ENCODING);
		} catch (Exception e) {
			logger.error(ERRO_AO_DESCRIPTOGRAFAR_A_SENHA, e);
			throw new NegocioException(ERRO_AO_DESCRIPTOGRAFAR_A_SENHA);
		}
	}

}
