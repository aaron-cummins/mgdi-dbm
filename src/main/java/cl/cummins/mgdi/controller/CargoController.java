package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.Cargo;
import cl.cummins.mgdi.service.Cargo.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping
    public ResponseEntity<List<Cargo>> findAll(){
        return ResponseEntity.ok(cargoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> findById(@PathVariable("id") Long id){
        return cargoService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cargo> create(@Valid @RequestBody Cargo cargo){
        return new ResponseEntity<>(cargoService.create(cargo), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cargo> update(@Valid @RequestBody Cargo cargo){
        return cargoService.findById(cargo.getId())
                .map( c -> ResponseEntity.ok(cargoService.update(cargo)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cargo> delete(@PathVariable("id")Long id){
        return cargoService.findById(id)
                .map( c -> {
                    cargoService.delete(id);
                    return ResponseEntity.ok(c);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
