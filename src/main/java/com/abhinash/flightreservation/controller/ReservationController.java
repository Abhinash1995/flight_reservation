package com.abhinash.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.abhinash.flightreservation.dto.ReservationRequest;
import com.abhinash.flightreservation.entities.Flight;
import com.abhinash.flightreservation.entities.Reservation;
import com.abhinash.flightreservation.repos.FlightRepository;
import com.abhinash.flightreservation.repos.ReservationRepository;
import com.abhinash.flightreservation.services.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private ReservationService reservationservice;

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		Flight flight = flightRepository.findFlightById(flightId);
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}

	@RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		Reservation reservation = reservationservice.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation Is Completely SuccessFul With Id " + reservation.getId());

		return "reservationConfirmation";
	}

}
