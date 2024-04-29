package com.disrupting.television.converter;

import com.disrupting.television.dto.CanalDTO;
import com.disrupting.television.entity.Canal;

public class CanalConverter {
	
	
	public static Canal fromDtoToEntity(CanalDTO dto) {
		
		Canal entity = new Canal();
		
		entity.setDescripcion(dto.getDescripcion());
		entity.setId(dto.getId());
		
		return entity;
	}
	
	public static CanalDTO fromEntityToDTO(Canal entity) {
		CanalDTO dto = new CanalDTO();
		
		dto.setDescripcion(entity.getDescripcion());
		dto.setId(entity.getId());
	
		return dto; 
	}
	

}
