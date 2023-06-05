package com.irctc.onlinetrainticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.onlinetrainticketbooking.dto.Train;
import com.irctc.onlinetrainticketbooking.response.ResponseStructure;
import com.irctc.onlinetrainticketbooking.service.TrainService;

@RequestMapping("/train")
@RestController
public class TrainController {

	@Autowired
	private TrainService service;
	
	/*
	 * SaveTrainDetails once the admin logged in
	 * 
	 */
	@PostMapping("/saveTrain")
	public ResponseStructure<Train> saveTrain(@RequestBody Train train) {
	
		return service.saveTrain(train);
	}
	
	/*
	 * display all train details
	 */
	@GetMapping("/trainSerach/{trainSource}/{trainDestination}")
	public List<Train> getTrainSourceToDestination(@PathVariable String trainSource, @PathVariable String trainDestination){
		
		return service.getTrainSourceToDestination(trainSource, trainDestination);
	}
}
