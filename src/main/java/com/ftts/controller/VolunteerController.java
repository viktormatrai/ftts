package com.ftts.controller;

import com.ftts.model.Volunteer;
import com.ftts.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class VolunteerController {

    @Autowired
    VolunteerRepository volunteerRepository;

    @GetMapping(value = "/volunteers", produces = "application/json")
    public ResponseEntity<List<Volunteer>> getVolunteers(){
        return new ResponseEntity<>(volunteerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/volunteers/{id}", produces = "application/json")
    public ResponseEntity<Volunteer> getVolunteerByName(@PathVariable("id") int id){
        return new ResponseEntity<>(volunteerRepository.getById((long) id), HttpStatus.OK);
    }

    @PostMapping(value = "/volunteers/apply", consumes = "application/json", produces = "application/json")
    public void saveVolunteer(@RequestBody Volunteer volunteer){
        volunteerRepository.save(volunteer);
    }



}
