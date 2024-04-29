package com.disrupting.television.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.disrupting.television.entity.Programa;

@Repository
public interface ProgramaRepository extends JpaRepository<Programa, Integer> {

	@Query(value = "SELECT p FROM Programa p WHERE "
			+ "p.canal = :canal AND p.fecha = :fecha AND p.hora = :hora ")
	public List<Programa> findAllByCanalFechaHora(
			@Param("canal") Integer canal, 
			@Param("fecha") String fecha, 
			@Param("hora") String hora);
	
	@Query(value = "SELECT p FROM Programa p WHERE "
			+ "p.canal = :canal AND p.fecha = :fecha AND "
			+ "p.hora = :hora AND p.duracion = :duracion")
	public Optional<Programa> findByCanalFechaAndHoraAndDuracion(
			@Param("canal") Integer canal, 
			@Param("fecha") String fecha, 
			@Param("hora") String hora,
			@Param("duracion") String duracion);

}
