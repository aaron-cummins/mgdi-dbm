package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.TipoLugarTrabajo;
import cl.cummins.mgdi.service.TipoLugarTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipolugartrabajo")
public class TipoLugarTrabajoController {

    @Autowired
    private TipoLugarTrabajoService tipoLugarTrabajoService;

    @GetMapping
    public ResponseEntity<List<TipoLugarTrabajo>> findAll(){
        List<TipoLugarTrabajo> tipoLugarTrabajos = tipoLugarTrabajoService.findAll();
        return new ResponseEntity<>(tipoLugarTrabajos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoLugarTrabajo> findById(@PathVariable("id") Long id){
        Optional<TipoLugarTrabajo> tipoLugarTrabajoOptional = tipoLugarTrabajoService.findById(id);
        TipoLugarTrabajo tipoLugarTrabajo = null;

        if (tipoLugarTrabajoOptional.isPresent()){
            tipoLugarTrabajo = tipoLugarTrabajoOptional.get();
            return new ResponseEntity<>(tipoLugarTrabajo, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TipoLugarTrabajo> create(@Valid @RequestBody TipoLugarTrabajo tipoEmision){
        TipoLugarTrabajo tipoLugarTrabajoNew = tipoLugarTrabajoService.create(tipoEmision);
        return new ResponseEntity<>(tipoLugarTrabajoNew, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TipoLugarTrabajo> update(@Valid @RequestBody TipoLugarTrabajo tipoEmision){
        Optional<TipoLugarTrabajo> tipoLugarTrabajoOld = tipoLugarTrabajoService.findById(tipoEmision.getId());
        TipoLugarTrabajo tipoLugarTrabajoNew = null;
        if (tipoLugarTrabajoOld.isPresent()){
            tipoLugarTrabajoNew = tipoLugarTrabajoService.update(tipoEmision);
            return new ResponseEntity<>(tipoLugarTrabajoNew, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id) {
        Optional<TipoLugarTrabajo> tipoEmisionOld = tipoLugarTrabajoService.findById(id);
        if (tipoEmisionOld.isPresent()) {
            tipoLugarTrabajoService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
