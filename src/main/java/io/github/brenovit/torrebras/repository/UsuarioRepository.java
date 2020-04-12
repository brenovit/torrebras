package io.github.brenovit.torrebras.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.github.brenovit.torrebras.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByUsername(String username);
    @Query(value="select u from Usuario u where u.username = :username or u.email = :username")    
	Optional<Usuario> findByUsernameOrEmail(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
}
