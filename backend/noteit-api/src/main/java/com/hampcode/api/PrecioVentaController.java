package com.hampcode.api;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hampcode.Mapper;
import com.hampcode.api.viewmodel.PrecioVentaViewModel;
import com.hampcode.model.PrecioVenta;
import com.hampcode.service.PrecioVentaService;

@RestController
@RequestMapping("/api/precioventas")
public class PrecioVentaController {
	
	@Autowired
	private PrecioVentaService precioVentaService;
	
	@Autowired
	private Mapper mapper;
	
	@GetMapping
	public List<PrecioVenta> allPrecioVentas() {

		List<PrecioVenta> precioVentas = this.precioVentaService.getAll();
		return precioVentas;
	}

	
	@PostMapping
	public PrecioVenta save(@RequestBody PrecioVentaViewModel precioVentaViewModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationException();
		}

		PrecioVenta precioVenta = this.mapper.convertToPrecioVentaEntity(precioVentaViewModel);

		// save ticketEntity instance to db
		this.precioVentaService.insertOrUpdate(precioVenta);

		return precioVenta;
	}


}
