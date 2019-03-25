package com.ftts.controller;

import com.ftts.model.Tag;
import com.ftts.repository.RacerRepository;
import com.ftts.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {

    @Autowired
    TagRepository tagRepository;

    @GetMapping(value = "/tag", produces = "application/json")
    public ResponseEntity<List<Tag>> getTags(){
        return new ResponseEntity<>(tagRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/tag/{tag}", produces = "application/json")
    public ResponseEntity<Tag> getTag(@PathVariable("tag") String tag){
        return new ResponseEntity<>(tagRepository.getByTag(tag), HttpStatus.OK);
    }

    @PostMapping(value = "/racers/add-tag", consumes = "application/json", produces = "application/json")
    public void saveTag(@RequestBody Tag tag){
        tagRepository.save(tag);
    }


}
