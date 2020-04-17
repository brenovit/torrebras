package io.github.brenovit.torrebrasil.controller;

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

import io.github.brenovit.torrebrasil.payload.colaborador.ColaboradorRequest;
import io.github.brenovit.torrebrasil.payload.colaborador.ColaboradorResponse;
import io.github.brenovit.torrebrasil.service.ColaboradorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/colaboradores")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class ColaboradorRestController {

	private final ColaboradorService service;
		
	@GetMapping	
	public ResponseEntity<List<ColaboradorResponse>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}		

	@PostMapping
	public ResponseEntity<ColaboradorResponse> create(@Valid @RequestBody ColaboradorRequest colaborador) {
		return ResponseEntity.ok(service.save(colaborador));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ColaboradorResponse> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ColaboradorResponse> update(@PathVariable Long id, @Valid @RequestBody ColaboradorRequest colaborador) {
		return ResponseEntity.ok(service.update(id, colaborador));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
