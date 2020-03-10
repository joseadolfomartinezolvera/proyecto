package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Profesor;

public interface IprofesorService {
	public List<Profesor>listar();
	public Optional<Profesor>listarID(int id);
	public int save(Profesor p);
	public void delete(int id);

}
