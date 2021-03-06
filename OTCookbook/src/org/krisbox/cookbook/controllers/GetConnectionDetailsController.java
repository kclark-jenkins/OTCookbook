package org.krisbox.cookbook.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.krisbox.cookbook.models.ConnectionDetails;
import org.krisbox.cookbook.models.ConnectionDetailsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class GetConnectionDetailsController {
	@Autowired
	ConnectionDetailsDao connRepo;
	
	@RequestMapping(value = "/getConnectionDetails", method = RequestMethod.GET)
    public List<ConnectionDetails> getConnectionDetails(@RequestParam(value="username") String username,
			   						   @RequestParam(value="volume") String volume) {
		
		List<ConnectionDetails> allConnections = new ArrayList<ConnectionDetails>();
		for (ConnectionDetails details : connRepo.findByUsernameAndVolume(username, volume)) {
			//details.setExtendedProperties(details.getExtendedProperties().replaceAll("\\\'", ""));
			//details.setExtendedProperties();
			allConnections.add(details);
		}
		
        return allConnections;
		//return allConnections.get(allConnections.size()-1);
    }

}