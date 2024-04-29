package com.disrupting.television.dto;

public class ProgramaDTO{

	private Integer id;
	private String descripcion;
	private String hora;
	private String fecha;
	private String duracion;
	private Integer canal;
	
	public ProgramaDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProgramaDTO(Integer id, String descripcion, String hora, String fecha, String duracion, Integer canal) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.hora = hora;
		this.fecha = fecha;
		this.duracion = duracion;
		this.canal = canal;
	}
	
	public ProgramaDTO(String descripcion, String hora, String fecha, String duracion, Integer canal) {
		super();
		this.descripcion = descripcion;
		this.hora = hora;
		this.fecha = fecha;
		this.duracion = duracion;
		this.canal = canal;
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
