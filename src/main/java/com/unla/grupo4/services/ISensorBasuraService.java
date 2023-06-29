package com.unla.grupo4.services;

import java.util.List;

import com.unla.grupo4.entities.Dispositivo;
import com.unla.grupo4.entities.SensorBasura;
import com.unla.grupo4.models.SensorBasuraModel;

public interface ISensorBasuraService {
	
	public SensorBasuraModel insertOrUpdate(SensorBasura sensorBasura);
	
	public Dispositivo findById(int id);
	
	public List<SensorBasura> getAll();
	
	public SensorBasura findByNroDepartamento(int nroDepartamento);
	
	public List<SensorBasura> findByLleno(boolean lleno);

	public boolean remove(int id);

	public List<SensorBasura> findByActivo(boolean activo);
	
	public List<SensorBasura> comprobar(List<SensorBasura> sensores);
	
}
