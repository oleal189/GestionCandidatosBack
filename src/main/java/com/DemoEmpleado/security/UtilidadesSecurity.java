package com.DemoEmpleado.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UtilidadesSecurity {

    private final static String TokenAccesoSecreto ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
    private final static Long  TokenAccesoSecretoDuracion = 1000L;

    public static String crearToken(String usuario, String email){
        long expiracion = TokenAccesoSecretoDuracion * 1_000;
      Date tiempoExpiracion = new Date(System.currentTimeMillis() +expiracion );
      Map<String, Object> data = new HashMap<>();
      data.put("usuario", usuario);
      return Jwts.builder()
              .setSubject(email)
              .setExpiration(tiempoExpiracion)
              .addClaims(data)
              .signWith(Keys.hmacShaKeyFor(TokenAccesoSecreto.getBytes()))
        .compact();
    }

    public static UsernamePasswordAuthenticationToken obtenerAutenticacion(String token){
       try {
           Claims claims = Jwts.parserBuilder()
                   .setSigningKey(TokenAccesoSecreto.getBytes())
                   .build()
                   .parseClaimsJws(token)
                   .getBody();

           String correo = claims.getSubject();

           return new UsernamePasswordAuthenticationToken(correo, null, Collections.emptyList());
       } catch(JwtException e){
        return null;
       }
       }

}
