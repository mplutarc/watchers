package org.example.watchers.controller;

import lombok.val;
import org.example.watchers.entity.Films;
import org.example.watchers.repository.FilmsRepository;
import org.example.watchers.repository.SerialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private FilmsRepository filmsRepository;

    @Autowired
    private SerialsRepository serialsRepository;

    @GetMapping("/getAll")
    public List<Films> getAll() {
        return filmsRepository.findAll();
    }
}
