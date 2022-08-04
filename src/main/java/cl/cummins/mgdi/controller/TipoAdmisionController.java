package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.TipoAdmision;
import cl.cummins.mgdi.service.TipoAdmisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipoadmision")
public class TipoAdmisionController {

    @Autowired
    private TipoAdmisionService tipoAdmisionService;

    @GetMapping
    public ResponseEntity<List<TipoAdmision>> findAll(){
        List<TipoAdmision> tipoAdmisions = tipoAdmisionService.findAll();
        return new ResponseEntity<>(tipoAdmisions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoAdmision> findById(@PathVariable("id") Long id){
        Optional<TipoAdmision> tipoAdmisionOptional = tipoAdmisionService.findById(id);
        TipoAdmision tipoAdmision = null;

        if (tipoAdmisionOptional.isPresent()){
            tipoAdmision = tipoAdmisionOptional.get();
            return new ResponseEntity<>(tipoAdmision, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TipoAdmision> create(@Valid @RequestBody TipoAdmision tipoAdmision){
        TipoAdmision tipoAdmisionNew = tipoAdmisionService.create(tipoAdmision);
        return new ResponseEntity<>(tipoAdmisionNew, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TipoAdmision> update(@Valid @RequestBody TipoAdmision tipoAdmision){
        Optional<TipoAdmision> tipoAdmisionOld = tipoAdmisionService.findById(tipoAdmision.getId());
        TipoAdmision tipoAdmisionNew = null;
        if (tipoAdmisionOld.isPresent()){
            tipoAdmisionNew = tipoAdmisionService.update(tipoAdmision);
            return new ResponseEntity<>(tipoAdmisionNew, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id) {
        Optional<TipoAdmision> tipoAdmisionOld = tipoAdmisionService.findById(id);
        if (tipoAdmisionOld.isPresent()) {
            tipoAdmisionService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
