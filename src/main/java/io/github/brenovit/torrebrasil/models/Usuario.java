package io.github.brenovit.torrebrasil.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity
@Table(	name = "usuario", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "usuario"),
			@UniqueConstraint(columnNames = "email") 
		})
@Data
@NoArgsConstructor
@Accessors(chain=true)
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String usuario;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	
	private String nome;
	
	private String cpf;	

	@NotBlank
	@Size(max = 120)
	private String senha;
	
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "permissoes_usuario", 
				joinColumns = @JoinColumn(name = "usuario_id"), 
				inverseJoinColumns = @JoinColumn(name = "permissao_id"))
	private Set<Permissao> permissoes = new HashSet<>();
	
	@CreationTimestamp
	private Date dataCriacao;	
	@UpdateTimestamp
	private Date dataAtualizacao;
	
	public Usuario(String usuario, String email, String senha) {
		this.usuario = usuario;
		this.email = email;
		this.senha = senha;
	}

	@SuppressWarnings("unlikely-arg-type")
	public boolean hasPermission(EPermission role) {		
		return permissoes.contains(role);
	}
	
}
