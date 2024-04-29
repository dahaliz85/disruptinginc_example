package com.disrupting.television.dto;

public class CanalDTO {

	private int id;
	private String descripcion;

	public CanalDTO() {
		// TODO Auto-generated constructor stub
	}

	public CanalDTO(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
