package com.axis.controllers;

import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.axis.security.jwt.*;

import com.axis.models.User;
import com.axis.repository.UserRepository;
import com.axis.security.jwt.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtUtils jwtUtils;

	@GetMapping("/all")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<User> allAccess() {
		return this.userRepository.findAll();
	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	public User userAccess(HttpServletRequest request) {
		final String authorizationHeaderValue = request.getHeader("Authorization");
		String userName = "";
		if (authorizationHeaderValue != null && authorizationHeaderValue.startsWith("Bearer")) {
			String token = authorizationHeaderValue.substring(7, authorizationHeaderValue.length());
			userName = jwtUtils.getUserNameFromJwtToken(token);

		}
		return this.userRepository.findByUsername(userName).get();
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}
