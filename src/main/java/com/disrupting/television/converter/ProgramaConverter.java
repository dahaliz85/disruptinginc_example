package com.disrupting.television.converter;

import com.disrupting.television.dto.ProgramaDTO;
import com.disrupting.television.entity.Programa;

public class ProgramaConverter {
	
	public static Programa fromDtoToEntity(ProgramaDTO dto) {
		
		Programa entity = new Programa();
		
		entity.setCanal(dto.getCanal());
		entity.setDuracion(dto.getDuracion());
		entity.setFecha(dto.getFecha());
		entity.setHora(dto.getHora());
		entity.setDescripcion(dto.getDescripcion());
		
		return entity;
	}
	


	public static ProgramaDTO fromEntityToDTO(Programa entity) {
		
		ProgramaDTO dto = new ProgramaDTO();
		
		dto.setCanal(entity.getCanal());
		dto.setDuracion(entity.getDuracion());
		dto.setFecha(entity.getFecha());
		dto.setHora(entity.getHora());
		dto.setDescripcion(entity.getDescripcion());
		dto.setId(entity.getId());
		
		return dto;
		
	}
}
