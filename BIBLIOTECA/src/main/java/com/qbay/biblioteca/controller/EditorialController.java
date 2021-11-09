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

import com.qbay.biblioteca.entity.Editorial;
import com.qbay.biblioteca.service.EditorialService;

@RestController
@RequestMapping("/api/editorial")
public class EditorialController {
	@Autowired
	private EditorialService editorialService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Editorial>> getEditoriales(){
		try {
			List<Editorial> list = new ArrayList<>();
			list = editorialService.readall();
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
	public ResponseEntity<Editorial> getEditorial(@PathVariable("id") int id){
		Editorial editorial = editorialService.read(id);
			if(editorial.getId()>0) {
				return new ResponseEntity<>(editorial, HttpStatus.OK);
			}else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	@PostMapping("/insert")
	public ResponseEntity<Editorial> save(@RequestBody Editorial editorial){
		try {
			Editorial a = new Editorial();
			
			a.setEditorial(editorial.getEditorial());
			Editorial al = editorialService.create(a);
			return new ResponseEntity<>(al, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Editorial> update(@RequestBody Editorial editorial, @PathVariable("id") int id){
		try {
			Editorial a = editorialService.read(id);
			if(a.getId()>0) {
				
				
			 a.setEditorial(editorial.getEditorial());
				return new ResponseEntity<>(editorialService.create(a),HttpStatus.OK);
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
			editorialService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
