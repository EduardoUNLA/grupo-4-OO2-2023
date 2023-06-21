package com.unla.grupo4.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class DispositivoModel {
	
	private int id;
	
	private String nombre;
	
	private boolean activo;
	
	public DispositivoModel(int id, String nombre, boolean activo) {
		this.setId(id);
		this.nombre = nombre;
		this.activo = activo;
	}
}
