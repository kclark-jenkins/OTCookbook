package org.krisbox.cookbook.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import org.krisbox.cookbook.models.ConnectionDetails;
import org.krisbox.cookbook.models.ConnectionDetailsDao;
import org.krisbox.cookbook.models.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class SaveConnectionDetailsController {
	@Autowired
	ConnectionDetailsDao connRepo;
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/saveConnectionDetails", method = RequestMethod.GET)
    public Result getConnectionDetails(@RequestParam(value="username") String username,
    								   @RequestParam(value="volume") String volume,
    								   @RequestParam(value="connectionString") String connectionString,
    								   @RequestParam(value="extendedProperties", required=false) String extendedProperties) {
		
		try{
			deleteIfExists(username, volume);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		try {
			connRepo.save(new ConnectionDetails(username,volume,connectionString,extendedProperties));
		}catch(Exception ex){
			return new Result(counter.incrementAndGet(), ex.toString());
		}
		
		return new Result(counter.incrementAndGet(), "success");
		//return new ConnectionDetailsModel(counter.incrementAndGet(), username, volume, connectionString, extendedProperties);
    }
	
	private void deleteIfExists(String username, String volume) {
		connRepo.deleteByUsernameAndVolume(username, volume);
	}
}