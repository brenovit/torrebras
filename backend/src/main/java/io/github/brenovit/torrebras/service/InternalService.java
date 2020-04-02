package io.github.brenovit.torrebras.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import io.github.brenovit.torrebras.models.User;
import io.github.brenovit.torrebras.security.jwt.JwtUtils;
import io.github.brenovit.torrebras.util.HeaderHelper;

public class InternalService {
	
	@Autowired
	private HeaderHelper headerHelper;
	
	@Autowired	
	private JwtUtils jwtUtils;
	
	@Autowired
	private UserService userService;
		
	public User getLoggedUser() {
		String userName = jwtUtils.getUserNameFromJwtToken(headerHelper.getAuthorization());
		Optional<User> findedUser = userService.findByUsername(userName);
		if(findedUser.isPresent()) {
			return findedUser.get();
		}
		return null;
	}
}
