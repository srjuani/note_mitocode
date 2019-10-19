package com.hampcode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "precio_ventas")
public class PrecioVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "clave", nullable = false)
	private int clave;
	
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "costo_materia_prima", nullable = false)
	private double costoMateriaPrima;

	@Column(name = "precio", nullable = false)
	private double precio;

	public PrecioVenta() {
		super();
	}

	public PrecioVenta(long id, int clave,String name, double costoMateriaPrima, double precio) {
		super();
		this.id = id;
		this.clave = clave;
		this.name=name;
		this.costoMateriaPrima = costoMateriaPrima;
		this.precio = precio;
	}

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
