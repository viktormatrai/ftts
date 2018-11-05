package com.ftts.controller;

import com.ftts.model.Gender;
import com.ftts.repository.RacerRepository;
import com.ftts.model.Racer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RacerController {

    @Autowired
    RacerRepository racerRepository;

    @GetMapping(value = "/racers", produces = "application/json")
    public ResponseEntity<List<Racer>> getRacers(){
        return new ResponseEntity<>(racerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{gender}", produces = "application/json")
    public ResponseEntity<List<Racer>> getRacersByGender(@PathVariable("gender") String gender){
        return new ResponseEntity<>(racerRepository.getAllByGender(Gender.valueOf(gender)), HttpStatus.OK);
    }

    @GetMapping(value = "/racers/{nameOfRacer}", produces = "application/json")
    public ResponseEntity<Racer> getRacerByName(@PathVariable("nameOfRacer") String nameOfRacer){
        return new ResponseEntity<>(racerRepository.getByNameOfRacer(nameOfRacer), HttpStatus.OK);

    }
}
