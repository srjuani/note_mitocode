package com.hampcode.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hampcode.model.PrecioVenta;
import com.hampcode.repository.PrecioVentaRepository;
import com.hampcode.service.PrecioVentaService;
import com.hampcode.util.Formatos;

@Service
public class PrecioVentaServiceImpl implements PrecioVentaService{
	
	@Autowired
	private PrecioVentaRepository precioVentaRepository;

	@Transactional
	@Override
	public PrecioVenta insertOrUpdate(PrecioVenta entity) {
		entity.setPrecio(calcularPrecioVenta(entity));
		return precioVentaRepository.save(entity);
	}

	@Override
	public Optional<PrecioVenta> getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PrecioVenta> getAll() {
		return precioVentaRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	
	private double calcularPrecioVenta(PrecioVenta precioVenta) {

		double resultadoPrecioVenta;
		double resultadoManoObra;
		double resultadoGastoFabricacion;
		double resultadoCostoProduccion;

		if (precioVenta.getClave() == 3 || precioVenta.getClave() == 4) {
			resultadoManoObra = precioVenta.getCostoMateriaPrima() * 0.75;
		} else if (precioVenta.getClave() == 1 || precioVenta.getClave() == 5) {
			resultadoManoObra = precioVenta.getCostoMateriaPrima() * 0.80;
		} else {
			resultadoManoObra = precioVenta.getCostoMateriaPrima() * 0.85;
		}

		if (precioVenta.getClave() == 2 || precioVenta.getClave() == 5) {
			resultadoGastoFabricacion = precioVenta.getCostoMateriaPrima() * 0.30;
		} else if (precioVenta.getClave() == 3 || precioVenta.getClave() == 6) {
			resultadoGastoFabricacion = precioVenta.getCostoMateriaPrima() * 0.35;
		} else {
			resultadoGastoFabricacion = precioVenta.getCostoMateriaPrima() * 0.28;
		}

		resultadoCostoProduccion = precioVenta.getCostoMateriaPrima() + resultadoManoObra + resultadoGastoFabricacion;
		resultadoPrecioVenta = resultadoCostoProduccion + resultadoCostoProduccion * 0.45;

		return Formatos.formatearDecimales(resultadoPrecioVenta, 2);
	}
	
	

}
