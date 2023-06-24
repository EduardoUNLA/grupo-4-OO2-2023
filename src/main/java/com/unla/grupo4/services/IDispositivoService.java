package com.unla.grupo4.services;

import java.util.List;

import com.unla.grupo4.entities.Dispositivo;

public interface IDispositivoService {

	public List<Dispositivo> getAll();
	
	public Dispositivo findById(int id);
	
	public List<Dispositivo> findByNombre(String nombre);
	
	public List<Dispositivo> findByActivo(boolean activo);
	
	public Dispositivo insertOrUpdate(Dispositivo dispositivo);

}
