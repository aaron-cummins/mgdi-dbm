package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.Motor;
import cl.cummins.mgdi.exeption.service.MotorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/motor")
public class MotorController {

    @Autowired
    private MotorService motorService;

    @GetMapping
    public ResponseEntity<List<Motor>> findAll(){
        List<Motor> motors = motorService.findAll();
        return new ResponseEntity<>(motors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Motor> findById(@PathVariable("id") Long id){
        Optional<Motor> motorOptional = motorService.findById(id);
        Motor motor = null;

        if (motorOptional.isPresent()){
            motor = motorOptional.get();
            return new ResponseEntity<>(motor, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Motor> create(@Valid @RequestBody Motor motor){
        Motor motorNew = motorService.create(motor);
        return new ResponseEntity<>(motorNew, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Motor> update(@Valid @RequestBody Motor motor){
        Optional<Motor> motorOld = motorService.findById(motor.getId());
        Motor motorNew = null;
        if (motorOld.isPresent()){
            motorNew = motorService.update(motor);
            return new ResponseEntity<>(motorNew, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id) {
        Optional<Motor> motorOld = motorService.findById(id);
        if (motorOld.isPresent()) {
            motorService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
