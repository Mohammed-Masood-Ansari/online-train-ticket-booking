package com.irctc.onlinetrainticketbooking.dto;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Train {

	@Id
	private int trainNumber;
	private String trainName;
	private String trainSource;
	private String trainDestination;
	private LocalTime departureTime;
	private LocalTime arrivalTime;
	private String saturday;
	private String sunday;
	private String monday;
	private String tuesday;
	private String wednesday;
	private String thursday;
	private String friday;
	
}
