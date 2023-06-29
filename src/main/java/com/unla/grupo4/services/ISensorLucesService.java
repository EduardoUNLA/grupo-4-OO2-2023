package com.unla.grupo4.services;

import java.util.List;

import com.unla.grupo4.entities.Dispositivo;
import com.unla.grupo4.entities.SensorLuces;
import com.unla.grupo4.models.SensorLucesModel;


public interface ISensorLucesService {

	public SensorLucesModel insertOrUpdate(SensorLuces sensorLuces);
	
	public Dispositivo findById(int id);
	
	public List<SensorLuces> getAll();
	
	public List<SensorLuces> findByGente(boolean gente);
	
	public List<SensorLuces> findByEncendido(boolean encendido);

	public boolean remove(int id);

	public List<SensorLuces> findByActivo(boolean activo);
	
	public List<SensorLuces> comprobar(List<SensorLuces> sensores);
	
}
