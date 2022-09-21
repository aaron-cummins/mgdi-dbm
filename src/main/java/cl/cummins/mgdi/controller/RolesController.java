package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.Roles;
import cl.cummins.mgdi.exeption.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @GetMapping
    public ResponseEntity<List<Roles>> findAll(){
        return ResponseEntity.ok(rolesService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Roles> findById(@PathVariable("id") Long id){
        return rolesService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Roles> create(@Valid @RequestBody Roles roles){
        return new ResponseEntity<>(rolesService.create(roles), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Roles> update(@Valid @RequestBody Roles roles){
        return rolesService.findById(roles.getId())
                .map( c -> ResponseEntity.ok(rolesService.update(roles)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id){
        return rolesService.findById(id)
                .map( c -> {
                    rolesService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
