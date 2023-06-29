package com.unla.grupo4.entities;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Dispositivo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	private boolean activo;
	
	@OneToMany(mappedBy = "dispositivo",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Evento> eventos = new ArrayList<>();
	
	public Dispositivo(int id, String nombre, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.activo = true;
	}
	
	public Dispositivo(String nombre, boolean activo) {
		super();
		this.nombre = nombre;
		this.activo = true;
	}	
}