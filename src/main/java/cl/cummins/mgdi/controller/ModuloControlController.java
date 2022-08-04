package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.ModuloControl;
import cl.cummins.mgdi.service.ModuloControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/modulocontrol")
public class ModuloControlController {

    @Autowired
    private ModuloControlService moduloControlService;

    @GetMapping
    public ResponseEntity<List<ModuloControl>> findAll(){
        List<ModuloControl> moduloControls = moduloControlService.findAll();
        return new ResponseEntity<>(moduloControls, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuloControl> findById(@PathVariable("id") Long id){
        Optional<ModuloControl> moduloControlOptional = moduloControlService.findById(id);
        ModuloControl moduloControl = null;

        if (moduloControlOptional.isPresent()){
            moduloControl = moduloControlOptional.get();
            return new ResponseEntity<>(moduloControl, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ModuloControl> create(@Valid @RequestBody ModuloControl moduloControl){
        ModuloControl moduloControlNew = moduloControlService.create(moduloControl);
        return new ResponseEntity<>(moduloControlNew, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ModuloControl> update(@Valid @RequestBody ModuloControl moduloControl){
        Optional<ModuloControl> moduloControlOld = moduloControlService.findById(moduloControl.getId());
        ModuloControl moduloControlNew = null;
        if (moduloControlOld.isPresent()){
            moduloControlNew = moduloControlService.update(moduloControl);
            return new ResponseEntity<>(moduloControlNew, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id) {
        Optional<ModuloControl> moduloControlOld = moduloControlService.findById(id);
        if (moduloControlOld.isPresent()) {
            moduloControlService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
