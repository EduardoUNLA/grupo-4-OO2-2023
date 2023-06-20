package com.unla.grupo4.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="evento")
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="fechahora")
	private LocalDateTime fechaHora;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dispositivo_id",nullable=true)
	private Dispositivo dispositivo;
	
	public Evento(int id, String descripcion, LocalDateTime fechaHora) {
		this.id = id;
		this.descripcion = descripcion;
		this.fechaHora = fechaHora;
	}
	
	public Evento(String descripcion, LocalDateTime fechaHora) {
		this.descripcion = descripcion;
		this.fechaHora = fechaHora;
	}
}
