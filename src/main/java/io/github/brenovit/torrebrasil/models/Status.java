package io.github.brenovit.torrebrasil.models;

import java.util.stream.Stream;

public enum Status {
	INATIVO(0L), ATIVO(1L), BLOQUEADO(2L);

	private Long value;

	Status(Long value) {
		this.value = value;
	}

	public Long getValue() {
		return this.value;
	}

	public static Status of(Long status) {
		return Stream.of(Status.values()).filter(p -> p.getValue() == status).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
