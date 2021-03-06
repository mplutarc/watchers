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
import java.util.SortedSet;
import java.util.TreeSet;
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
	public String getFilm(Model model,
	                      @RequestParam(value = "genre", required = false, defaultValue = "") String genre,
	                      @RequestParam(value = "year", required = false, defaultValue = "") String year)
	{
		val films = filmsRepository.findAll();
		val genresSet = films
				.stream()
				.map(Films::getGenres)
				.filter(Objects::nonNull)
				.flatMap(it -> Stream.of(it.split("; ")))
				.collect(Collectors.toSet());
		SortedSet<String> genres = new TreeSet<>(genresSet);
		model.addAttribute("genres", genres);
		val yearsSet = films
				.stream()
				.map(Films::getYear)
				.filter(Objects::nonNull)
				.collect(Collectors.toSet());
		SortedSet<String> years = new TreeSet<>(yearsSet);
		model.addAttribute("years", years);
		model.addAttribute("films", films
				.stream()
				.filter(it -> it.getGenres().contains(genre))
				.filter(it -> it.getYear().contains(year))
				.collect(Collectors.toList()));
		return "choiceFilm";
	}
	@RequestMapping("/choiceSerial")
	public String getSerial(@RequestParam(value = "genres", required = false, defaultValue = "") String genre,
	                        @RequestParam(value = "years", required = false, defaultValue = "") String year,
	                        Model model) {
		val serials = serialsRepository.findAll();
		val genresSet = serials
				.stream()
				.map(Serials::getGenres)
				.filter(Objects::nonNull)
				.flatMap(it -> Stream.of(it.split("; ")))
				.collect(Collectors.toSet());
		SortedSet<String> genres = new TreeSet<>(genresSet);
		model.addAttribute("genres", genres);
		val yearsSet = serials
				.stream()
				.map(Serials::getYear)
				.filter(Objects::nonNull)
				.collect(Collectors.toSet());
		SortedSet<String> years = new TreeSet<>(yearsSet);
		model.addAttribute("years", years);
		model.addAttribute("serials", serials
				.stream()
				.filter(it -> it.getGenres().contains(genre))
				.filter(it -> it.getYear().contains(year))
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
