package com.abhinash.flightreservation.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhinash.flightreservation.dto.ReservationRequest;
import com.abhinash.flightreservation.entities.Flight;
import com.abhinash.flightreservation.entities.Passenger;
import com.abhinash.flightreservation.entities.Reservation;
import com.abhinash.flightreservation.repos.FlightRepository;
import com.abhinash.flightreservation.repos.PassengerRepository;
import com.abhinash.flightreservation.repos.ReservationRepository;


@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
    private	FlightRepository flightrepositary;

	@Autowired
	private	PassengerRepository passengerRepositary; 
	
	@Autowired
	private ReservationRepository reservationRepositary;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		//make payment if payment fail throw exception
		
		Long flightId = request.getFlightId();
		Flight flight=flightrepositary.findFlightById(flightId);
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
    	Passenger savedPassenger = passengerRepositary.save(passenger);
		
    	Reservation reservation = new Reservation();
    	reservation.setFlight(flight);
    	reservation.setPassenger(savedPassenger);
    	reservation.setCheckedIn(false);
    	
    	Reservation savedReservation =  reservationRepositary.save(reservation);
    	
		return savedReservation;
	}

}
