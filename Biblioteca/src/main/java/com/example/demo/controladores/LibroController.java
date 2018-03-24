package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Libro;
import com.example.demo.repository.LibroRepository;

@RestController
@RequestMapping(path="/")
public class LibroController {
	
	@Autowired
	private LibroRepository repository;
	
	@GetMapping("/libros")
	public List<Libro> getLibros(){
		return repository.findAll();
	}
	

}
