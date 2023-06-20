package com.unla.grupo4.services.implementations;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo4.entities.Evento;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Evento findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Evento insertOrUpdate(Evento evento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
