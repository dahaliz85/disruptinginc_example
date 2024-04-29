package com.disrupting.television.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.disrupting.television.converter.ProgramaConverter;
import com.disrupting.television.dto.ProgramaDTO;
import com.disrupting.television.entity.Programa;
import com.disrupting.television.repository.ProgramaRepository;
import com.disrupting.television.service.ProgramaService;
import com.disrupting.television.util.ProgramaUtil;

@Service
public class ProgramaServiceImpl implements ProgramaService {
	
	@Autowired
	private ProgramaRepository programaRepository;

	@Override
	public boolean agregarPrograma(String programa) {
		
		ProgramaDTO dto = ProgramaUtil.obtenerDatosPrograma(programa);
		
		List<Programa> programasExistentes =  programaRepository.findAllByCanalFechaHora(dto.getCanal(), dto.getFecha(), dto.getHora());
		if(programasExistentes == null || programasExistentes.isEmpty()) {
			Programa programaNuevo = programaRepository.save(ProgramaConverter.fromDtoToEntity(dto));
			return  programaNuevo != null;
		}else {
			return false;
		}
	}
	
	@Override
	public List<ProgramaDTO> obtenerProgramas() {

		List<ProgramaDTO> programasDTO = new ArrayList<>();
		for(Programa entity : programaRepository.findAll(Sort.by("fecha").ascending()
				.and(Sort.by("hora").ascending()))) {
			ProgramaDTO dto = ProgramaConverter.fromEntityToDTO(entity);
			programasDTO.add(dto);
		}
		return programasDTO;
	}

	@Override
	public boolean modificarPrograma(String programa) {
		
		ProgramaDTO dto = ProgramaUtil.obtenerDatosPrograma(programa);
		
		Optional<Programa> programaExistente =  programaRepository.findByCanalFechaAndHoraAndDuracion(dto.getCanal(), dto.getFecha(), dto.getHora(), dto.getDuracion());
		if(programaExistente.isEmpty()) {
			
			Programa programaModificado = programaRepository.save(ProgramaConverter.fromDtoToEntity(dto));
			return programaModificado == null;
			
		}else {
			return false;
		}
	}
	
	@Override
	public boolean eliminarPrograma(String programa) throws ParseException {
		
		ProgramaDTO dto = ProgramaUtil.obtenerDatosPrograma(programa);
		
		if(ProgramaUtil.validarFechaHoraBorrado(dto)) {
			programaRepository.delete(ProgramaConverter.fromDtoToEntity(dto));
			Optional<Programa> optPrograma = programaRepository.findByCanalFechaAndHoraAndDuracionAndDescripcion(dto.getCanal(), dto.getFecha(), dto.getHora(), dto.getDuracion(), dto.getDescripcion());
			if(optPrograma.isPresent()) {
				programaRepository.delete(ProgramaConverter.fromDtoToEntity(dto));
				return true;
			}
		}
		return false;
	}
	
}
