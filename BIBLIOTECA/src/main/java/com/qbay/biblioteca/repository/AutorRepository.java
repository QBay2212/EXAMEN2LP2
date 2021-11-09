package com.qbay.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qbay.biblioteca.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer> {

}
