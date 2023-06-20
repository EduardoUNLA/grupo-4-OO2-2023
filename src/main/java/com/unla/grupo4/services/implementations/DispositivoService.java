package com.unla.grupo4.services.implementations;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo4.entities.Dispositivo;
import com.unla.grupo4.repositories.IDispositivoRepository;
import com.unla.grupo4.services.IDispositivoService;

@Service("dispositivoService")
public class DispositivoService implements IDispositivoService{
	
	@Autowired
	@Qualifier("personRepository")
	private IDispositivoRepository dispositivoRepository;
	
	private ModelMapper modelMapeer = new ModelMapper();
	
	@Override
	public List<Dispositivo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dispositivo findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dispositivo> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dispositivo findByActivo(boolean activo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dispositivo insertOrUpdate(Dispositivo dispositivo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
