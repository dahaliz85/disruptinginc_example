package com.disrupting.television.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.disrupting.television.dto.ProgramaDTO;

public class ProgramaUtil {
	
	public static ProgramaDTO obtenerDatosPrograma(String programa) {
		
		ProgramaDTO dto = new ProgramaDTO();
		
		programa = programa.trim();
		String[] datosPrograma = programa.split(",");
		
		dto.setDuracion(datosPrograma[1].trim());
		dto.setCanal(Integer.parseInt(datosPrograma[2].trim()));
		obtenerDescripcionPrograma(programa, dto);
		
		return dto;
	}
	
	public static void obtenerDescripcionPrograma(String programa, ProgramaDTO dto) {
		StringBuilder descripcion = new StringBuilder();
		int currentIndex = 0;
		for(int x = currentIndex; x < programa.length() ; x++ ) {
			char actualChar = programa.charAt(x); 
			if(actualChar == '/') {
				dto.setDescripcion(descripcion.toString().trim());
				currentIndex = x + 1;
				break;
			}
			descripcion.append(actualChar);
		}
		System.out.println(programa.substring(currentIndex));
		programa = programa.substring(currentIndex).trim();
		String[] datosPrograma = programa.split(" ");
		if(datosPrograma[0].contains("am")) {
			
		}else {
			
		}
		dto.setHora(datosPrograma[0]);
		dto.setFecha(datosPrograma[1].substring(0, datosPrograma[1].length()-1));
	}

	public static void validarFechaHoraBorrado(ProgramaDTO dto) {
		String patternHora = "hh:mm a";
		String patternFecha = "dd/MM/yyyy";
		LocalDate fechaActual = LocalDate.now();
		LocalTime horaActual = LocalTime.now();
		
		System.out.println(fechaActual.format(DateTimeFormatter.ofPattern(patternFecha)));
		System.out.println(horaActual.format(DateTimeFormatter.ofPattern(patternHora)));
		
		
		
		
		
		
		
		return ;
		
	}
	
}
