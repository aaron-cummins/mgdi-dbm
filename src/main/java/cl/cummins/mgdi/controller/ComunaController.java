package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.Comuna;
import cl.cummins.mgdi.exeption.service.ComunaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/comuna")
public class ComunaController {

    private static final Logger logger = LoggerFactory.getLogger(ComunaController.class);
    @Autowired
    private ComunaService comunaService;

    @GetMapping
    public ResponseEntity<List<Comuna>> findAll(){
        return ResponseEntity.ok(comunaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comuna> findById(@PathVariable("id") Long id){
        return comunaService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Comuna> create(@Valid @RequestBody Comuna comuna){
        logger.info(comuna.toString());
        return new ResponseEntity<>(comunaService.create(comuna), HttpStatus.CREATED);
    }

    @PutMapping("/save")
    public ResponseEntity<Comuna> update(@Valid @RequestBody Comuna comuna){
        logger.info(comuna.toString());

        return comunaService.findById(comuna.getId())
                .map( c -> ResponseEntity.ok(comunaService.update(comuna)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id){
        return comunaService.findById(id)
                .map( c -> {
                    comunaService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
