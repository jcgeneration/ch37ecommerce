package org.generation.ecommerce.controller;
import javax.servlet.ServletException;

import org.generation.ecommerce.config.JwtFilter;
import org.generation.ecommerce.dto.Token;
import org.generation.ecommerce.model.User;
import org.generation.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Calendar;
import java.util.Date;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RestController
@RequestMapping(path="/api/login/")
public class LoginController {

	private final UserService userService;
	@Autowired
	public LoginController(UserService userService) {
		super();
		this.userService = userService;
	}//constructor

	@PostMapping
	public Token loginUser(@RequestBody User user) throws ServletException {
		if (userService.validateUser(user)) {
			System.out.println("Usuario válido " + user.getEmail());
			return new Token(generateToken(user.getEmail()));
		}//if
throw new ServletException("Nombre de usuario o contraseña incorrectos " + user.getEmail());
	}//loginUser
	
	private String generateToken(String username) {
		Calendar calendar = Calendar.getInstance();//Fecha hora actual
		calendar.add(Calendar.HOUR, 10); // Pruebas
		//calendar.add(Calendar.MINUTE, 30);// Producción
		return Jwts.builder().setSubject(username).claim("role", "user")
		.setIssuedAt(new Date())
		.setExpiration(calendar.getTime())
		.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
		.compact();
	}//generateToken
	
	
	
	
	
	
	
}//class LoginController
