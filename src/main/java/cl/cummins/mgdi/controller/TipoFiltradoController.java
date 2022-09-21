package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.TipoFiltrado;
import cl.cummins.mgdi.exeption.service.TipoFiltradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipofiltrado")
public class TipoFiltradoController {

    @Autowired
    private TipoFiltradoService tipoFiltradoService;

    @GetMapping
    public ResponseEntity<List<TipoFiltrado>> findAll(){
        List<TipoFiltrado> tipoFiltrados = tipoFiltradoService.findAll();
        return new ResponseEntity<>(tipoFiltrados, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoFiltrado> findById(@PathVariable("id") Long id){
        Optional<TipoFiltrado> tipoFiltradoOptional = tipoFiltradoService.findById(id);
        TipoFiltrado tipoFiltrado = null;

        if (tipoFiltradoOptional.isPresent()){
            tipoFiltrado = tipoFiltradoOptional.get();
            return new ResponseEntity<>(tipoFiltrado, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TipoFiltrado> create(@Valid @RequestBody TipoFiltrado tipoFiltrado){
        TipoFiltrado tipoFiltradoNew = tipoFiltradoService.create(tipoFiltrado);
        return new ResponseEntity<>(tipoFiltradoNew, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TipoFiltrado> update(@Valid @RequestBody TipoFiltrado tipoFiltrado){
        Optional<TipoFiltrado> tipoFiltradoOld = tipoFiltradoService.findById(tipoFiltrado.getId());
        TipoFiltrado tipoFiltradoNew = null;
        if (tipoFiltradoOld.isPresent()){
            tipoFiltradoNew = tipoFiltradoService.update(tipoFiltrado);
            return new ResponseEntity<>(tipoFiltradoNew, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id) {
        Optional<TipoFiltrado> tipoFiltradoOld = tipoFiltradoService.findById(id);
        if (tipoFiltradoOld.isPresent()) {
            tipoFiltradoService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
