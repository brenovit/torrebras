package io.github.brenovit.torrebras.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.github.brenovit.torrebras.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByUsuario(String usuario);
    @Query(value="select u from Usuario u where u.usuario = :usuario or u.email = :usuario")    
	Optional<Usuario> findByUsuarioOrEmail(String usuario);
	Boolean existsByUsuario(String usuario);
	Boolean existsByEmail(String email);
}
