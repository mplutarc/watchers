package org.example.watchers.controller;

import org.example.watchers.entity.Films;
import org.example.watchers.repository.FilmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private FilmsRepository filmsRepository;

    @GetMapping("/getAll")
    public List<Films> getAll() {
        return filmsRepository.findAll();
    }
}
