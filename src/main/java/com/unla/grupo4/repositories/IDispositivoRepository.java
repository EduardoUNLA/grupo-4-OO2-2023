package com.unla.grupo4.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo4.entities.Dispositivo;

@Repository("dispositivoRepository")
public interface IDispositivoRepository extends JpaRepository<Dispositivo, Serializable> {

	public abstract Dispositivo findById(int id);
	
	public abstract List<Dispositivo> findByNombre(String name);
	
	public abstract List<Dispositivo> findByActivo(boolean activo);
	
}