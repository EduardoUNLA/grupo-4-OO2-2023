package com.unla.grupo4.repositories;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.grupo4.entities.Dispositivo;
import com.unla.grupo4.entities.Evento;

@Repository("eventoRepository")
public interface IEventoRepository extends JpaRepository<Evento, Serializable> {
	
	@Query("SELECT e FROM Evento e JOIN FETCH e.dispositivo d WHERE d.nombre = :nombre")
	public abstract List<Evento> findByNombreDispositivo(String nombre);

	public abstract Evento findById(int id);
	
	public abstract List<Evento> findByDispositivo(Dispositivo dispositivo);

	@Query("SELECT e FROM Evento e JOIN FETCH e.dispositivo d WHERE d.id = :id")
	public abstract List<Evento> findByIdDispositivo(int id);
	
	@Query("SELECT e FROM Evento e WHERE e.fechaHora = :FechaHora")
	public abstract List<Evento> findByFechaHora(String FechaHora);
	
	public abstract List<Evento> findByFechaHoraBetween(LocalDateTime inicio, LocalDateTime fin);
	
	@Query("SELECT e FROM Evento e JOIN FETCH e.dispositivo d WHERE d.activo = :estadoDispositivo")
	public abstract List<Evento> findByEstadoDispositivo(boolean estadoDispositivo);
	
}
