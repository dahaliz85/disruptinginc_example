package com.disrupting.television.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.disrupting.television.dto.CanalDTO;
import com.disrupting.television.service.CanalService;
import com.disrupting.television.util.Constante;

@RestController
public class CanalController {

	@Autowired
	private CanalService canalService;
	
	@PostMapping("/canal")
	public ResponseEntity<String> agregarPrograma(@RequestBody CanalDTO canalDTO){
		boolean resultado = canalService.agregarCanal(canalDTO);
		
		if(resultado) {
			return new ResponseEntity<>(Constante.CANAL_AGREGADO_OK, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(Constante.CANAL_AGREGADO_ERROR, HttpStatus.OK);
		}
	}
	
	@GetMapping("/canales")
	public List<CanalDTO> obtenerCanales(){
		List<CanalDTO> canales = canalService.obtenerCanales();
		return canales;
	}
	
	@GetMapping("/canal")
	public ResponseEntity<CanalDTO> obtenerCanal(@RequestParam int id){
		
		CanalDTO canalEncontrado = canalService.obtenerCanal(new CanalDTO(id, null));
		if(canalEncontrado != null) {
			return new ResponseEntity<>(canalEncontrado, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
	}
	
	@PutMapping("/canal")
	public ResponseEntity<String> modificarCanal(@RequestBody CanalDTO canalDTO){
		boolean resultado = canalService.modificarCanal(canalDTO);
		if(resultado) {
			return new ResponseEntity<>(Constante.CANAL_MODIFICADO_OK, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(Constante.CANAL_MODIFICADO_ERROR, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/canal")
	public ResponseEntity<String> eliminarCanal(@RequestParam int id){
		boolean resultado = canalService.eliminarCanal(new CanalDTO(id, null));
		if(resultado) {
			return new ResponseEntity<>(Constante.CANAL_ELIMINADO_OK, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(Constante.CANAL_ELIMINADO_ERROR, HttpStatus.OK);
		}
	}
}
