package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Edificio;


public interface IedificioService {
	public List<Edificio>listar();
	public Optional<Edificio>listarID(int id);
	public int save(Edificio e);
	public void delete(int id);


}
