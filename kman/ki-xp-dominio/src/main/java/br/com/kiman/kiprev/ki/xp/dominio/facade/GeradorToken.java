package br.com.kiman.kiprev.ki.xp.dominio.facade;

import java.util.Calendar;
import java.util.UUID;

import javax.json.Json;
import javax.json.JsonObject;

import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.security.jwt.crypto.sign.Signer;

public class GeradorToken {

	private static final Signer SIGNER = new MacSigner("93074f6f-d1c9-4c5f-90d5-eacc5441107d");

	public static String geraToken(String codUsuario) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, 3);
		long expiraEm = calendar.getTimeInMillis() / 1000;

		JsonObject json = Json.createObjectBuilder().add("codUsuario", codUsuario).add("exp", expiraEm)
				.add("jti", UUID.randomUUID().toString()).build();
		Jwt token = JwtHelper.encode(json.toString(), SIGNER);
		return token.getEncoded();
	}

}
