package com.unla.grupo4.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Getter @Setter @NoArgsConstructor
public class SensorBasura extends Dispositivo{

	private boolean lleno;
	
	private int nroDepartamento;
	
	private float distanciaBasura;
	
	public SensorBasura(String nombre, boolean activo,boolean lleno, int nroDepartamento, float distanciaBasura) {
		super(nombre, activo);
		this.lleno = lleno;
		this.nroDepartamento = nroDepartamento;
		this.distanciaBasura = distanciaBasura;
	}
	
	public void reiniciar() {
		this.setLleno(false);
		this.setDistanciaBasura(1);
	}
}
