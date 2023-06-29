package com.unla.grupo4.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
@NoArgsConstructor
public class SensorLuces extends Dispositivo {

	private int pasillo;
	private float nivelLuz;
	private boolean encendido;
	private boolean gente;

	public SensorLuces(int id, String nombre, boolean activo, int pasillo, float nivelLuz, boolean encendido,
			boolean gente) {
		super(id, nombre, activo);
		this.pasillo = pasillo;
		this.nivelLuz = nivelLuz;
		this.encendido = encendido;
		this.gente = gente;
	}

	public void Apagar() {
		this.setEncendido(false);
	}

}
