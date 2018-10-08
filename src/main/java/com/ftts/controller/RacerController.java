package com.ftts.controller;

import com.ftts.Repository.RacerRepository;
import com.ftts.data.Racer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RacerController {

    @Autowired
    RacerRepository racerRepository;

    @GetMapping(value = "/racers", produces = "application/json")
    public ResponseEntity<List<Racer>> getRacers(){
        return new ResponseEntity<List<Racer>>(racerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/racer/{id}", produces = "application/json")
    public ResponseEntity<Racer> getRacerById(@PathVariable("id") int id){
        return new ResponseEntity<>(racerRepository.getById(id),HttpStatus.OK);
    }
}
