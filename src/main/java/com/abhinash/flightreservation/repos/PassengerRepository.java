package com.abhinash.flightreservation.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.abhinash.flightreservation.entities.Passenger;
import com.abhinash.flightreservation.entities.Reservation;


public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
