package com.irctc.onlinetrainticketbooking.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.irctc.onlinetrainticketbooking.dto.Train;
import com.irctc.onlinetrainticketbooking.repository.TrainRepository;

@Repository
public class TrainDao {

	@Autowired
	private TrainRepository repository;
	
	/*
	 * SaveTrainDetails once the admin logged in
	 * 
	 */
	public Train saveTrain(Train train) {
		
		return repository.save(train);
	}
	
	/*
	 * display all train details
	 */
	public List<Train> getAllTrainDetails(){
		return repository.findAll();
	}
}
