package br.com.kiman.kiprev.ki.xp.dominio.service;

import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.br.CNPJ;

import com.google.common.base.Strings;

import br.com.kiman.kiprev.ki.xp.dominio.exception.NegocioException;

public class CnpjVO implements DocumentoVO {

	private static final Pattern FORMATADO = Pattern
			.compile("(\\d{2})[.](\\d{3})[.](\\d{3})[/](\\d{4})-(\\d{2})");
	private static final Pattern NAO_FORMATADO = Pattern
			.compile("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})");

	private final String cnpj;
	@CNPJ
	private final String cnpjFormatado;

	public CnpjVO(final String cnpj) throws NegocioException {
		this(cnpj, true);
	}

	public CnpjVO(final String cnpj, boolean valida) throws NegocioException {
		if (Strings.isNullOrEmpty(cnpj)) {
			throw new NegocioException("CNPJ obrigatório.");
		}
		String cnpjNaoFormatado = Optional.ofNullable(cnpj)
				.map(c -> FORMATADO.matcher(cnpj).replaceAll("$1$2$3$4$5"))
				.get();
		cnpjNaoFormatado = Strings.padStart(cnpjNaoFormatado, 14, '0');
		this.cnpj = cnpjNaoFormatado;
		this.cnpjFormatado = NAO_FORMATADO.matcher(cnpjNaoFormatado)
				.replaceAll("$1.$2.$3/$4-$5");
		if (valida) {
			valida();
		}
	}

	private void valida() {
		
		ValidatorFactory validatorFactory = Validation
				.buildDefaultValidatorFactory();
		Validator validator =  validatorFactory.getValidator();
		Set<ConstraintViolation<CnpjVO>> erros = validator.validateProperty(
				this, "cnpjFormatado");
		if (!erros.isEmpty()) {
			ConstraintViolation<CnpjVO> constraintViolation = erros.stream()
					.findFirst().get();
			throw new NegocioException(constraintViolation.getMessage());
		}
	}

	public String getNumeroFormatado() {
		return cnpjFormatado;
	}

	public String getNumero() {
		return cnpj;
	}

	@Override
	public String toString() {
		return cnpj;
	}

	public String getNumeroSemDigitoEFilial() {
		return cnpj.substring(0, 8);
	}

	public String getDigito() {
		return cnpj.substring(12);
	}

	public String getNumeroFilial() {
		return cnpj.substring(8, 12);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CnpjVO) {
			CnpjVO other = (CnpjVO) obj;
			return new EqualsBuilder().append(getNumero(), other.getNumero())
					.isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getNumero()).toHashCode();
	}
}
