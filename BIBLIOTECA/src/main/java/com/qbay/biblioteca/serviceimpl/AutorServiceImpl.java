package com.qbay.biblioteca.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qbay.biblioteca.entity.Autor;
import com.qbay.biblioteca.repository.AutorRepository;
import com.qbay.biblioteca.service.AutorService;

@Service
public class AutorServiceImpl implements AutorService {
	@Autowired
	private AutorRepository autorRepository;
	@Override
	public List<Autor> readall() {
		// TODO Auto-generated method stub
		return autorRepository.findAll();
	}

	@Override
	public Autor create(Autor al) {
		// TODO Auto-generated method stub
		return autorRepository.save(al);
	}

	@Override
	public Autor read(int id) {
		// TODO Auto-generated method stub
		return autorRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		autorRepository.deleteById(id);
	}

	@Override
	public Autor update(Autor al) {
		// TODO Auto-generated method stub
		return autorRepository.save(al);
	}

}