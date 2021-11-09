package com.qbay.biblioteca.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qbay.biblioteca.entity.Libros;
import com.qbay.biblioteca.service.LibrosService;

@RestController
@RequestMapping("/api/libros")
public class LibrosController {
	@Autowired
	private LibrosService librosService;
	@GetMapping("/all")
	public ResponseEntity<List<Libros>> getPersona(){
		try {
			List<Libros> list = new ArrayList<>();
			list = librosService.readall();
			if(list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/read/{id}")
	public ResponseEntity<Libros> getLibro(@PathVariable("id") int id){
		Libros libro = librosService.read(id);
			if(libro.getId()>0) {
				return new ResponseEntity<>(libro, HttpStatus.OK);
			}else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	@PostMapping("/insert")
	public ResponseEntity<Libros> save(@RequestBody Libros libro){
		try {
			Libros a = new Libros();
			
			a.setId(libro.getId());
			a.setTitulo(libro.getTitulo());
			a.setDescripcion(libro.getDescripcion());
			a.setPaginas(libro.getPaginas());
			a.setAutor(libro.getAutor());
			a.setEditorial(libro.getEditorial());
			Libros al = librosService.create(a);
			return new ResponseEntity<>(al, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Libros> update(@RequestBody Libros libro, @PathVariable("id") int id){
		try {
			Libros a = librosService.read(id);
			if(a.getId()>0) {
				
				
				a.setTitulo(libro.getTitulo());
				a.setDescripcion(libro.getDescripcion());
				a.setPaginas(libro.getPaginas());
				a.setAutor(libro.getAutor());
				a.setEditorial(libro.getEditorial());
				return new ResponseEntity<>(librosService.create(a),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			librosService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	

}
