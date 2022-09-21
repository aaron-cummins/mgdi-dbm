package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.Flotas;
import cl.cummins.mgdi.exeption.service.FlotasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flotas")
public class FlotasController {

    @Autowired
    private FlotasService flotasService;

    @GetMapping
    public ResponseEntity<List<Flotas>> findAll(){
        List<Flotas> flotass = flotasService.findAll();
        return new ResponseEntity<>(flotass, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flotas> findById(@PathVariable("id") Long id){
        Optional<Flotas> flotasOptional = flotasService.findById(id);
        Flotas flotas = null;

        if (flotasOptional.isPresent()){
            flotas = flotasOptional.get();
            return new ResponseEntity<>(flotas, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Flotas> create(@Valid @RequestBody Flotas flotas){
        Flotas flotasNew = flotasService.create(flotas);
        return new ResponseEntity<>(flotasNew, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Flotas> update(@Valid @RequestBody Flotas flotas){
        Optional<Flotas> flotasOld = flotasService.findById(flotas.getId());
        Flotas flotasNew = null;
        if (flotasOld.isPresent()){
            flotasNew = flotasService.update(flotas);
            return new ResponseEntity<>(flotasNew, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id) {
        Optional<Flotas> flotasOld = flotasService.findById(id);
        if (flotasOld.isPresent()) {
            flotasService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
