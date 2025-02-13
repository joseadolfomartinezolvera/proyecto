package com.example.demo.controlador;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfaceService.IprofesorService;
import com.example.demo.modelo.Profesor;

@Controller
@RequestMapping
public class Controlador {
	@Autowired
	private IprofesorService service;
	
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Profesor> profesores= service.listar();
		model.addAttribute("profesores", profesores);
		return "index";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("profesor", new Profesor());
		return "form";
	}
	
	@PostMapping("/save")
	public String save(@Valid Profesor p, Model model) {
		service.save(p);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Profesor>profesor=service.listarID(id);
		model.addAttribute("profesor", profesor);
		
		return "form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listar";
	}

}
