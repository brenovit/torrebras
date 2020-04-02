package io.github.brenovit.torrebras.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.brenovit.torrebras.models.Funcao;
import io.github.brenovit.torrebras.payload.product.ProductCategoryResponse;
import io.github.brenovit.torrebras.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/product-categories")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class ProductCategoryRestController {

	private final ProductCategoryService service;
		
	@GetMapping	
	public ResponseEntity<List<ProductCategoryResponse>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}		

	@PostMapping
	public ResponseEntity<ProductCategoryResponse> create(@Valid @RequestBody Funcao product) {
		return ResponseEntity.ok(service.save(product));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductCategoryResponse> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductCategoryResponse> update(@PathVariable Long id, @Valid @RequestBody Funcao product) {
		return ResponseEntity.ok(service.update(id, product));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
