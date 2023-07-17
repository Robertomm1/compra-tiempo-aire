package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;


public class Telefono {
	
	@NotNull
	@JsonProperty("paquete")
	private int paquete;
	
	@NotNull
	@JsonProperty("compania")
	private int compania;
	
	@NotNull
	@JsonProperty("telefono")
	private String telefono;
	
	@NotNull
	@JsonProperty("monto")
	private String monto;

	public int getPaquete() {
		return paquete;
	}

	public void setPaquete(int paquete) {
		this.paquete = paquete;
	}

	public int getCompania() {
		return compania;
	}

	public void setCompania(int compania) {
		this.compania = compania;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}
	

}
