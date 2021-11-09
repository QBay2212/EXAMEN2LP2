package com.qbay.biblioteca.service;

import java.util.List;

import com.qbay.biblioteca.entity.Libros;

public interface LibrosService {
	List<Libros> readall();
	Libros create(Libros al);
	Libros read(int id);
	void delete(int id);
	Libros update(Libros al);
}
