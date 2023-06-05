package com.irctc.onlinetrainticketbooking.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BookTrain {

	@Id
	private long pnrNumber;
	private String passengerName;
	private int passengerAge;
	private LocalDate journeyDate;
	private String passengerEmail;
	private String source;
	private String destination;
	private int trainNumber;
	private LocalTime departureTime;
	private LocalTime arrivalTime;
	private int seatNumber;
	
}
