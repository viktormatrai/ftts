package com.ftts.controller;

import com.ftts.repository.TeamRepository;
import com.ftts.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/teams/add-team", consumes = "application/json", produces = "application/json")
    public void saveTeam(@RequestBody Team team){
        teamRepository.save(team);
    }



}
