package io.github.brenovit.rainbow.service;

import static io.github.brenovit.rainbow.mapper.FuncaoMapper.parse;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.brenovit.rainbow.exception.ResourceNotFoundException;
import io.github.brenovit.rainbow.models.Funcao;
import io.github.brenovit.rainbow.payload.funcao.FuncaoRequest;
import io.github.brenovit.rainbow.payload.funcao.FuncaoResponse;
import io.github.brenovit.rainbow.repository.FuncaoRepository;
import io.github.brenovit.rainbow.util.ErrorCode;
import lombok.SneakyThrows;

@Service
public class FuncaoService extends InternalService {	
	
	@Autowired
	private FuncaoRepository repository;	
	
	public List<FuncaoResponse> findAll(){
		return parse(repository.findAll());
	}
	
	@SneakyThrows
	public FuncaoResponse findById(Long id){
		Optional<Funcao> entity = repository.findById(id);
		if(!entity.isPresent()) {
			throw new ResourceNotFoundException(ErrorCode.RESOURCE_NOT_FOUND);
		}
		return parse(entity.get());
	}
	
	public FuncaoResponse save (FuncaoRequest request) {
		//product.setUser(getLoggedUser());
		Funcao entity = parse(request);
		return parse(repository.save(entity));
	}


	public FuncaoResponse update(Long id, FuncaoRequest request) {
		findById(id);
		Funcao entity = parse(request);
		return parse(repository.save(entity));
	}	
	
	@SneakyThrows
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
}
