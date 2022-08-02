package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.Aplicacion;
import cl.cummins.mgdi.service.AplicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aplicacionoem")
public class AplicacionController {

    @Autowired
    private AplicacionService aplicacionService;

    @GetMapping
    public ResponseEntity<List<Aplicacion>> findAll(){
        List<Aplicacion> aplicacions = aplicacionService.findAll();
        return new ResponseEntity<>(aplicacions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aplicacion> findById(@PathVariable("id") Long id){
        Optional<Aplicacion> aplicacionOptional = aplicacionService.findById(id);
        Aplicacion aplicacion = null;

        if (aplicacionOptional.isPresent()){
            aplicacion = aplicacionOptional.get();
            return new ResponseEntity<>(aplicacion, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Aplicacion> create(@Valid @RequestBody Aplicacion aplicacion){
        Aplicacion aplicacionNew = aplicacionService.create(aplicacion);
        return new ResponseEntity<>(aplicacionNew, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Aplicacion> update(@Valid @RequestBody Aplicacion aplicacion){
        Optional<Aplicacion> aplicacionOld = aplicacionService.findById(aplicacion.getId());
        Aplicacion aplicacionNew = null;
        if (aplicacionOld.isPresent()){
            aplicacionNew = aplicacionService.update(aplicacion);
            return new ResponseEntity<>(aplicacionNew, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id) {
        Optional<Aplicacion> aplicacionOld = aplicacionService.findById(id);
        if (aplicacionOld.isPresent()) {
            aplicacionService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
