package io.github.brenovit.torrebrasil.service;

import static io.github.brenovit.torrebrasil.mapper.ColaboradorMapper.parse;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.brenovit.torrebrasil.exception.ResourceNotFoundException;
import io.github.brenovit.torrebrasil.models.Colaborador;
import io.github.brenovit.torrebrasil.payload.colaborador.ColaboradorRequest;
import io.github.brenovit.torrebrasil.payload.colaborador.ColaboradorResponse;
import io.github.brenovit.torrebrasil.repository.ColaboradorRepository;
import io.github.brenovit.torrebrasil.util.ErrorCode;
import lombok.SneakyThrows;

@Service
public class ColaboradorService extends InternalService {	
	
	@Autowired
	private ColaboradorRepository repository;	
	
	public List<ColaboradorResponse> findAll(){
		return parse(repository.findAll());
	}
	
	@SneakyThrows
	public ColaboradorResponse findById(Long id){
		Optional<Colaborador> entity = repository.findById(id);
		if(!entity.isPresent()) {
			throw new ResourceNotFoundException(ErrorCode.RESOURCE_NOT_FOUND);
		}
		return parse(entity.get());
	}
	
	public ColaboradorResponse save (ColaboradorRequest request) {
		//product.setUser(getLoggedUser());
		Colaborador entity = parse(request);
		return parse(repository.save(entity));
	}


	public ColaboradorResponse update(Long id, ColaboradorRequest request) {
		findById(id);
		Colaborador entity = parse(request);
		return parse(repository.save(entity));
	}	
	
	@SneakyThrows
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
}
