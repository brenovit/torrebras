package io.github.brenovit.torrebrasil.service;

import static io.github.brenovit.torrebrasil.mapper.CursoMapper.parse;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.brenovit.torrebrasil.exception.ResourceNotFoundException;
import io.github.brenovit.torrebrasil.models.Curso;
import io.github.brenovit.torrebrasil.payload.curso.CursoRequest;
import io.github.brenovit.torrebrasil.payload.curso.CursoResponse;
import io.github.brenovit.torrebrasil.repository.CursoRepository;
import io.github.brenovit.torrebrasil.util.ErrorCode;
import lombok.SneakyThrows;

@Service
public class CursoService extends InternalService {	
	
	@Autowired
	private CursoRepository repository;	
	
	public List<CursoResponse> findAll(){
		return parse(repository.findAll());
	}
	
	@SneakyThrows
	public CursoResponse findById(Long id){
		Optional<Curso> entity = repository.findById(id);
		if(!entity.isPresent()) {
			throw new ResourceNotFoundException(ErrorCode.RESOURCE_NOT_FOUND);
		}
		return parse(entity.get());
	}
	
	public CursoResponse save (CursoRequest request) {
		//product.setUser(getLoggedUser());
		Curso entity = parse(request);
		return parse(repository.save(entity));
	}


	public CursoResponse update(Long id, CursoRequest request) {
		findById(id);
		Curso entity = parse(request);
		return parse(repository.save(entity));
	}	
	
	@SneakyThrows
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
}
