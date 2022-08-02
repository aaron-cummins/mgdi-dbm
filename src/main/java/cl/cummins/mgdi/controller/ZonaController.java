package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.Zona;
import cl.cummins.mgdi.service.ZonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/zona")
public class ZonaController {

    @Autowired
    private ZonaService zonaService;

    @GetMapping
    public ResponseEntity<List<Zona>> findAll(){
        List<Zona> zonas = zonaService.findAll();
        return new ResponseEntity<>(zonas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zona> findById(@PathVariable("id") Long id){
        Optional<Zona> zonaOptional = zonaService.findById(id);
        Zona zona = null;

        if (zonaOptional.isPresent()){
            zona = zonaOptional.get();
            return new ResponseEntity<>(zona, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Zona> create(@Valid @RequestBody Zona zona){
        Zona zonaNew = zonaService.create(zona);
        return new ResponseEntity<>(zonaNew, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Zona> update(@Valid @RequestBody Zona zona){
        Optional<Zona> zonaOld = zonaService.findById(zona.getId());
        Zona zonaNew = null;
        if (zonaOld.isPresent()){
            zonaNew = zonaService.update(zona);
            return new ResponseEntity<>(zonaNew, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id) {
        Optional<Zona> zonaOld = zonaService.findById(id);
        if (zonaOld.isPresent()) {
            zonaService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
