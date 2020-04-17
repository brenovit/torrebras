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

import io.github.brenovit.torrebrasil.payload.curso.CursoRequest;
import io.github.brenovit.torrebrasil.payload.curso.CursoResponse;
import io.github.brenovit.torrebrasil.service.CursoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/cursos")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class CursoRestController {

	private final CursoService service;
		
	@GetMapping	
	public ResponseEntity<List<CursoResponse>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}		

	@PostMapping
	public ResponseEntity<CursoResponse> create(@Valid @RequestBody CursoRequest curso) {
		return ResponseEntity.ok(service.save(curso));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CursoResponse> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<CursoResponse> update(@PathVariable Long id, @Valid @RequestBody CursoRequest curso) {
		return ResponseEntity.ok(service.update(id, curso));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
