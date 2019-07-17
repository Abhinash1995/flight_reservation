package com.abhinash.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhinash.flightreservation.entities.Flight;
import com.abhinash.flightreservation.entities.Reservation;
import com.abhinash.flightreservation.entities.User;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	Reservation findReservationById(Long id);

}
