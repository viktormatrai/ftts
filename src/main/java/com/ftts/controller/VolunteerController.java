package com.ftts.controller;

import com.ftts.model.Volunteer;
import com.ftts.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VolunteerController {

    @Autowired
    VolunteerRepository volunteerRepository;

    @GetMapping(value = "/volunteers", produces = "application/json")
    public ResponseEntity<List<Volunteer>> getVolunteers(){
        return new ResponseEntity<>(volunteerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/volunteers/{nameOfVolunteer}", produces = "application/json")
    public ResponseEntity<Volunteer> getVolunteerByName(@PathVariable("nameOfVolunteer") String nameOfVolunteer){
        return new ResponseEntity<>(volunteerRepository.getByNameOfVolunteer(nameOfVolunteer), HttpStatus.OK);
    }
}
