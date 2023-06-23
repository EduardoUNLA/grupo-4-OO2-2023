package com.unla.grupo4.services;


import java.util.List;

import com.unla.grupo4.entities.Evento;
import com.unla.grupo4.models.EventoModel;

public interface IEventoService {
	
	public List<Evento> getAll();
	public Evento findBy(int id);
	
	public List<Evento> getByIdDispositivo(int id);
	
	public EventoModel insertOrUpdate(EventoModel eventoModel);
	
	public List<Evento> getEventosSensorBasura();
	
	public boolean remove(int id);
}
