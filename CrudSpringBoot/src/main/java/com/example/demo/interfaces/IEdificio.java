package com.example.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Edificio;


@Repository
public interface IEdificio  extends CrudRepository<Edificio, Integer> {

}
