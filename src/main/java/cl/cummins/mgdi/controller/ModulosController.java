package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.Modulos;
import cl.cummins.mgdi.exeption.service.ModulosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/modulos")
public class ModulosController {

    @Autowired
    private ModulosService modulosService;

    @GetMapping
    public ResponseEntity<List<Modulos>> findAll(){
        List<Modulos> moduloss = modulosService.findAll();
        return new ResponseEntity<>(moduloss, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modulos> findById(@PathVariable("id") Long id){
        Optional<Modulos> modulosOptional = modulosService.findById(id);
        Modulos modulos = null;

        if (modulosOptional.isPresent()){
            modulos = modulosOptional.get();
            return new ResponseEntity<>(modulos, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Modulos> create(@Valid @RequestBody Modulos modulos){
        Modulos modulosNew = modulosService.create(modulos);
        return new ResponseEntity<>(modulosNew, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Modulos> update(@Valid @RequestBody Modulos modulos){
        Optional<Modulos> modulosOld = modulosService.findById(modulos.getId());
        Modulos modulosNew = null;
        if (modulosOld.isPresent()){
            modulosNew = modulosService.update(modulos);
            return new ResponseEntity<>(modulosNew, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id) {
        Optional<Modulos> modulosOld = modulosService.findById(id);
        if (modulosOld.isPresent()) {
            modulosService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
