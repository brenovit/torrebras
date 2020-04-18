package io.github.brenovit.rainbow.controller;

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

import io.github.brenovit.rainbow.payload.funcao.FuncaoRequest;
import io.github.brenovit.rainbow.payload.funcao.FuncaoResponse;
import io.github.brenovit.rainbow.service.FuncaoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/funcoes")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class FuncaoRestController {

	private final FuncaoService service;
		
	@GetMapping	
	public ResponseEntity<List<FuncaoResponse>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}		

	@PostMapping
	public ResponseEntity<FuncaoResponse> create(@Valid @RequestBody FuncaoRequest funcao) {
		return ResponseEntity.ok(service.save(funcao));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FuncaoResponse> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<FuncaoResponse> update(@PathVariable Long id, @Valid @RequestBody FuncaoRequest funcao) {
		return ResponseEntity.ok(service.update(id,funcao));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
