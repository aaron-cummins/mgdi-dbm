package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.AplicacionOem;
import cl.cummins.mgdi.service.AplicacionOemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aplicacionoem")
public class AplicacionOemController {

    @Autowired
    private AplicacionOemService aplicacionOemService;

    @GetMapping
    public ResponseEntity<List<AplicacionOem>> findAll(){
        List<AplicacionOem> aplicacionOems = aplicacionOemService.findAll();
        return new ResponseEntity<>(aplicacionOems, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AplicacionOem> findById(@PathVariable("id") Long id){
        Optional<AplicacionOem> aplicacionOemOptional = aplicacionOemService.findById(id);
        AplicacionOem aplicacionOem = null;

        if (aplicacionOemOptional.isPresent()){
            aplicacionOem = aplicacionOemOptional.get();
            return new ResponseEntity<>(aplicacionOem, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AplicacionOem> create(@Valid @RequestBody AplicacionOem aplicacionOem){
        AplicacionOem aplicacionOemNew = aplicacionOemService.create(aplicacionOem);
        return new ResponseEntity<>(aplicacionOemNew, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<AplicacionOem> update(@Valid @RequestBody AplicacionOem aplicacionOem){
        Optional<AplicacionOem> aplicacionOemOld = aplicacionOemService.findById(aplicacionOem.getId());
        AplicacionOem aplicacionOemNew = null;
        if (aplicacionOemOld.isPresent()){
            aplicacionOemNew = aplicacionOemService.update(aplicacionOem);
            return new ResponseEntity<>(aplicacionOemNew, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id){
        return aplicacionOemService.findById(id)
                .map( c -> {
                    aplicacionOemService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
