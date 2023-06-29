package com.unla.grupo4.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo4.entities.Dispositivo;
import com.unla.grupo4.entities.SensorLuces;
import com.unla.grupo4.models.SensorLucesModel;

@Repository("sensorLucesRepository")
public interface ISensorLucesRepository extends JpaRepository<SensorLuces, Serializable>{

	public abstract Dispositivo findById(int id);
	public abstract SensorLuces findByNivelLuz(float nivelLuz);
	public abstract List<SensorLuces> findByActivo(boolean activo);
	public abstract List<SensorLuces> findByGente(boolean gente);
	public abstract List<SensorLuces> findByEncendido(boolean encendido);
	public abstract List<SensorLuces> findAll();
}
