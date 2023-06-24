package com.unla.grupo4.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class SensorLuces extends Dispositivo{
	
	private float nivelLuz;
	
	private boolean encendido;
}
