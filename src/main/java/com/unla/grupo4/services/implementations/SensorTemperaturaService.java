package com.unla.grupo4.services.implementations;

import java.util.ArrayList;
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

	public Dispositivo findById(int id) {
		// TODO Auto-generated method stub
		return sensorTemperaturaRepository.findById(id);
	}
	public List<SensorTemperatura> comprobar(List<SensorTemperatura> sensores) {
		List<SensorTemperatura> listaActivos = new ArrayList<>();
		for(int i=0;i<sensores.size();i++) {
			if(sensores.get(i).isActivo()) {

				listaActivos.add(sensores.get(i));
			}
		}
		return listaActivos;
		
		
	}

	@Override
	public void insertOrUpdate(SensorTemperatura sensorTemperatura) {
		
		sensorTemperaturaRepository.save(sensorTemperatura);
	}

	
	
	
	

}
















