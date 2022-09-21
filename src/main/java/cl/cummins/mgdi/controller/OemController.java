package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.Oem;
import cl.cummins.mgdi.exeption.service.OemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/oem")
public class OemController {

    @Autowired
    private OemService oemService;

    @GetMapping
    public ResponseEntity<List<Oem>> findAll(){
        List<Oem> oems = oemService.findAll();
        return new ResponseEntity<>(oems, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Oem> findById(@PathVariable("id") Long id){
        Optional<Oem> oemOptional = oemService.findById(id);
        Oem oem = null;

        if (oemOptional.isPresent()){
            oem = oemOptional.get();
            return new ResponseEntity<>(oem, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Oem> create(@Valid @RequestBody Oem oem){
        Oem oemNew = oemService.create(oem);
        return new ResponseEntity<>(oemNew, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Oem> update(@Valid @RequestBody Oem oem){
        Optional<Oem> oemOld = oemService.findById(oem.getId());
        Oem oemNew = null;
        if (oemOld.isPresent()){
            oemNew = oemService.update(oem);
            return new ResponseEntity<>(oemNew, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id) {
        Optional<Oem> oemOld = oemService.findById(id);
        if (oemOld.isPresent()) {
            oemService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
