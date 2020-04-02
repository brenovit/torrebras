package io.github.brenovit.torrebras.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.brenovit.torrebras.models.CursoColaborador;
import io.github.brenovit.torrebras.repository.CursoColaboradorRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/cursoscolaboradores")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class CursoColaboradorRestController {

	private final CursoColaboradorRepository repository;
		
	@GetMapping	
	public ResponseEntity<List<CursoColaborador>> findAll() {
		return ResponseEntity.ok(repository.findAll());
	}		

	@PostMapping
	public ResponseEntity<CursoColaborador> create(@Valid @RequestBody CursoColaborador product) {
		return ResponseEntity.ok(repository.save(product));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CursoColaborador> findById(@PathVariable Long id) {
		return ResponseEntity.ok(repository.findById(id).get());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		repository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
