package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.Vistas;
import cl.cummins.mgdi.service.VistasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/vistas")
public class VistasController {

    @Autowired
    private VistasService vistasService;

    @GetMapping
    public ResponseEntity<List<Vistas>> findAll(){
        return ResponseEntity.ok(vistasService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vistas> findById(@PathVariable("id") Long id){
        return vistasService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Vistas> create(@Valid @RequestBody Vistas vista){
        return new ResponseEntity<>(vistasService.create(vista), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Vistas> update(@Valid @RequestBody Vistas vista){
        return vistasService.findById(vista.getId())
                .map( c -> ResponseEntity.ok(vistasService.update(vista)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Vistas> delete(@PathVariable("id")Long id){
        return vistasService.findById(id)
                .map( c -> {
                    vistasService.delete(id);
                    return ResponseEntity.ok(c);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
