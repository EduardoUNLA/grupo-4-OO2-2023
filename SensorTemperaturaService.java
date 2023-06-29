package com.unla.grupo4.services.implementations;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo4.entities.Dispositivo;
import com.unla.grupo4.entities.SensorTemperatura;
import com.unla.grupo4.models.SensorTemperaturaModel;
import com.unla.grupo4.repositories.ISensorTemperaturaRepository;
import com.unla.grupo4.services.ISensorTemperaturaService;


@Service("sensorTemperaturaService")
public class SensorTemperaturaService implements ISensorTemperaturaService{

	@Autowired
	@Qualifier("sensorTemperaturaRepository")
	private ISensorTemperaturaRepository sensorTemperaturaRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<SensorTemperatura> getAll() {
		
		return sensorTemperaturaRepository.findAll();
	}

	@Override
	public SensorTemperaturaModel insertOrUpdate(SensorTemperaturaModel sTempModel) {
		SensorTemperatura nvoSensorT = sensorTemperaturaRepository.save(modelMapper.map(sTempModel, SensorTemperatura.class));
		return modelMapper.map(nvoSensorT, SensorTemperaturaModel.class);
	}
	
	@Override
	public boolean remove(int id) {
		
		try {
			sensorTemperaturaRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public Dispositivo findById(int id) {
		
		return sensorTemperaturaRepository.findById(id);
	}
	
	

}
















