package com.ftts.controller;

import com.ftts.model.Gender;
import com.ftts.repository.RacerRepository;
import com.ftts.model.Racer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RacerController {

    @Autowired
    RacerRepository racerRepository;

    @GetMapping(value = "/racers", produces = "application/json")
    public ResponseEntity<List<Racer>> getRacers(){
        return new ResponseEntity<>(racerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/gender/{gender}", produces = "application/json")
    public ResponseEntity<List<Racer>> getRacersByGender(@PathVariable("gender") String gender){
        return new ResponseEntity<>(racerRepository.getAllByGender(Gender.valueOf(gender)), HttpStatus.OK);
    }

    @GetMapping(value = "/racers/{id}", produces = "application/json")
    public ResponseEntity<Racer> getRacerById(@PathVariable("id") int id){
        return new ResponseEntity<>(racerRepository.getById((long) id), HttpStatus.OK);
    }

    @PostMapping(value = "/racers/new-racer", consumes = "application/json", produces = "application/json")
    public void saveRacer(@RequestBody Racer racer){
        racerRepository.save(racer);
    }


}
