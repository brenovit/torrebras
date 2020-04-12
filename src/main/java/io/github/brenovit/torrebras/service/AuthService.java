package io.github.brenovit.torrebras.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.brenovit.torrebras.exception.ApplicationException;
import io.github.brenovit.torrebras.models.EPermission;
import io.github.brenovit.torrebras.models.Permissao;
import io.github.brenovit.torrebras.models.Status;
import io.github.brenovit.torrebras.models.Usuario;
import io.github.brenovit.torrebras.payload.auth.SignInRequest;
import io.github.brenovit.torrebras.payload.auth.SignInResponse;
import io.github.brenovit.torrebras.payload.auth.SignUpRequest;
import io.github.brenovit.torrebras.repository.PermissionRepository;
import io.github.brenovit.torrebras.repository.UsuarioRepository;
import io.github.brenovit.torrebras.security.jwt.JwtUtils;
import io.github.brenovit.torrebras.security.services.UserDetailsImpl;
import io.github.brenovit.torrebras.util.ErrorCode;
import io.github.brenovit.torrebras.validator.ValidatorRequestFacade;
import lombok.SneakyThrows;

@Service
public class AuthService extends InternalService {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UsuarioRepository userRepository;

	@Autowired
	private PermissionRepository roleRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private JwtUtils jwtUtils;

	public SignInResponse signin(@Valid SignInRequest request) {
		ValidatorRequestFacade.validate(request);
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword()));

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		List<String> permissions = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		SignInResponse response = new SignInResponse(jwt, userDetails.getUsername(),
				userDetails.getEmail(), permissions);
		return response;
	}

	@SneakyThrows
	public void signup(@Valid SignUpRequest request) {
		if (userRepository.existsByUsername(request.getUsername())
				|| userRepository.existsByEmail(request.getEmail())) {
			throw new ApplicationException(ErrorCode.USER_ALREADY_REGISTERED);
		}

		Usuario user = new Usuario().setUsername(request.getUsername()).setEmail(request.getEmail())
				.setSenha(encoder.encode(request.getPassword())).setStatus(Status.INATIVO);

		Set<Permissao> roles = new HashSet<>();
		List<Permissao> localRoles = roleRepository.findAll();

			Permissao userRole = localRoles.stream()
					.filter(localRole -> localRole.getPermission() == EPermission.USER).findFirst()
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		

		user.setPermissoes(roles);
		userRepository.save(user);
	}
}
