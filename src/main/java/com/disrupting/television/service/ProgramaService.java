package com.disrupting.television.service;

import java.util.List;

import com.disrupting.television.dto.ProgramaDTO;

public interface ProgramaService {

	public boolean agregarPrograma(String programa);
	public List<ProgramaDTO> obtenerProgramas();
	public boolean modificarPrograma(String programa);
	public boolean eliminarPrograma(String programa);
	
}
