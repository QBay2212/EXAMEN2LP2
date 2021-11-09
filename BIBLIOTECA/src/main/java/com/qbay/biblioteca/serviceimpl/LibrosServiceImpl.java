package com.qbay.biblioteca.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qbay.biblioteca.entity.Libros;
import com.qbay.biblioteca.repository.LibrosRepository;
import com.qbay.biblioteca.service.LibrosService;

@Service
public class LibrosServiceImpl implements LibrosService {
@Autowired
private LibrosRepository librosRepository;
	@Override
	public List<Libros> readall() {
		// TODO Auto-generated method stub
		return librosRepository.findAll();
	}

	@Override
	public Libros create(Libros al) {
		// TODO Auto-generated method stub
		return librosRepository.save(al);
	}

	@Override
	public Libros read(int id) {
		// TODO Auto-generated method stub
		return librosRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		librosRepository.deleteById(id);
		
	}

	@Override
	public Libros update(Libros al) {
		// TODO Auto-generated method stub
		return librosRepository.save(al);
	}

}
