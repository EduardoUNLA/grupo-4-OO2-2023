package com.unla.grupo4.services.implementations;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo4.entities.Dispositivo;
import com.unla.grupo4.models.DispositivoModel;
import com.unla.grupo4.repositories.IDispositivoRepository;
import com.unla.grupo4.services.IDispositivoService;

@Service("dispositivoService")
public class DispositivoService implements IDispositivoService{
	
	@Autowired
	@Qualifier("dispositivoRepository")
	private IDispositivoRepository dispositivoRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public List<Dispositivo> getAll() {
		return dispositivoRepository.findAll();
	}

	@Override
	public Dispositivo findById(int id) {
		return dispositivoRepository.findById(id);
	}

	@Override
	public List<Dispositivo> findByNombre(String nombre) {
		return dispositivoRepository.findByNombre(nombre);
	}

	@Override
	public List<Dispositivo> findByActivo(boolean activo) {
		return dispositivoRepository.findByActivo(activo);
	}

	@Override
	public DispositivoModel insertOrUpdate(Dispositivo dispositivo) {
		Dispositivo dispositivoNew = dispositivoRepository.save(dispositivo);
		return modelMapper.map(dispositivoNew, DispositivoModel.class);
	}

	@Override
	public Dispositivo getById(int id) {
		Dispositivo dispositivoNew = dispositivoRepository.findById(id);
		return dispositivoNew;
	}

	@Override
	public boolean remove(int id) {
		try {
			dispositivoRepository.deleteById(id);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

}
