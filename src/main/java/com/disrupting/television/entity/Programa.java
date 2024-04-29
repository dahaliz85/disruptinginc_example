package com.disrupting.television.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Programa")
public class Programa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "HORA")
	private String hora;
	
	@Column(name="FECHA")
	private String fecha;
	
	@Column(name="DURACION")
	private String duracion;
	
	@Column(name="CANAL")
	private Integer canal;
	
	
	public Programa() {
		// TODO Auto-generated constructor stub
	}


	public Programa(int id, String descripcion, String hora, String fecha, String duracion, Integer canal) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.hora = hora;
		this.fecha = fecha;
		this.duracion = duracion;
		this.canal = canal;
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


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getDuracion() {
		return duracion;
	}


	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}


	public Integer getCanal() {
		return canal;
	}


	public void setCanal(Integer canal) {
		this.canal = canal;
	}
	
	
	
}
