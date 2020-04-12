package io.github.brenovit.torrebras.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.brenovit.torrebras.models.Usuario;
import io.github.brenovit.torrebras.repository.UsuarioRepository;

@Service
public class UserService extends InternalService {
		
	@Autowired
	private UsuarioRepository userRepository;

	public Optional<Usuario> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public Optional<Usuario> findByUsernameOrEmail(String username) {		
		return userRepository.findByUsernameOrEmail(username);
	}

}
