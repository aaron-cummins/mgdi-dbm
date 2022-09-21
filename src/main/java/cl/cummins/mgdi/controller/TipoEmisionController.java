package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.TipoEmision;
import cl.cummins.mgdi.exeption.service.TipoEmisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipoemision")
public class TipoEmisionController {

    @Autowired
    private TipoEmisionService tipoEmisionService;

    @GetMapping
    public ResponseEntity<List<TipoEmision>> findAll(){
        List<TipoEmision> tipoEmisions = tipoEmisionService.findAll();
        return new ResponseEntity<>(tipoEmisions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoEmision> findById(@PathVariable("id") Long id){
        Optional<TipoEmision> tipoEmisionOptional = tipoEmisionService.findById(id);
        TipoEmision tipoEmision = null;

        if (tipoEmisionOptional.isPresent()){
            tipoEmision = tipoEmisionOptional.get();
            return new ResponseEntity<>(tipoEmision, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TipoEmision> create(@Valid @RequestBody TipoEmision tipoEmision){
        TipoEmision tipoEmisionNew = tipoEmisionService.create(tipoEmision);
        return new ResponseEntity<>(tipoEmisionNew, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TipoEmision> update(@Valid @RequestBody TipoEmision tipoEmision){
        Optional<TipoEmision> tipoEmisionOld = tipoEmisionService.findById(tipoEmision.getId());
        TipoEmision tipoEmisionNew = null;
        if (tipoEmisionOld.isPresent()){
            tipoEmisionNew = tipoEmisionService.update(tipoEmision);
            return new ResponseEntity<>(tipoEmisionNew, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id) {
        Optional<TipoEmision> tipoEmisionOld = tipoEmisionService.findById(id);
        if (tipoEmisionOld.isPresent()) {
            tipoEmisionService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
