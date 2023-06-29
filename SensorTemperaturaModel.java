package com.unla.grupo4.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class SensorTemperaturaModel extends DispositivoModel{
	
	
	private float temperatura;
	private boolean aire;
	private boolean calefaccion;
	public SensorTemperaturaModel(int id, String nombre, boolean activo,float temperatura,
			boolean aire,boolean calefaccion) {
		super(id,nombre,activo);
		this.temperatura = temperatura;
		this.aire = aire;
		this.calefaccion = calefaccion;
	}
	
	

}
