package com.unla.grupo4.services;

import java.util.List;

import com.unla.grupo4.entities.Dispositivo;
import com.unla.grupo4.models.DispositivoModel;

public interface IDispositivoService {

	public List<Dispositivo> getAll();
	
	public Dispositivo findById(int id);
	
	Dispositivo getById(int id);
	
	public boolean remove(int id);
	
	public List<Dispositivo> findByNombre(String nombre);
	
	public List<Dispositivo> findByActivo(boolean activo);
	
	public DispositivoModel insertOrUpdate(Dispositivo dispositivo);

}
