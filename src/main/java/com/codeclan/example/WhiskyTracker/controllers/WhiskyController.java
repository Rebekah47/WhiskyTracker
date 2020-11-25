package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {
    @Autowired
    WhiskyRepository whiskyRepository;

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/whiskys")
    public ResponseEntity<List<Whisky>> findWhiskysThatHaveYearQueryString(@RequestParam(name = "year", required = false) Integer year){
        if (year != null) {
            return new ResponseEntity<>(whiskyRepository.findWhiskysByYear(year), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskys/distilleries")
    public ResponseEntity<List<Whisky>> findWhiskysThatHaveAgeAndDistillery(@RequestParam(name ="name")String name, @RequestParam(name = "age") Integer age){
        return new ResponseEntity<>(whiskyRepository.findWhiskysByDistilleryNameAndAge(name, age), HttpStatus.OK);
    }

}
