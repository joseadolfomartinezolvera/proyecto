package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceService.IprofesorService;
import com.example.demo.interfaces.IProfesor;
import com.example.demo.modelo.Profesor;

@Service
public class ProfesorService implements IprofesorService {

	@Autowired
	private IProfesor data;
	
	
	@Override 
	public List<Profesor> listar() {
		return (List<Profesor>)data.findAll();
	}

	@Override
	public Optional<Profesor> listarID(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Profesor p) {
		int res=0;
		Profesor profesor=data.save(p);
		if(!profesor.equals(null)) {
			res=1;
		}
		return 0;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
	}

}
