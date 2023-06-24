package com.unla.grupo4.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unla.grupo4.entities.SensorTemperatura;

@Repository("sensorTemperaturaRepository")
public interface ISensorTemperaturaRepository extends JpaRepository<SensorTemperatura, Serializable>{
	
	public abstract SensorTemperatura findById(int id);
	public abstract SensorTemperatura findByNombre(String nombre);

}
	



	