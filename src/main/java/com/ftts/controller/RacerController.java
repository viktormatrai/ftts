package com.ftts.controller;

import com.ftts.model.Gender;
import com.ftts.model.Race;
import com.ftts.repository.RacerRepository;
import com.ftts.model.Racer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
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
        racerRepository.saveAndFlush(racer);
    }

    @PutMapping(value = "racers/{id}", consumes = "application/json")
    public void updateRacer(@RequestBody Racer racer, @PathVariable("id") int id) {
        Racer currentRacer = racerRepository.getById((long) id);

        currentRacer.setFirstName(racer.getFirstName());
        currentRacer.setLastName(racer.getLastName());
        currentRacer.setNickName(racer.getNickName());
        currentRacer.setGender(racer.getGender());
        currentRacer.setTeam(racer.getTeam());
        currentRacer.getPoints();
        currentRacer.getRaceNameList();

        racerRepository.save(racer);
    }
}
