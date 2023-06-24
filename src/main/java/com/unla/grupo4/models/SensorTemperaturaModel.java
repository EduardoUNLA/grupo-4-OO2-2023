package com.unla.grupo4.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class SensorTemperaturaModel {
	
	private int id;
	//@Size(min=5,max=40)
	private String nombre;
	//@Size(min=5,max=40)
	private boolean activo;
	//@Size(min=-10,max=50)
	private float temperatura;
	private boolean aire;
	private boolean calefaccion;
	public SensorTemperaturaModel(int id, String nombre, boolean activo,float temperatura,
			boolean aire,boolean calefaccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.activo = activo;
		this.temperatura = temperatura;
		this.aire = aire;
		this.calefaccion = calefaccion;
	}
	
	

}
