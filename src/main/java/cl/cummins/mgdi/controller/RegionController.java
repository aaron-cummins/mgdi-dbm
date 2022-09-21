package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.Region;
import cl.cummins.mgdi.exeption.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping
    public ResponseEntity<List<Region>> findAll(){
        return ResponseEntity.ok(regionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> findById(@PathVariable("id") Long id){
        return regionService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Region> create(@Valid @RequestBody Region region){
        return new ResponseEntity<>(regionService.create(region), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Region> update(@Valid @RequestBody Region region){
        return regionService.findById(region.getId())
                .map( c -> ResponseEntity.ok(regionService.update(region)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id){
        return regionService.findById(id)
                .map( c -> {
                    regionService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
