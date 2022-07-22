package cl.cummins.mgdi.security;

import cl.cummins.mgdi.model.Usuario;
import cl.cummins.mgdi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioService.findByCorreo(username);
        if (usuario.isPresent()){
            return new User(usuario.get().getCorreo(), usuario.get().getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Ingrese un usuario valido");
        }
    }
}
