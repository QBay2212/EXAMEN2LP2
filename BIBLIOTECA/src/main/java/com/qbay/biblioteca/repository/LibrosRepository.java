package com.qbay.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qbay.biblioteca.entity.Libros;

@Repository
public interface LibrosRepository extends JpaRepository<Libros, Integer> {

}
