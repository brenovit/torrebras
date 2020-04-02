package io.github.brenovit.torrebras.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.brenovit.torrebras.assembler.ProducResponsetModelAssembler;
import io.github.brenovit.torrebras.models.Colaborador;
import io.github.brenovit.torrebras.payload.product.ProductRequest;
import io.github.brenovit.torrebras.payload.product.ProductResponse;
import io.github.brenovit.torrebras.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class ProductRestController {

	private final ProductService service;
	private final ProducResponsetModelAssembler assembler;
	@Autowired
    private PagedResourcesAssembler<ProductResponse> pagedResourcesAssembler;
	
	@GetMapping	
	public CollectionModel<EntityModel<ProductResponse>> findAll(
			@RequestParam(name = "categoryId", required = false) Long categoryId,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "page", required = false, defaultValue = "0") int page, 
			@RequestParam(name = "size", required = false, defaultValue = "10") int size,
			@RequestParam(name = "sortBy", required = false, defaultValue = "id") String sort) {
		Page<ProductResponse> products = service.findAll(categoryId, name, page, size, sort);		
		return pagedResourcesAssembler.toModel(products, assembler);
	}
	
	public CollectionModel<EntityModel<ProductResponse>> findAll() {
		List<EntityModel<ProductResponse>> products = service.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());
		return new CollectionModel<>(products, linkTo(methodOn(ProductRestController.class).findAll()).withSelfRel());		
	}
	
	@PostMapping
	public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest product) {
		return ResponseEntity.ok(service.save(product));
	}
	
	@GetMapping("/{id}")
	public EntityModel<ProductResponse> findById(@PathVariable Long id) {
		return assembler.toModel(service.findById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductResponse> update(@PathVariable Long id, @Valid @RequestBody ProductRequest product) {
		return ResponseEntity.ok(service.update(id, product));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Colaborador> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
