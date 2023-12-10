package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {

	@Id
	@Column(name="id_reserva")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReserva;
	@Column(name="nombre_cliente")
	private String nombreCliente;
	private String dni;
	@Column(name="id_hotel")
	private Integer idHotel;
	@Column(name="id_vuelo")
	private Integer idVuelo;
	private Integer plazas;
	
	public Reserva() {
		super();
	}

	public Reserva(Integer idReserva, String nombreCliente, String dni, Integer idHotel, Integer idVuelo,
			Integer plazas) {
		super();
		this.idReserva = idReserva;
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.idHotel = idHotel;
		this.idVuelo = idVuelo;
		this.plazas = plazas;
	}
	
	public Reserva(String nombreCliente, String dni, Integer idHotel, Integer idVuelo, Integer plazas) {
		super();
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.idHotel = idHotel;
		this.idVuelo = idVuelo;
		this.plazas = plazas;
	}

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Integer idHotel) {
		this.idHotel = idHotel;
	}

	public Integer getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(Integer idVuelo) {
		this.idVuelo = idVuelo;
	}

	public Integer getPlazas() {
		return plazas;
	}

	public void setPlazas(Integer plazas) {
		this.plazas = plazas;
	}
	
	

}
