package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.TipoCombustible;
import cl.cummins.mgdi.service.TipoCombustibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipocombustible")
public class TipoCombustibleController {

    @Autowired
    private TipoCombustibleService tipoCombustibleService;

    @GetMapping
    public ResponseEntity<List<TipoCombustible>> findAll(){
        List<TipoCombustible> tipoCombustibles = tipoCombustibleService.findAll();
        return new ResponseEntity<>(tipoCombustibles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoCombustible> findById(@PathVariable("id") Long id){
        Optional<TipoCombustible> tipoCombustibleOptional = tipoCombustibleService.findById(id);
        TipoCombustible tipoCombustible = null;

        if (tipoCombustibleOptional.isPresent()){
            tipoCombustible = tipoCombustibleOptional.get();
            return new ResponseEntity<>(tipoCombustible, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TipoCombustible> create(@Valid @RequestBody TipoCombustible tipoCombustible){
        TipoCombustible tipoCombustibleNew = tipoCombustibleService.create(tipoCombustible);
        return new ResponseEntity<>(tipoCombustibleNew, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TipoCombustible> update(@Valid @RequestBody TipoCombustible tipoCombustible){
        Optional<TipoCombustible> tipoCombustibleOld = tipoCombustibleService.findById(tipoCombustible.getId());
        TipoCombustible tipoCombustibleNew = null;
        if (tipoCombustibleOld.isPresent()){
            tipoCombustibleNew = tipoCombustibleService.update(tipoCombustible);
            return new ResponseEntity<>(tipoCombustibleNew, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id) {
        Optional<TipoCombustible> tipoCombustibleOld = tipoCombustibleService.findById(id);
        if (tipoCombustibleOld.isPresent()) {
            tipoCombustibleService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
