package com.unla.grupo4.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo4.entities.Dispositivo;
import com.unla.grupo4.entities.SensorBasura;

@Repository("sensorBasuraRepository")
public interface ISensorBasuraRepository extends JpaRepository<SensorBasura, Serializable>{
		
	public abstract Dispositivo findById(int id);
	public abstract SensorBasura findByNroDepartamento(int nroDepartamento);
	public abstract List<SensorBasura> findByActivo(boolean activo);
	public abstract List<SensorBasura> findByLleno(boolean lleno);
	public abstract List<SensorBasura> findAll();
}