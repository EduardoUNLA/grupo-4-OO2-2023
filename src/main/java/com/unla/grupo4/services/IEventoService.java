package com.unla.grupo4.services;

import java.time.LocalDateTime;
import java.util.List;

import com.unla.grupo4.entities.Evento;
import com.unla.grupo4.models.EventoModel;

public interface IEventoService {
	
	public List<Evento> getAll();
	public Evento getdById(int id);
	
	public List<Evento> getByIdDispositivo(int id);
	
	public EventoModel insertOrUpdate(EventoModel eventoModel);
	
	public List<Evento> getEventosSensorBasura();
	
	public boolean remove(int id);
	
	public List<Evento> getByNombreDispositivo(String dispositivo);
	
	List<Evento> getByFechaHoraBetween(LocalDateTime inicio, LocalDateTime fin);
	
	public List<Evento> getByFiltro(String nombreDispositivo);
	
	public List<Evento> getByDispositivoActivo(boolean estadoDispositivo);
}
