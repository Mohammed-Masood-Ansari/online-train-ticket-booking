package com.irctc.onlinetrainticketbooking.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.irctc.onlinetrainticketbooking.dao.TrainDao;
import com.irctc.onlinetrainticketbooking.dto.Train;
import com.irctc.onlinetrainticketbooking.response.ResponseStructure;

import jakarta.servlet.http.HttpSession;

@Service
public class TrainService {

	@Autowired
	private TrainDao dao;
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private ResponseStructure<Train> responseStructure;
	
	/*
	 * SaveTrainDetails once the admin logged in
	 * 
	 */
	public ResponseStructure<Train> saveTrain(Train train) {
		
		if(httpSession.getAttribute("password")!=null) {
			train.setDepartureTime(LocalTime.of(11,30));
			train.setArrivalTime(LocalTime.of(8,20));
			Train train1=dao.saveTrain(train);
			
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("train details stored successfully in database....");
			responseStructure.setDescription("train details stored where trainnumber is a primary key and etc...");
			responseStructure.setData(train1);
			return responseStructure;
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMessage("please logged in with admin");
			responseStructure.setDescription("please looged in with admin and then try to add the train details...");
			responseStructure.setData(train);
			return responseStructure;
		}
	}
	
	/*
	 * display all train details
	 */
	public List<Train> getTrainSourceToDestination(String trainSource, String trainDestination){
		
		List<Train> trains =  dao.getAllTrainDetails();
		
		List<Train> filterTrains = new ArrayList<Train>();
		
		for (Train train : trains) {
			
			if((train.getTrainSource().equalsIgnoreCase(trainSource))
					&&(train.getTrainDestination().equalsIgnoreCase(trainDestination))) {
				
				filterTrains.add(train);
			}
		}
		return filterTrains;
	}
	
	
}
