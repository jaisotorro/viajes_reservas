package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Reserva;
import com.service.ReservaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin("*")
@Tag(name="Servicio de reservas", description="Servicio de consulta y creacion de reservas")
public class ReservaController {
	@Autowired
	ReservaService reservaService;
	
	@PostMapping(value="/reserva", consumes=MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary="Guarda una reserva", description="Guarda la reserva recibida en el cuerpo de la petición")
	void guardaReserva(@RequestBody Reserva reserva) {
		reservaService.saveReserva(reserva);
	}
	
	@GetMapping("/reservas/{nombreHotel}")
	@Operation(summary="Consulta reservas por hotel", description="Busca y devuelve un listado de reservas realizadas para el hotel recibido")
	List<Reserva> buscaReservasPorNombreHotel(@Parameter(name="nombreHotel", description = "Nombre del hotel cuyas reservas se deben buscar") @PathVariable String nombreHotel){
		return reservaService.findByNombreHotel(nombreHotel);
	}
	
	

}
