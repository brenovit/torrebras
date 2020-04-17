package io.github.brenovit.torrebrasil.models;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="curso_colaborador")
@Data
@NoArgsConstructor
public class CursoColaborador{
	
	@EmbeddedId
	private CursoColaboradorId id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("cursoId")
	@JsonBackReference("curso")
	private Curso curso;
	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("colaboradorId")
	@JsonBackReference("colaborador")
	private Colaborador colaborador;
	
	private Date validade;
	
	@CreationTimestamp
	private Date dataCriacao;	
	@UpdateTimestamp
	private Date dataAtualizacao;
	
	public CursoColaborador(Long cursoId, Long colaboradorId) {
		this.curso = new Curso().setId(cursoId);
		this.colaborador = new Colaborador().setId(colaboradorId);
		this.id = new CursoColaboradorId(curso.getId(), colaborador.getId());
	} 
	
	public CursoColaborador(Curso curso, Colaborador colaborador) {
		this.curso = curso;
		this.colaborador = colaborador;
		this.id = new CursoColaboradorId(curso.getId(), colaborador.getId());
	}
}
