package com.disrupting.television.controller;


import java.util.ArrayList;
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

import com.disrupting.television.dto.ProgramaDTO;
import com.disrupting.television.service.ProgramaService;

@RestController
public class ProgramaController {

	@Autowired
	private ProgramaService programaService;

	@PostMapping(path = "/programa")
	public ResponseEntity<String> agregarPrograma(@RequestParam String programa){
		
		boolean resultado = programaService.agregarPrograma(programa);
		
		if(resultado) {
			return new ResponseEntity<>("El programa fue agregado exitosamente", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("El programa no pudo ser agregado", HttpStatus.OK);
		}
		
		
	}
	
	@GetMapping("/programas")
	public List<ProgramaDTO> obtenerProgramas(){
		List<ProgramaDTO> programas = programaService.obtenerProgramas();
		return programas;
		
	}
	
	@PutMapping("/programa")
	public ResponseEntity<String> modificarPrograma(@RequestParam String programa){
		
		
		boolean resultado = programaService.modificarPrograma(programa);
		
		if(resultado) {
			return new ResponseEntity<>("El programa fue modificado exitosamente", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("El programa no pudo ser modificado", HttpStatus.OK);
		}
	}
	
	
	@DeleteMapping("/programa")
	public ResponseEntity<String> eliminarPrograma(@RequestParam String programa){
		
		boolean resultado = programaService.eliminarPrograma(programa);
		
		if(resultado) {
			return new ResponseEntity<>("El programa fue eliminado exitosamente", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("El programa no pudo ser eliminado", HttpStatus.OK);
		}
		
		
	}
	
	
}
