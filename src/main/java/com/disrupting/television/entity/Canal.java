package com.disrupting.television.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Canal {

	@Id
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	public Canal() {
		// TODO Auto-generated constructor stub
	}

	public Canal(Integer id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
