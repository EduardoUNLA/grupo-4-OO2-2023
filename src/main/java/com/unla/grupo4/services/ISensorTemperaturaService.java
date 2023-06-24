package com.unla.grupo4.services;

import java.util.List;
import com.unla.grupo4.entities.SensorTemperatura;
import com.unla.grupo4.models.SensorTemperaturaModel;

public interface ISensorTemperaturaService {

	public List<SensorTemperatura> getAll();

	public SensorTemperaturaModel insertOrUpdate(SensorTemperaturaModel sTempModel);

	public boolean remove(int id);
	
}
