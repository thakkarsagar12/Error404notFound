package com.example.demo.controllers;

import com.example.demo.persistance.models.Sam;
import com.example.demo.persistance.service.SamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@Controller
//@RestController("/sam")
@RestController
@RequestMapping("/sam")
public class SamControllers {

    @Autowired
    private SamService samService;

    @GetMapping("/")
    public List<Sam> samList(){
        return samService.findAll();
    }

    @PostMapping("/")
    public Sam save(@RequestBody Sam sam) {
        return samService.save(sam);
    }

    @DeleteMapping("/{id}")
    public void deleteSam(@RequestParam("id") Long id) {
        samService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Sam> findById(@RequestParam("id") Long id) {
        return samService.findById(id);
    }

}
