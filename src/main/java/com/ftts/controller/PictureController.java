package com.ftts.controller;

import com.ftts.model.Picture;
import com.ftts.model.Tag;
import com.ftts.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pictures")
public class PictureController {

    @Autowired
    PictureRepository pictureRepository;

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Picture>> getAllPictures(){
        return new ResponseEntity<>(pictureRepository.findAll(), HttpStatus.OK);
    }

  /*  @GetMapping(value = "pictures/{tag}", produces = "application/json")
    public  ResponseEntity<List<Picture>> getPicturesByTag(@PathVariable("tag")Tag tag){
        return new ResponseEntity<>(pictureRepository.getPicturesByTag(tag), HttpStatus.OK);
    } */

    @PostMapping(value = "/upload", consumes = "application/json", produces = "application/json")
    public void savePicture(@RequestBody Picture picture){
        pictureRepository.save(picture);
    }
}
