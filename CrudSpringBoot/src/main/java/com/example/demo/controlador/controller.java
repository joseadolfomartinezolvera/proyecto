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

import com.example.demo.interfaceService.IedificioService;
import com.example.demo.modelo.Edificio;
import com.example.demo.modelo.Profesor;


@Controller
@RequestMapping
public class controller {
	
	@Autowired
	private IedificioService service;
	
	@GetMapping("/listar2")
	public String listar(Model model) {
		List<Edificio> edificios= service.listar();
		model.addAttribute("edificios", edificios);
		return "index2";
	}
	
	@GetMapping("/new2")
	public String agregar(Model model) {
		model.addAttribute("edificio", new Edificio());
		return "form2";
	}
	
	
	@PostMapping("/save2")
	public String save(@Valid Edificio e, Model model) {
		service.save(e);
		return "redirect:/listar2";
	}
	
	@GetMapping("/editar2/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Edificio>edificio=service.listarID(id);
		model.addAttribute("edificio", edificio);
		return "form2";
	}
	
	@GetMapping("/eliminar2/{id}")
	public String delete(Model model,@PathVariable int id) {
		service.delete(id);
		return "redirect:/listar2";
	}
}
