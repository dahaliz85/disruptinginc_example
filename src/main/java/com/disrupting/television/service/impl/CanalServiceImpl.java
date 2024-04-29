package com.disrupting.television.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disrupting.television.converter.CanalConverter;
import com.disrupting.television.dto.CanalDTO;
import com.disrupting.television.entity.Canal;
import com.disrupting.television.repository.CanalRepository;
import com.disrupting.television.service.CanalService;

@Service
public class CanalServiceImpl implements CanalService {

	
	@Autowired
	CanalRepository canalRepository;
	
	@Override
	public boolean agregarCanal(CanalDTO canalDTO) {
		Canal canal = CanalConverter.fromDtoToEntity(canalDTO);
		Canal nuevoCanal= canalRepository.save(canal);
		if(nuevoCanal != null) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public List<CanalDTO> obtenerCanales() {
		List<CanalDTO> canales = new ArrayList<>();
		for(Canal canal : canalRepository.findAll()) {
			CanalDTO dto = CanalConverter.fromEntityToDTO(canal);
			canales.add(dto);
		}		
		return canales;
	}

	@Override
	public CanalDTO obtenerCanal(CanalDTO canalDTO) {
		Optional<Canal> canalOptional = canalRepository.findById(canalDTO.getId());
		if(canalOptional.isPresent()) {
			return  CanalConverter.fromEntityToDTO(canalOptional.get());
		}else {
			return null;
		}
		
	}

	@Override
	public boolean modificarCanal(CanalDTO canalDTO) {
		Canal canal = CanalConverter.fromDtoToEntity(canalDTO);
		Canal canalModificado = canalRepository.save(canal);
		if(canalModificado != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean eliminarCanal(CanalDTO canalDTO) {
		
		try {
			Canal canal = CanalConverter.fromDtoToEntity(canalDTO);
			canalRepository.delete(canal);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
