package com.unla.grupo4.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class SensorBasuraModel extends DispositivoModel{
	
	private boolean lleno;
	
	private int nroDepartamento;
	
	private float distanciaBasura;
	
	public SensorBasuraModel(int id, String nombre, boolean activo, boolean lleno, int nroDepartamento, float distanciaBasura) {
		super(id,nombre,activo);
		this.lleno = lleno;
		this.nroDepartamento = nroDepartamento;
		this.distanciaBasura = distanciaBasura;
	}
}
