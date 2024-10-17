package com.DemoEmpleado.Repository;

import com.DemoEmpleado.Models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServices implements UserDetailsService {

    @Autowired
    private IUsuarioRepositoryImpl usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Usuario usuario = usuarioRepository.getUsuarioByEmail(username);
            return new UsuarioDetalleImpl(usuario);
    }
}
