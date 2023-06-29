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
		setNivelLuz(nivelLuz);
		this.encendido = encendido;
		this.gente = gente;
	}
	
	//Nivel de luz 100 = Mayor luminosidad. Nivel de luz 0 = Mayor oscuridad.
	public void setNivelLuz(float nivelLuz) {
		this.nivelLuz = Math.max(0, Math.min(100, nivelLuz));
	} 
	
	public void setPasillo(int pasillo) {
		this.pasillo = Math.max(-20, Math.min(30, pasillo));
	} 
}
