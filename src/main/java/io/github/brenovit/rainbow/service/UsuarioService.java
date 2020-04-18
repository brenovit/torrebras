package io.github.brenovit.rainbow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.brenovit.rainbow.exception.ResourceNotFoundException;
import io.github.brenovit.rainbow.mapper.UsuarioMapper;
import io.github.brenovit.rainbow.models.Status;
import io.github.brenovit.rainbow.models.Usuario;
import io.github.brenovit.rainbow.payload.usuario.UsuarioResponse;
import io.github.brenovit.rainbow.repository.UsuarioRepository;
import io.github.brenovit.rainbow.util.ErrorCode;
import lombok.SneakyThrows;

@Service
public class UsuarioService extends InternalService {
		
	@Autowired
	private UsuarioRepository repository;

	public Optional<Usuario> findByUsername(String username) {
		return repository.findByUsuario(username);
	}

	public Optional<Usuario> findByUsernameOrEmail(String username) {		
		return repository.findByUsuarioOrEmail(username);
	}

	public void activate(Long id) {
		Usuario usuario = find(id);
		usuario.setStatus(Status.ATIVO);
		repository.save(usuario);		
	}

	public List<UsuarioResponse> findAll() {
		return UsuarioMapper.parse(repository.findAll());
	}
	
	@SneakyThrows
	private Usuario find(Long id) {
		Optional<Usuario> entity = repository.findById(id);
		if(!entity.isPresent()) {
			throw new ResourceNotFoundException(ErrorCode.RESOURCE_NOT_FOUND);
		}
		return entity.get();
	}

	public UsuarioResponse findById(Long id) {		
		return UsuarioMapper.parse(find(id));
	}

	public void delete(Long id) {
		Usuario usuario = find(id);
		usuario.setStatus(Status.INATIVO);
		repository.save(usuario);
	}

}
