package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.Unidad;
import cl.cummins.mgdi.exeption.service.UnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/unidad")
public class UnidadController {

    @Autowired
    private UnidadService unidadService;

    @GetMapping
    public ResponseEntity<List<Unidad>> findAll(){
        List<Unidad> unidads = unidadService.findAll();
        return new ResponseEntity<>(unidads, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unidad> findById(@PathVariable("id") Long id){
        Optional<Unidad> unidadOptional = unidadService.findById(id);
        Unidad unidad = null;

        if (unidadOptional.isPresent()){
            unidad = unidadOptional.get();
            return new ResponseEntity<>(unidad, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Unidad> create(@Valid @RequestBody Unidad unidad){
        Unidad unidadNew = unidadService.create(unidad);
        return new ResponseEntity<>(unidadNew, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Unidad> update(@Valid @RequestBody Unidad unidad){
        Optional<Unidad> unidadOld = unidadService.findById(unidad.getId());
        Unidad unidadNew = null;
        if (unidadOld.isPresent()){
            unidadNew = unidadService.update(unidad);
            return new ResponseEntity<>(unidadNew, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id) {
        Optional<Unidad> unidadOld = unidadService.findById(id);
        if (unidadOld.isPresent()) {
            unidadService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
