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

import com.qbay.biblioteca.entity.Autor;
import com.qbay.biblioteca.service.AutorService;

@RestController
@RequestMapping("/api/autor")
public class AutorController {
	@Autowired
	private AutorService autorService;
	@GetMapping("/all")
	public ResponseEntity<List<Autor>> getAutores(){
		try {
			List<Autor> list = new ArrayList<>();
			list = autorService.readall();
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
	public ResponseEntity<Autor> getAutor(@PathVariable("id") int id){
		Autor autor = autorService.read(id);
			if(autor.getId()>0) {
				return new ResponseEntity<>(autor, HttpStatus.OK);
			}else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	@PostMapping("/insert")
	public ResponseEntity<Autor> save(@RequestBody Autor autor){
		try {
			Autor a = new Autor();
			
			a.setNombres(autor.getNombres());
			a.setApellidos(autor.getApellidos());
			Autor al = autorService.create(a);
			return new ResponseEntity<>(al, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Autor> update(@RequestBody Autor autor, @PathVariable("id") int id){
		try {
			Autor a = autorService.read(id);
			if(a.getId()>0) {
				
				
				a.setNombres(autor.getNombres());
				a.setApellidos(autor.getApellidos());
				return new ResponseEntity<>(autorService.create(a),HttpStatus.OK);
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
			autorService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}