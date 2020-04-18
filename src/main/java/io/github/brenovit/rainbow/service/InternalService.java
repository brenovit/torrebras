package io.github.brenovit.rainbow.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import io.github.brenovit.rainbow.models.Usuario;
import io.github.brenovit.rainbow.security.jwt.JwtUtils;
import io.github.brenovit.rainbow.util.HeaderHelper;

public class InternalService {
	
	@Autowired
	private HeaderHelper headerHelper;
	
	@Autowired	
	private JwtUtils jwtUtils;
	
	@Autowired
	private UsuarioService userService;
		
	public Usuario getLoggedUser() {
		String userName = jwtUtils.getUserNameFromJwtToken(headerHelper.getAuthorization());
		Optional<Usuario> findedUser = userService.findByUsername(userName);
		if(findedUser.isPresent()) {
			return findedUser.get();
		}
		return null;
	}
}
