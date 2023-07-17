package com.example.demo.model;

import jakarta.validation.constraints.NotNull;

public class Consultas {

	@NotNull
	String fechaInicial;
	@NotNull
	String fechaFinal;

	public String getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	
	
	
	
}
