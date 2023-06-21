package com.unla.grupo4.models;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class EventoModel {
	private int id;
	
	private String descripcion;
	
	private LocalDateTime fechaHora;
	
	public EventoModel(int id, String descripcion, LocalDateTime fechaHora) {
		this.setId(id);
		this.descripcion = descripcion;
		this.fechaHora = fechaHora;
	}
	
}
