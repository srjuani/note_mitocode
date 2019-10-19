package com.hampcode.api.viewmodel;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

//https://docs.oracle.com/cd/E19798-01/821-1841/gircz/index.html
public class PrecioVentaViewModel {

	private long id;

	@Min(1)
	@Max(6)
	private int clave;

	private String name;
	
	private double costoMateriaPrima;

	private double precio;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public double getCostoMateriaPrima() {
		return costoMateriaPrima;
	}

	public void setCostoMateriaPrima(double costoMateriaPrima) {
		this.costoMateriaPrima = costoMateriaPrima;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
