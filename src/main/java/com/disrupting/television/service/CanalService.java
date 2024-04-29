package com.disrupting.television.service;

import java.util.List;

import com.disrupting.television.dto.CanalDTO;

public interface CanalService {
	
	public boolean agregarCanal(CanalDTO canalDTO);
	public List<CanalDTO> obtenerCanales();
	public CanalDTO obtenerCanal(CanalDTO canalDTO);
	public boolean modificarCanal(CanalDTO canalDTO);
	public boolean eliminarCanal(CanalDTO canalDTO);
}
