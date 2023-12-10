package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
	@Query("SELECT r FROM Reserva r WHERE r.idHotel = ?1")
	List<Reserva> findByIdHotel(Integer idHotel); 
}
