package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.PermisosUsuario;
import cl.cummins.mgdi.service.PermisosUsuario.PermisosUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/permisosusuario")
public class PermisosUsuarioController {

    @Autowired
    private PermisosUsuarioService permisosUsuarioService;

    @GetMapping
    public ResponseEntity<List<PermisosUsuario>> findAll(){
        return ResponseEntity.ok(permisosUsuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermisosUsuario> findById(@PathVariable("id") Long id){
        return permisosUsuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PermisosUsuario> create(@Valid @RequestBody PermisosUsuario permiso){
        return new ResponseEntity<>(permisosUsuarioService.create(permiso), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PermisosUsuario> update(@Valid @RequestBody PermisosUsuario permiso){
        return permisosUsuarioService.findById(permiso.getId())
                .map( c -> ResponseEntity.ok(permisosUsuarioService.update(permiso)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PermisosUsuario> delete(@PathVariable("id")Long id){
        return permisosUsuarioService.findById(id)
                .map( c -> {
                    permisosUsuarioService.delete(id);
                    return ResponseEntity.ok(c);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
