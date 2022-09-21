package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.Pais;
import cl.cummins.mgdi.exeption.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pais")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping
    public ResponseEntity<List<Pais>> findAll(){
        List<Pais> paiss = paisService.findAll();
        return new ResponseEntity<>(paiss, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> findById(@PathVariable("id") Long id){
        Optional<Pais> paisOptional = paisService.findById(id);
        Pais pais = null;

        if (paisOptional.isPresent()){
            pais = paisOptional.get();
            return new ResponseEntity<>(pais, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Pais> create(@Valid @RequestBody Pais pais){
        Pais paisNew = paisService.create(pais);
        return new ResponseEntity<>(paisNew, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Pais> update(@Valid @RequestBody Pais pais){
        Optional<Pais> paisOld = paisService.findById(pais.getId());
        Pais paisNew = null;
        if (paisOld.isPresent()){
            paisNew = paisService.update(pais);
            return new ResponseEntity<>(paisNew, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id) {
        Optional<Pais> paisOld = paisService.findById(id);
        if (paisOld.isPresent()) {
            paisService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
