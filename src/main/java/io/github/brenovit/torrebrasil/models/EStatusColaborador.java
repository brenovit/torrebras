package io.github.brenovit.torrebrasil.models;

import java.util.stream.Stream;

public enum EStatusColaborador {
	ATIVO(1L),
	INATIVO(2L),
	BLOQUEADO(3L);
	
	private Long value;
	
	EStatusColaborador (Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}
	
	public static EStatusColaborador of(Long status) {
		return Stream.of(EStatusColaborador.values())
				.filter(p -> p.getValue() == status)
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
