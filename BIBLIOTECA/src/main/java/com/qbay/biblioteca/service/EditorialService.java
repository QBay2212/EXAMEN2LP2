package com.qbay.biblioteca.service;

import java.util.List;

import com.qbay.biblioteca.entity.Editorial;

public interface EditorialService  {
	List<Editorial> readall();
	Editorial create(Editorial al);
	Editorial read(int id);
	void delete(int id);
	Editorial update(Editorial al);
}