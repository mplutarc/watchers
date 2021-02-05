package org.example.watchers.controller;

import lombok.val;
import org.example.watchers.entity.Films;
import org.example.watchers.repository.FilmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class MainController {

    @Autowired
    private FilmsRepository filmsRepository;

    @GetMapping("/")
    public String mainPage(Model model){
        return "main";
    }

    @RequestMapping("/choice")
    public String getAllGenres(@RequestParam(required = false, defaultValue = "") String genre, Model model) {
        val films = filmsRepository.findAll();
        val genres = films
                .stream()
                .map(Films::getGenres)
                .filter(Objects::nonNull)
                .flatMap(it -> Stream.of(it.split("; ")))
                .collect(Collectors.toSet());
        model.addAttribute("genres", genres);
        model.addAttribute("films", films
                .stream()
                .filter(it -> it.getGenres().contains(genre))
                .collect(Collectors.toList()));
        return "choice";
    }

}
