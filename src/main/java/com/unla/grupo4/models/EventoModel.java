package com.unla.grupo4.models;

import java.time.LocalDateTime;

import com.unla.grupo4.entities.Dispositivo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class EventoModel {
	private int id;
	
	private String descripcion;
	
	private LocalDateTime fechaHora;
	
	private Dispositivo dispositivo;
	
	public EventoModel(int id, String descripcion, LocalDateTime fechaHora, Dispositivo dispositivo) {
		this.setId(id);
		this.descripcion = descripcion;
		this.fechaHora = fechaHora;
		this.dispositivo = dispositivo;
	}
	
	public EventoModel(String descripcion, LocalDateTime fechaHora, Dispositivo dispositivo) {
		this.descripcion = descripcion;
		this.fechaHora = fechaHora;
		this.dispositivo = dispositivo;
	}
	
}