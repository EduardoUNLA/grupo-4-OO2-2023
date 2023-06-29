package com.unla.grupo4.services.implementations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo4.entities.Evento;
import com.unla.grupo4.entities.SensorBasura;
import com.unla.grupo4.models.EventoModel;
import com.unla.grupo4.repositories.IEventoRepository;
import com.unla.grupo4.services.IEventoService;

@Service("eventoService")
public class EventoService implements IEventoService {

	@Autowired
	@Qualifier("eventoRepository")
	private IEventoRepository eventoRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public List<Evento> getAll() {
		return eventoRepository.findAll();
	}


	@Override
	public EventoModel insertOrUpdate(EventoModel eventoModel) {
		Evento evento = eventoRepository.save(modelMapper.map(eventoModel, Evento.class));
		return modelMapper.map(evento,  EventoModel.class);
	}

	@Override
	public boolean remove(int id) {
		try {
			eventoRepository.deleteById(id);
			return true;
		}catch(Exception e) {
		return false;
		}
	}

	@Override
	public Evento getdById(int id) {
		return eventoRepository.findById(id);
	}


	@Override
	public List<Evento> getByIdDispositivo(int id) {
		return eventoRepository.findByIdDispositivo(id);
	}


	@Override
	public List<Evento> getEventosSensorBasura() {
		List<Evento> eventos = eventoRepository.findAll();
		List<Evento> eventosSensorBasura = new ArrayList<>();
		for(int i=0; i<eventos.size();i++) {
			if(eventos.get(i).getDispositivo() instanceof SensorBasura) {
				eventosSensorBasura.add(eventos.get(i));
			}
		}
		return eventosSensorBasura;
	}
	
	public List<Evento> getByNombreDispositivo(String nombre){
		if(nombre != null)
			return eventoRepository.findByNombreDispositivo(nombre);
		else return null;
	}


	@Override
	public List<Evento> getByFiltro(String nombreDispositivo) {
			return eventoRepository.findByNombreDispositivo(nombreDispositivo);
	}
	
	@Override
	public List<Evento> getByFechaHoraBetween(LocalDateTime inicio, LocalDateTime fin){
		return eventoRepository.findByFechaHoraBetween(inicio, fin);
	}


	@Override
	public List<Evento> getByDispositivoActivo(boolean estadoDispositivo) {
		return eventoRepository.findByEstadoDispositivo(estadoDispositivo);
	}

}