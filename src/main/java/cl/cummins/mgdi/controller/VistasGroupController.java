package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.VistasGroup;
import cl.cummins.mgdi.service.VistasGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/vistasgroup")
public class VistasGroupController {
    @Autowired
    private VistasGroupService vistasService;

    @GetMapping
    public ResponseEntity<List<VistasGroup>> findAll(){
        return ResponseEntity.ok(vistasService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VistasGroup> findById(@PathVariable("id") Long id){
        return vistasService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VistasGroup> create(@Valid @RequestBody VistasGroup vista){
        return new ResponseEntity<>(vistasService.create(vista), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<VistasGroup> update(@Valid @RequestBody VistasGroup vista){
        return vistasService.findById(vista.getId())
                .map( c -> ResponseEntity.ok(vistasService.update(vista)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id){
        return vistasService.findById(id)
                .map( c -> {
                    vistasService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
