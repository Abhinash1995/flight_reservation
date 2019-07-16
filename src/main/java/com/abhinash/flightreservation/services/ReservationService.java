package com.abhinash.flightreservation.services;

import com.abhinash.flightreservation.dto.ReservationRequest;
import com.abhinash.flightreservation.entities.Reservation;

public interface ReservationService {

	
	public Reservation bookFlight(ReservationRequest request);
	
}
