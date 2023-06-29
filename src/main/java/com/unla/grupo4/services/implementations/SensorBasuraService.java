package com.unla.grupo4.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo4.repositories.ISensorBasuraRepository;
import com.unla.grupo4.entities.Dispositivo;
import com.unla.grupo4.entities.SensorBasura;
import com.unla.grupo4.models.SensorBasuraModel;
import com.unla.grupo4.services.ISensorBasuraService;

@Service("sensorBasuraService")
public class SensorBasuraService implements ISensorBasuraService{
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	@Qualifier("sensorBasuraRepository")
	private ISensorBasuraRepository sensorBasuraRepository;
	
	@Override
	public List<SensorBasura> getAll() {
		return sensorBasuraRepository.findAll();
	}

	@Override
	public SensorBasura findByNroDepartamento(int nroDepartamento) {
		return sensorBasuraRepository.findByNroDepartamento(nroDepartamento);
	}

	@Override
	public SensorBasuraModel insertOrUpdate(SensorBasura sensorBasura) {
		SensorBasura sensorBasuraNew = sensorBasuraRepository.save(sensorBasura);
		return modelMapper.map(sensorBasuraNew, SensorBasuraModel.class);
	}

	@Override
	public Dispositivo findById(int id) {
		return sensorBasuraRepository.findById(id);
	}

	@Override
	public boolean remove(int id) {
		try {
			sensorBasuraRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public List<SensorBasura> findByActivo(boolean activo) {
		return sensorBasuraRepository.findByActivo(activo);
	}

	@Override
	public List<SensorBasura> findByLleno(boolean lleno) {
		return sensorBasuraRepository.findByLleno(lleno);
	}
	
	public List<SensorBasura> comprobar(List<SensorBasura> sensores){
		List<SensorBasura> comprobados = new ArrayList<>();
		for(int i=0;i<sensores.size();i++) {
			if(sensores.get(i).getDistanciaBasura() < 0.1) {
				sensores.get(i).setLleno(true);
				comprobados.add(sensores.get(i));
			}
		}
		return comprobados;
	}
}
