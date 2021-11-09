package com.qbay.biblioteca.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="libros")
public class Libros implements Serializable{
	
	
	private static final long serialVersionUID = -1842395296462336245L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idlibro")
	private int id;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="paginas")
	private int paginas;
	
	@Column(name="descripcion")
	private String descripcion;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="autor_id",referencedColumnName = "idautor")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Autor autor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="editorial_id",referencedColumnName = "ideditorial")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Editorial editorial;
	
	
}