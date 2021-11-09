package com.qbay.biblioteca.service;

import java.util.List;

import com.qbay.biblioteca.entity.Autor;

public interface AutorService {
	List<Autor> readall();
	Autor create(Autor al);
	Autor read(int id);
	void delete(int id);
	Autor update(Autor al);
}
