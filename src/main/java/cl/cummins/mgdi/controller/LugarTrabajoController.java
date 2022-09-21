package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.LugarTrabajo;
import cl.cummins.mgdi.exeption.service.LugarTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lugartrabajo")
public class LugarTrabajoController {

    @Autowired
    private LugarTrabajoService lugarTrabajoService;

    @GetMapping
    public ResponseEntity<List<LugarTrabajo>> findAll(){
        List<LugarTrabajo> lugarTrabajos = lugarTrabajoService.findAll();
        return new ResponseEntity<>(lugarTrabajos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LugarTrabajo> findById(@PathVariable("id") Long id){
        Optional<LugarTrabajo> lugarTrabajoOptional = lugarTrabajoService.findById(id);
        LugarTrabajo lugarTrabajo = null;

        if (lugarTrabajoOptional.isPresent()){
            lugarTrabajo = lugarTrabajoOptional.get();
            return new ResponseEntity<>(lugarTrabajo, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<LugarTrabajo> create(@Valid @RequestBody LugarTrabajo lugarTrabajo){
        LugarTrabajo lugarTrabajoNew = lugarTrabajoService.create(lugarTrabajo);
        return new ResponseEntity<>(lugarTrabajoNew, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<LugarTrabajo> update(@Valid @RequestBody LugarTrabajo lugarTrabajo){
        Optional<LugarTrabajo> lugarTrabajoOld = lugarTrabajoService.findById(lugarTrabajo.getId());
        LugarTrabajo lugarTrabajoNew = null;
        if (lugarTrabajoOld.isPresent()){
            lugarTrabajoNew = lugarTrabajoService.update(lugarTrabajo);
            return new ResponseEntity<>(lugarTrabajoNew, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id) {
        Optional<LugarTrabajo> lugarTrabajoOld = lugarTrabajoService.findById(id);
        if (lugarTrabajoOld.isPresent()) {
            lugarTrabajoService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
