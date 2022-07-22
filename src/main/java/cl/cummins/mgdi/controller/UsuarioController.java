package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.Usuario;
import cl.cummins.mgdi.model.UsuarioRest;
import cl.cummins.mgdi.service.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioRest>> findAll(){
        List<Usuario> usuarios = usuarioService.findAll();
        List<UsuarioRest> usuarioRestList = new ArrayList<>();
        UsuarioRest usuarioRest = null;

       for(Usuario usuario: usuarios){
            usuarioRest = new UsuarioRest();
            BeanUtils.copyProperties(usuario, usuarioRest);
            usuarioRestList.add(usuarioRest);
       }

        return new ResponseEntity<>(usuarioRestList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioRest> findById(@PathVariable("id") Long id){
        Optional<Usuario> usuario = usuarioService.findById(id);
        UsuarioRest usuarioRest = new UsuarioRest();
        if (usuario.isPresent()){
            BeanUtils.copyProperties(usuario, usuarioRest);

            return new ResponseEntity<>(usuarioRest, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/login/{correo}")
    public ResponseEntity<Usuario> findByCorreo(@PathVariable("correo") String correo){
        return usuarioService.findByCorreo(correo)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioService.create(usuario), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Usuario> update(@Valid @RequestBody Usuario usuario){
        return usuarioService.findById(usuario.getId())
                .map( c -> ResponseEntity.ok(usuarioService.update(usuario)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id){
        return usuarioService.findById(id)
                .map( c -> {
                    usuarioService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
