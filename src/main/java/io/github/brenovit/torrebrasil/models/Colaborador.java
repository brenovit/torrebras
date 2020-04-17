package io.github.brenovit.torrebrasil.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(	name = "colaborador")
@Accessors(chain = true)
public class Colaborador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "funcao_id", nullable = false)
	@JsonBackReference
	private Funcao funcao;
	private String nome;
	private String matricula;
	private String foto;
	private String mensagem;
	
	@OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference("colaborador")
	private List<CursoColaborador> cursos = new ArrayList<>();;
	
	@Enumerated(EnumType.ORDINAL)
	private EStatusColaborador status; 
	
	@CreationTimestamp
	private Date dataCriacao;	
	@UpdateTimestamp
	private Date dataAtualizacao;
}

