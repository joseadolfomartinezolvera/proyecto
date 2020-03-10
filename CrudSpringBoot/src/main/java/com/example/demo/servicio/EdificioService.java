package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceService.IedificioService;
import com.example.demo.interfaces.IEdificio;
import com.example.demo.modelo.Edificio;

@Service
public class EdificioService implements  IedificioService{

	@Autowired
	private IEdificio data;
	@Override
	public List<Edificio> listar() {
		return (List<Edificio>)data.findAll();
	}

	
	
	@Override
	public Optional<Edificio> listarID(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Edificio e) {
		int res=0;
		Edificio edificio =data.save(e);
		if(!edificio.equals(null)) {
			res=1;
		}
		return 0;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
	}

}
