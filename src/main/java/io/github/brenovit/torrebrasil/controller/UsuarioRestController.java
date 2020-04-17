package io.github.brenovit.torrebrasil.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.brenovit.torrebrasil.payload.response.MessageResponse;
import io.github.brenovit.torrebrasil.payload.usuario.UsuarioResponse;
import io.github.brenovit.torrebrasil.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/usuarios")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class UsuarioRestController {

	private final UsuarioService service;
	
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<UsuarioResponse>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<UsuarioResponse> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@PutMapping("/activate/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> activate(@PathVariable Long id) {
		service.activate(id);
		return ResponseEntity.ok(new MessageResponse("User activate successfully!"));
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
