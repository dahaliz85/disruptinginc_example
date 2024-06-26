package com.disrupting.television.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.disrupting.television.dto.ProgramaDTO;



public class ProgramaUtil {
	
	private ProgramaUtil() {
	}
	

	
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
		programa = programa.substring(currentIndex).trim();
		String[] datosPrograma = programa.split(" ");
		
		dto.setHora(formatHora(datosPrograma[0]));
		dto.setFecha(datosPrograma[1].substring(0, datosPrograma[1].length()-1));
		
	}
	
	public static String formatHora(String hora) {
		StringBuilder horaFinal = new StringBuilder();
		if(hora.length() == 6) {
			horaFinal.append('0');
		}
		for(int x=0; x < hora.length(); x++) {
			
			char currentChar = hora.charAt(x);
			
			switch(currentChar) {
				case '.':
					horaFinal.append(':');
					break;
				case 'a':
					horaFinal.append(" a. m.");
					break;
				case 'p':
					horaFinal.append(" p. m.");
					break;
				default:
					horaFinal.append(currentChar);
			}
		}

		return horaFinal.toString();
	}

	public static boolean validarFechaHoraBorrado(ProgramaDTO dto) {
		String patternHora = "hh:mm a";
		String patternFecha = "dd/MM/yyyy";
		LocalDate fechaActual = LocalDate.now();
		LocalTime horaActual = LocalTime.now();
		
		
		
		System.out.println(fechaActual.format(DateTimeFormatter.ofPattern(patternFecha)));
		System.out.println(horaActual.format(DateTimeFormatter.ofPattern(patternHora)));
		
		
		
		return true;
	}
	
}
