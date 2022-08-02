package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.Equipo;
import cl.cummins.mgdi.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/equipo")
public class VersionMotorController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping
    public ResponseEntity<List<Equipo>> findAll(){
        List<Equipo> equipos = equipoService.findAll();
        return new ResponseEntity<>(equipos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> findById(@PathVariable("id") Long id){
        Optional<Equipo> equipoOptional = equipoService.findById(id);
        Equipo equipo = null;

        if (equipoOptional.isPresent()){
            equipo = equipoOptional.get();
            return new ResponseEntity<>(equipo, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Equipo> create(@Valid @RequestBody Equipo equipo){
        Equipo equipoNew = equipoService.create(equipo);
        return new ResponseEntity<>(equipoNew, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Equipo> update(@Valid @RequestBody Equipo equipo){
        Optional<Equipo> equipoOld = equipoService.findById(equipo.getId());
        Equipo equipoNew = null;
        if (equipoOld.isPresent()){
            equipoNew = equipoService.update(equipo);
            return new ResponseEntity<>(equipoNew, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id) {
        Optional<Equipo> equipoOld = equipoService.findById(id);
        if (equipoOld.isPresent()) {
            equipoService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
