package com.springboot.springwebappapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.springwebappapplication.repositories.AuthorRepository;

@Controller
public class AuthorController {
	public AuthorRepository authorRepository;
	
	public AuthorController(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorRepository.findAll());	
		return "authors";
	}
	
}
