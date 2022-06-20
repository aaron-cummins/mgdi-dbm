package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.PermisosGlobales;
import cl.cummins.mgdi.service.PermisosGlobalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/permisosglobales")
public class PermisosGlobalesController {

    @Autowired
    private PermisosGlobalesService permisosService;


    @GetMapping
    public ResponseEntity<List<PermisosGlobales>> findAll(){
        return ResponseEntity.ok(permisosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermisosGlobales> findById(@PathVariable("id") Long id){
        return permisosService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PermisosGlobales> create(@Valid @RequestBody PermisosGlobales permiso){
        return new ResponseEntity<>(permisosService.create(permiso), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PermisosGlobales> update(@Valid @RequestBody PermisosGlobales permiso){
        return permisosService.findById(permiso.getId())
                .map( c -> ResponseEntity.ok(permisosService.update(permiso)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id){
        return permisosService.findById(id)
                .map( c -> {
                    permisosService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
