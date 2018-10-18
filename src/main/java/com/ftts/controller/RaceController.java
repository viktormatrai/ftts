package com.ftts.controller;

import com.ftts.repository.RaceRepository;
import com.ftts.model.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RaceController {

    @Autowired
    RaceRepository raceRepository;

    @GetMapping(value = "/races", produces = "application/json")
    public ResponseEntity<List<Race>> getRaces(){
        return new ResponseEntity<>(raceRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/races/{raceName}", produces = "application/json")
    public ResponseEntity<Race> getRaceByName(@PathVariable("raceName") String raceName){
        return new ResponseEntity<>(raceRepository.getByRaceName(raceName), HttpStatus.OK);
    }

}
