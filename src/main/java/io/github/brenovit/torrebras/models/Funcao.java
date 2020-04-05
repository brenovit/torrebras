package io.github.brenovit.torrebras.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

@Entity
@Table(name="funcao")
@Data
@NoArgsConstructor
public class Funcao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
		
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "funcao", fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<Colaborador> funcoes;
	
	@CreationTimestamp
	private Date dataCriacao;	
	@UpdateTimestamp
	private Date dataAtualizacao;
	
	public Funcao(Long id) {
		this.id = id;
	}
}
