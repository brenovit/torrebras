package io.github.brenovit.torrebrasil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.brenovit.torrebrasil.models.Permissao;

@Repository
public interface PermissionRepository extends JpaRepository<Permissao, Long> {

}