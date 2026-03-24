package com.andres.springboot.app.springboot_crud.security.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.andres.springboot.app.springboot_crud.entities.User;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

private AuthenticationManager authenticationManager;

private final static SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();//la llave secreta

public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {

    authenticationManager = authenticationManager;
}

@Override
public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
        throws AuthenticationException {
User user = null;
String username=null;
String password=null;

try {
    user = new ObjectMapper().readValue(request.getInputStream(), User.class);
    username = user.getUsername();
    password = user.getPassword();
} catch (JacksonException | IOException e) {
    e.printStackTrace();
}

UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);


    return authenticationManager.authenticate(authenticationToken);
}

@Override
protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
        Authentication authResult) throws IOException, ServletException {

        User user = (User) authResult.getPrincipal();
        String username= user.getUsername();
        String token = Jwts.builder().subject(username).signWith(SECRET_KEY).compact();

        response.addHeader("Authorization", " Bearer " + token);
        Map <String, String > bodyJson = new HashMap<>();
        bodyJson.put("token", token);
        bodyJson.put("username", username);
        bodyJson.put("message", String.format("Hola %s has iniciado session con exito", username));

        response.getWriter().write(new ObjectMapper().writeValueAsString(bodyJson));
        response.setContentType("application/json");
        response.setStatus(200);
}








}
