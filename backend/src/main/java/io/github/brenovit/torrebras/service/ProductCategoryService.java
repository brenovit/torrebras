package io.github.brenovit.torrebras.service;

import static io.github.brenovit.torrebras.mapper.ProductMapper.parse;
import static io.github.brenovit.torrebras.mapper.ProductMapper.parseCategory;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.brenovit.torrebras.exception.ResourceNotFoundException;
import io.github.brenovit.torrebras.models.Funcao;
import io.github.brenovit.torrebras.payload.product.ProductCategoryResponse;
import io.github.brenovit.torrebras.repository.FuncaoRepository;
import lombok.SneakyThrows;

@Service
public class ProductCategoryService {
	
	@Autowired
	private FuncaoRepository repository;
	
	public List<ProductCategoryResponse> findAll(){
		return parseCategory(repository.findAll());
	}
	
	@SneakyThrows
	public ProductCategoryResponse findById(Long id){
		Optional<Funcao> product = repository.findById(id);
		if(!product.isPresent()) {
			throw new ResourceNotFoundException();
		}
		return parse(product.get());
	}
	
	public ProductCategoryResponse save (Funcao request) {
		return parse(repository.save(request));
	}


	public ProductCategoryResponse update(Long id, Funcao request) {
		findById(id);
		return parse(repository.save(request));
	}	
	
	@SneakyThrows
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
}
