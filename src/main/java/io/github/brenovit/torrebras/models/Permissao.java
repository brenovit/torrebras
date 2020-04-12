package io.github.brenovit.torrebras.models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="permissao")
@NoArgsConstructor
public class Permissao {
	
	@Id
	@Basic
	private Long id;

	private String descricao;
	
	@Transient
	private EPermission permission;
	
	@PostLoad
	private void fillTransient() {
		if(id > 0) {
			this.permission = EPermission.of(id);
		}
	}	
}
