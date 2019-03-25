package com.ftts.controller;

import com.ftts.repository.RaceRepository;
import com.ftts.model.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class RaceController {

    @Autowired
    RaceRepository raceRepository;

    @GetMapping(value = "/races", produces = "application/json")
    public ResponseEntity<List<Race>> getRaces(){
        return new ResponseEntity<>(raceRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/races/{id}", produces = "application/json")
    public ResponseEntity<Race> getRaceByID(@PathVariable("id") int id){
        return new ResponseEntity<>(raceRepository.getById((long) id), HttpStatus.OK);
    }

    @PostMapping(value = "/new-race", consumes = "application/json", produces = "application/json")
    public void saveNewRace(@RequestBody Race race){
        raceRepository.save(race);
    }

}
