/**
 * Clase: Pais.java
 *
 * @version: 0.1
 *
 * Fecha de Creación: 27/02/2020
 *
 * Fecha de modificación: 
 *
 * @author: 92531165
 *
 * Copyright: CECAR
 *
 */


package edu.cecar.modelo;

/**
 * Clase que modela los paises a nivel 
 * mundial
 *
 */

public class Pais {

	private String nombre;
	private String capital;
	private String continente;

	public Pais() {

	}

	public Pais(String nombre, String capital, String continente) {
		super();
		this.nombre = nombre;
		this.capital = capital;
		this.continente = continente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}


}


