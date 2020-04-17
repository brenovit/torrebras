package io.github.brenovit.torrebrasil.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CursoColaboradorId implements Serializable {
	
	private static final long serialVersionUID = -5994652237615986889L;
	
	@Column(name="curso_id")
	private Long cursoId;
	@Column(name="colaborador_id")
	private Long colaboradorId;	
}
