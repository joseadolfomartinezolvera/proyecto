package com.example.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Profesor;

@Repository
public interface IProfesor extends CrudRepository<Profesor, Integer> {

}
