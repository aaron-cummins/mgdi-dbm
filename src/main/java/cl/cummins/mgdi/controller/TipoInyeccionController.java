package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.TipoInyeccion;
import cl.cummins.mgdi.exeption.service.TipoInyeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipoinyeccion")
public class TipoInyeccionController {

    @Autowired
    private TipoInyeccionService tipoInyeccionService;

    @GetMapping
    public ResponseEntity<List<TipoInyeccion>> findAll(){
        List<TipoInyeccion> tipoInyeccions = tipoInyeccionService.findAll();
        return new ResponseEntity<>(tipoInyeccions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoInyeccion> findById(@PathVariable("id") Long id){
        Optional<TipoInyeccion> tipoInyeccionOptional = tipoInyeccionService.findById(id);
        TipoInyeccion tipoInyeccion = null;

        if (tipoInyeccionOptional.isPresent()){
            tipoInyeccion = tipoInyeccionOptional.get();
            return new ResponseEntity<>(tipoInyeccion, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TipoInyeccion> create(@Valid @RequestBody TipoInyeccion tipoInyeccion){
        TipoInyeccion tipoInyeccionNew = tipoInyeccionService.create(tipoInyeccion);
        return new ResponseEntity<>(tipoInyeccionNew, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TipoInyeccion> update(@Valid @RequestBody TipoInyeccion tipoInyeccion){
        Optional<TipoInyeccion> tipoInyeccionOld = tipoInyeccionService.findById(tipoInyeccion.getId());
        TipoInyeccion tipoInyeccionNew = null;
        if (tipoInyeccionOld.isPresent()){
            tipoInyeccionNew = tipoInyeccionService.update(tipoInyeccion);
            return new ResponseEntity<>(tipoInyeccionNew, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id) {
        Optional<TipoInyeccion> tipoInyeccionOld = tipoInyeccionService.findById(id);
        if (tipoInyeccionOld.isPresent()) {
            tipoInyeccionService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
