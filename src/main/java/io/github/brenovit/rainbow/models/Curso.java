package io.github.brenovit.rainbow.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity
@Table(name="curso")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String codigo;
	
	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference("curso")
	private List<CursoColaborador> colaboradores = new ArrayList<>();
	
	@CreationTimestamp
	private Date dataCriacao;	
	@UpdateTimestamp
	private Date dataAtualizacao;
	
	public Curso(Long id) {
		this.id = id;
	}
}
