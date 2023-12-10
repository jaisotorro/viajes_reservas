package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.model.Hotel;
import com.model.Reserva;
import com.repository.ReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaService {
	
	@Autowired
	ReservaRepository reservaRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	String urlHotel = "http://viajes-hoteles/viajes/hotel/"; 
	String urlVuelo = "http://viajes-vuelos/viajes/vuelo/{id}/{plazas}";
	
	@Override
	public void saveReserva(Reserva reserva) {
		reservaRepository.save(reserva);
		restTemplate.put(urlVuelo, null, reserva.getIdVuelo(), reserva.getPlazas());
	}

	@Override
	public List<Reserva> findByNombreHotel(String nombreHotel) {
		return reservaRepository.findByIdHotel(restTemplate.getForObject(urlHotel + nombreHotel, Hotel.class).getIdHotel());
	}

}
