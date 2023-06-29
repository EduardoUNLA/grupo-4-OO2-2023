package com.unla.grupo4.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class SensorTemperatura extends Dispositivo{
	
	
	private float temperatura;
	private boolean aire;
	private boolean calefaccion;
}

