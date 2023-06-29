package com.unla.grupo4.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SensorLucesModel extends DispositivoModel {

	private int pasillo;
	private float nivelLuz;
	private boolean encendido;
	private boolean gente;

	public SensorLucesModel(int id, String nombre, boolean activo, int pasillo, float nivelLuz, boolean encendido,
			boolean gente) {
		super(id, nombre, activo);
		this.pasillo = pasillo;
		this.nivelLuz = nivelLuz;
		this.encendido = encendido;
		this.gente = gente;
	}

}
