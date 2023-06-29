package com.unla.grupo4.services.implementations;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo4.repositories.ISensorBasuraRepository;
import com.unla.grupo4.entities.Dispositivo;
import com.unla.grupo4.entities.SensorBasura;
import com.unla.grupo4.models.EventoModel;
import com.unla.grupo4.models.SensorBasuraModel;
import com.unla.grupo4.services.IEventoService;
import com.unla.grupo4.services.ISensorBasuraService;

@Service("sensorBasuraService")
public class SensorBasuraService implements ISensorBasuraService{
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	@Qualifier("sensorBasuraRepository")
	private ISensorBasuraRepository sensorBasuraRepository;
	
	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;
	
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
	
	@Override
	public void generarEventos() {
		List<SensorBasura> sensores = sensorBasuraRepository.findByActivo(true);
		for (int i = 0; i < sensores.size(); i++) {
			EventoModel eventoModel = null;
			if (sensores.get(i).isLleno()) {
				sensores.get(i).vaciar();
				eventoModel = new EventoModel("Tacho vaciado", LocalDateTime.now(), sensores.get(i));
			} else {
				if (sensores.get(i).comprobar()) {
					eventoModel = new EventoModel("Tacho lleno, vaciar", LocalDateTime.now(), sensores.get(i));
				}
			}
			if (eventoModel != null) {
				eventoService.insertOrUpdate(eventoModel);
			}
			this.insertOrUpdate(sensores.get(i));
		}
	}
	
	@Override
	public void encenderTodos() {
		List<SensorBasura> sensores = sensorBasuraRepository.findByActivo(false);
		for (int i = 0; i < sensores.size(); i++) {
			sensores.get(i).setActivo(true);
			this.insertOrUpdate(sensores.get(i));
		}
	}
	
	@Override
	public void apagarTodos() {
		List<SensorBasura> sensores = sensorBasuraRepository.findByActivo(true);
		for (int i = 0; i < sensores.size(); i++) {
			sensores.get(i).setActivo(false);
			this.insertOrUpdate(sensores.get(i));
		}
	}
}