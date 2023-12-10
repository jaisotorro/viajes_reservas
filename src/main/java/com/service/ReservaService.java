package com.service;

import java.util.List;

import com.model.Reserva;

public interface ReservaService {
	void saveReserva (Reserva reserva);
	List<Reserva> findByNombreHotel(String nombreHotel);
}
