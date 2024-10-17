package com.DemoEmpleado.Repository;



import com.DemoEmpleado.Models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class IUsuarioRepositoryImpl {

    @Autowired
    IUsuarioRepository usuarioRepository;

    public Iterable<Usuario> getUsuario() {

        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Integer id) {
        return usuarioRepository.findById(id).get();
    }

    public Usuario getUsuarioByEmail(String correo){
       Usuario usuario = usuarioRepository.findOneByEmail(correo)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));
        return usuario;
    }
    public void saveUsuario(Usuario p) {
        usuarioRepository.save(p);
    }

    public Boolean deleteUsuario(Usuario p) {
        usuarioRepository.delete(p);
        return true;
    }

}
