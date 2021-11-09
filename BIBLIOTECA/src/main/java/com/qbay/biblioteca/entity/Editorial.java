package com.qbay.biblioteca.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="editorial")
public class Editorial implements Serializable{
	
	
	private static final long serialVersionUID = -1932395296462336245L;
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ideditorial")
	private int id;
	
	@Column(name="editorial")
	private String editorial;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "editorial")
	private List<Libros> libro;
	
	
}