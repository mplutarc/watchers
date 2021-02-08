package org.example.watchers.controller;

import lombok.val;
import org.example.watchers.entity.Films;
import org.example.watchers.entity.Serials;
import org.example.watchers.repository.FilmsRepository;
import org.example.watchers.repository.SerialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class MainController {

    @Autowired
    private FilmsRepository filmsRepository;

    @Autowired
    private SerialsRepository serialsRepository;

    @GetMapping("/")
    public String mainPage(Model model){
        return "main";
    }

    @RequestMapping("/choiceFilm")
    public String getAllFilmGenres(@RequestParam(required = false, defaultValue = "") String genre, Model model) {
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
        return "choiceFilm";
    }
    @RequestMapping("/choiceSerial")
    public String getAllSerialGenres(@RequestParam(required = false, defaultValue = "") String genre, Model model) {
        val serials = serialsRepository.findAll();
        val genres = serials
                .stream()
                .map(Serials::getGenres)
                .filter(Objects::nonNull)
                .flatMap(it -> Stream.of(it.split("; ")))
                .collect(Collectors.toSet());
        model.addAttribute("genres", genres);
        model.addAttribute("serials", serials
                .stream()
                .filter(it -> it.getGenres().contains(genre))
                .collect(Collectors.toList()));
        return "choiceSerial";
    }

    @RequestMapping("/randomFilm")
    public String randomFilm(Model model){
        int rand = new Random().nextInt(filmsRepository.findAll().size());
        val randFilms = filmsRepository.findAll();
        model.addAttribute("randFilms", randFilms
                .stream().filter(it -> it.getNumber().equals(rand+1))
                .collect(Collectors.toList()));
        return "randomFilm";
    }
    @RequestMapping("/randomSerial")
    public String randomSerial(Model model){
        int rand = new Random().nextInt(serialsRepository.findAll().size());
        val randSerials = serialsRepository.findAll();
        model.addAttribute("randSerials", randSerials
                .stream().filter(it -> it.getNumber().equals(rand+1))
                .collect(Collectors.toList()));
        return "randomSerial";
    }
}
