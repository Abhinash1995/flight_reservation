package com.abhinash.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhinash.flightreservation.dto.ReservationUpdateRequest;
import com.abhinash.flightreservation.entities.Reservation;
import com.abhinash.flightreservation.repos.ReservationRepository;

@RestController
public class ReservationRestController {

	@Autowired
	ReservationRepository reservationRepositary;

	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		return reservationRepositary.findReservationById(id);
	}

	@RequestMapping("/reservations")
	public Reservation updateReservatin( @RequestBody ReservationUpdateRequest request) {
		Reservation reservation = reservationRepositary.findReservationById(request.getId());
		reservation.setNoOfBags(request.getNoOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		return reservationRepositary.save(reservation);
	}

}
