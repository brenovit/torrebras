package io.github.brenovit.torrebras.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.brenovit.torrebras.exception.ResourceNotFoundException;
import io.github.brenovit.torrebras.mapper.UsuarioMapper;
import io.github.brenovit.torrebras.models.Status;
import io.github.brenovit.torrebras.models.Usuario;
import io.github.brenovit.torrebras.payload.usuario.UsuarioResponse;
import io.github.brenovit.torrebras.repository.UsuarioRepository;
import io.github.brenovit.torrebras.util.ErrorCode;
import lombok.SneakyThrows;

@Service
public class UsuarioService extends InternalService {
		
	@Autowired
	private UsuarioRepository repository;

	public Optional<Usuario> findByUsername(String username) {
		return repository.findByUsername(username);
	}

	public Optional<Usuario> findByUsernameOrEmail(String username) {		
		return repository.findByUsernameOrEmail(username);
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
