package io.github.brenovit.rainbow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.brenovit.rainbow.models.Permissao;

@Repository
public interface PermissionRepository extends JpaRepository<Permissao, Long> {

}