package com.unla.grupo4.services;

import java.util.List;

import com.unla.grupo4.entities.Evento;

public interface IEventoService {
	
	public List<Evento> getAll();
	
	public Evento findById(int id);
	
	public Evento insertOrUpdate(Evento evento);
	
	public boolean remove(int id);
}
