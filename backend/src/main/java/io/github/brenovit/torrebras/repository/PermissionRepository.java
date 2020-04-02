package io.github.brenovit.torrebras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.brenovit.torrebras.models.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}