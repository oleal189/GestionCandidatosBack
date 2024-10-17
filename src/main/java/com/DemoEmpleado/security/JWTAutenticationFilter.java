package com.DemoEmpleado.security;

import com.DemoEmpleado.Models.DataAccess;
import com.DemoEmpleado.Repository.UsuarioDetalleImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTAutenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        DataAccess datosAcceso = new DataAccess();
        try{
            datosAcceso = new ObjectMapper().readValue(request.getReader(), DataAccess.class);
        }catch(IOException e){
        }
        UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
              datosAcceso.getEmail(),
              datosAcceso.getPassword(),
              Collections.emptyList()
        );
       return getAuthenticationManager().authenticate(usernamePAT);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        UsuarioDetalleImpl usuarioDetalle = (UsuarioDetalleImpl) authResult.getPrincipal();
        String token = UtilidadesSecurity.crearToken(usuarioDetalle.getNombre(),usuarioDetalle.getUsername());
        response.addHeader("Authorization", "Bearer " + token);
        response.getWriter().flush();

        super.successfulAuthentication(request, response, chain, authResult);

    }
}
