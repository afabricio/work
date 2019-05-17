package br.com.kiman.kiprev.ki.xp.dominio.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class XPUtil {

	public static Date parseFormatDate(String strDate) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");// 2013-09-10T00:00:00

		if (strDate != null) {
			try {

				return format.parse(strDate);

			} catch (ParseException e) {
				throw new RuntimeException("Não foi possível converter " + strDate + " pra java.util.Date!", e);
			}
		} else {
			return null;
		}

	}

	public static String formatClientDate(Date date) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");// 2013-09-10T00:00:00

		if (date != null) {

			return format.format(date);

		} else {
			return "";
		}

	}

	public static String converteFrmtDecimalBancario(Double num, int lpad, int decimals) {

		double d = Math.pow(10, decimals);

		if (num != null)
			return StringUtils.leftPad(Long.toString(Math.round(num * d)), lpad, "0");
		else
			return "";

	}

	public static String converteFrmtDecimalBancario(Double num) {

		return converteFrmtDecimalBancario(num, 17, 2);

	}

}
