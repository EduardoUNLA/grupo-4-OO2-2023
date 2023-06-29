package com.unla.grupo4.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo4.entities.Dispositivo;
import com.unla.grupo4.entities.SensorLuces;
import com.unla.grupo4.models.SensorLucesModel;
import com.unla.grupo4.repositories.ISensorLucesRepository;
import com.unla.grupo4.services.ISensorLucesService;

@Service("sensorLucesService")
public class SensorLucesService implements ISensorLucesService {

	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	@Qualifier("sensorLucesRepository")
	private ISensorLucesRepository sensorLucesRepository;

	@Override
	public List<SensorLuces> getAll() {
		return sensorLucesRepository.findAll();
	}

	@Override
	public SensorLucesModel insertOrUpdate(SensorLuces sensorLuces) {
		SensorLuces sensorLucesNew = sensorLucesRepository.save(sensorLuces);
		return modelMapper.map(sensorLucesNew, SensorLucesModel.class);
	}

	@Override
	public Dispositivo findById(int id) {
		return sensorLucesRepository.findById(id);
	}

	@Override
	public boolean remove(int id) {
		try {
			sensorLucesRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<SensorLuces> findByActivo(boolean activo) {
		return sensorLucesRepository.findByActivo(activo);
	}

	@Override
	public List<SensorLuces> findByEncendido(boolean encendido) {
		return sensorLucesRepository.findByEncendido(encendido);
	}

	public List<SensorLuces> comprobar(List<SensorLuces> sensores) {
		List<SensorLuces> comprobados = new ArrayList<>();
		for (int i = 0; i < sensores.size(); i++) {
			if (sensores.get(i).isGente() == true) {
				sensores.get(i).setEncendido(true);
				comprobados.add(sensores.get(i));
			}
		}
		return comprobados;
	}

	@Override
	public List<SensorLuces> findByGente(boolean gente) {
		return sensorLucesRepository.findByGente(gente);
	}
}
