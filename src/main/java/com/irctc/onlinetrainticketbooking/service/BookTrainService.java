package com.irctc.onlinetrainticketbooking.service;

import java.time.LocalDate;
import java.util.List;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.irctc.onlinetrainticketbooking.dao.BookTrainDao;
import com.irctc.onlinetrainticketbooking.dto.BookTrain;
import com.irctc.onlinetrainticketbooking.dto.Train;
import com.irctc.onlinetrainticketbooking.response.ResponseStructure;

import jakarta.servlet.http.HttpSession;

@SuppressWarnings("unused")
@Service
public class BookTrainService {

	@Autowired
	private BookTrainDao bookTrainDao;
	
	@Autowired
	private TrainService trainService;
	
	@Autowired
	private ResponseStructure<BookTrain> responseStructure;
	
	
	@Autowired
	private HttpSession httpSession;
	/*
	 *  bookTrainMethod 
	 *
	 */
	
	public ResponseStructure<BookTrain> bookTrain(BookTrain bookTrain,String trainSource,String trainDestination,int trainNumber) {
		
		List<Train> trains = trainService.getTrainSourceToDestination(trainSource, trainDestination);
		
		if(httpSession.getAttribute("userpassword")!=null) {
			
			for (Train train : trains) {
				
				if((train.getTrainSource().equalsIgnoreCase(trainSource))
						
						&&(train.getTrainDestination().equalsIgnoreCase(trainDestination))
						&&(train.getTrainNumber()==trainNumber)) {
					
					long pnr = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
					
					bookTrain.setArrivalTime(train.getArrivalTime());
					bookTrain.setDepartureTime(train.getDepartureTime());
					bookTrain.setDestination(train.getTrainDestination());
					bookTrain.setSource(train.getTrainSource());
					bookTrain.setSeatNumber(345);
					bookTrain.setTrainNumber(train.getTrainNumber());
					bookTrain.setPnrNumber(pnr);
					//bookTrain.setJourneyDate(LocalDate.now());
					
					
					
					BookTrain bookTrain1=bookTrainDao.bookTrain(bookTrain);
					
					if(bookTrain!=null) {
						
						responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
						responseStructure.setMessage("Train-Ticket--Booked--successfully");
						responseStructure.setDescription("train ticket booked please check your mail we send your ticket pdf on your mail");
						responseStructure.setData(bookTrain);
					}else {
						responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
						responseStructure.setMessage("Train-Ticket--Booking---Failed");
						responseStructure.setDescription("train ticket booking failed please check your passed data");
						responseStructure.setData(bookTrain);
					}
					
				}else {
					responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
					responseStructure.setMessage("Train number is not correct....or source and detination are not correct");
					responseStructure.setDescription("please provide correct source and destination....or train is not running on provided source destination");
					responseStructure.setData(bookTrain);
				}
			}
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMessage("Please login with user and then booked the train");
			responseStructure.setDescription("without user logoin you cant book ticket");
			responseStructure.setData(bookTrain);
		}
		return responseStructure;
	}
}
