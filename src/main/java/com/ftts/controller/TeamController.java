package com.ftts.controller;

import com.ftts.repository.TeamRepository;
import com.ftts.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    TeamRepository teamRepository;

    @GetMapping(value = "/teams", produces = "application/json")
    public ResponseEntity<List<Team>> getTeams(){
        return new ResponseEntity<>(teamRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/teams/{id}", produces = "application/json")
    public ResponseEntity<Team> getTeamById(@PathVariable("id") Long id){
        return new ResponseEntity<>(teamRepository.getById(id), HttpStatus.OK);
    }

    /*@GetMapping(value = "/teams/{teamName}", produces = "application/json")
    public ResponseEntity<Team> getTeamByTeamName(@PathVariable("teamName") String teamName){
        return new ResponseEntity<>(teamRepository.findTeamByTeamName(teamName), HttpStatus.OK);
    }*/
}
