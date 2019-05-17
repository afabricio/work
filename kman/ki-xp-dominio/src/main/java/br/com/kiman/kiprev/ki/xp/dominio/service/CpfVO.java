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
import org.hibernate.validator.constraints.br.CPF;

import com.google.common.base.Strings;

import br.com.kiman.kiprev.ki.xp.dominio.exception.NegocioException;

public class CpfVO implements DocumentoVO {

	private static final Pattern FORMATADO = Pattern
			.compile("(\\d{3})[.](\\d{3})[.](\\d{3})-(\\d{2})");
	private static final Pattern NAO_FORMATADO = Pattern
			.compile("(\\d{3})(\\d{3})(\\d{3})(\\d{2})");

	private final String cpf;
	@CPF
	private final String cpfFormatado;

	public CpfVO(final String cpf) throws NegocioException {
		this(cpf, true);
	}

	public CpfVO(final String cpf, boolean valida) throws NegocioException {
		if (Strings.isNullOrEmpty(cpf)) {
			throw new NegocioException("CPF obrigatório.");
		}
		String cpfNaoFormatado = Optional.ofNullable(cpf)
				.map(c -> FORMATADO.matcher(cpf).replaceAll("$1$2$3$4")).get();
		cpfNaoFormatado =Strings.padStart(cpfNaoFormatado, 11,'0' );
		this.cpf = cpfNaoFormatado;
		this.cpfFormatado = NAO_FORMATADO.matcher(cpfNaoFormatado).replaceAll(
				"$1.$2.$3-$4");
		if (valida) {
			valida();
		}
	}

	private void valida() {
		ValidatorFactory validatorFactory = Validation
				.buildDefaultValidatorFactory();
		Validator validator =  validatorFactory.getValidator();
		Set<ConstraintViolation<CpfVO>> erros = validator.validateProperty(
				this, "cpfFormatado");
		if (!erros.isEmpty()) {
			ConstraintViolation<CpfVO> constraintViolation = erros.stream()
					.findFirst().get();
			throw new NegocioException(constraintViolation.getMessage());
		}
	}

	public String getNumeroFormatado() {
		return cpfFormatado;
	}

	public String getNumero() {
		return cpf;
	}

	@Override
	public String toString() {
		return cpf;
	}

	public String getNumeroSemDigito() {
		return cpf.substring(0, 9);
	}

	public String getDigito() {
		return cpf.substring(9);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CpfVO) {
			CpfVO other = (CpfVO) obj;
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
