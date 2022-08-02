package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.VersionEquipo;
import cl.cummins.mgdi.service.VersionEquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/versionequipo")
public class VersionEquipoController {

    @Autowired
    private VersionEquipoService versionEquipoService;

    @GetMapping
    public ResponseEntity<List<VersionEquipo>> findAll(){
        List<VersionEquipo> versionEquipos = versionEquipoService.findAll();
        return new ResponseEntity<>(versionEquipos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VersionEquipo> findById(@PathVariable("id") Long id){
        Optional<VersionEquipo> versionEquipoOptional = versionEquipoService.findById(id);
        VersionEquipo versionEquipo = null;

        if (versionEquipoOptional.isPresent()){
            versionEquipo = versionEquipoOptional.get();
            return new ResponseEntity<>(versionEquipo, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<VersionEquipo> create(@Valid @RequestBody VersionEquipo versionEquipo){
        VersionEquipo versionEquipoNew = versionEquipoService.create(versionEquipo);
        return new ResponseEntity<>(versionEquipoNew, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<VersionEquipo> update(@Valid @RequestBody VersionEquipo versionEquipo){
        Optional<VersionEquipo> versionEquipoOld = versionEquipoService.findById(versionEquipo.id);
        VersionEquipo versionEquipoNew = null;
        if (versionEquipoOld.isPresent()){
            versionEquipoNew = versionEquipoService.update(versionEquipo);
            return new ResponseEntity<>(versionEquipoNew, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id) {
        Optional<VersionEquipo> versionEquipoOld = versionEquipoService.findById(id);
        if (versionEquipoOld.isPresent()) {
            versionEquipoService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
