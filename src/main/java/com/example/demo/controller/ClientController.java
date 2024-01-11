package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ClientDto;
import com.example.demo.entities.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.utils.ClientUtils;

import jakarta.transaction.Transactional;

@RestController
@Transactional
public class ClientController {

	Logger logger = LoggerFactory.getLogger(ClientController.class);

	@Autowired
	ClientRepository clientRepository;
	
	@RequestMapping(value = "/client", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Client>> getClient(){
		
		var result = clientRepository.findAll();

		if(!result.isEmpty())
		{
			return ResponseEntity.ok(result);
		}
		return null;
	}
	
	@RequestMapping(value = "/client", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> CreateClient(@RequestPart(required = true) ClientDto dto){
	
		Client newClient = ClientUtils.extract(dto);
		newClient = clientRepository.save(newClient);
		
		return ResponseEntity.ok(newClient);
	}
	
	@RequestMapping(value = "/client/{id}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> updateClient(@PathVariable long id, @RequestPart(required = true) ClientDto dto){
	
		var result = clientRepository.findById(id);
		if (result.isEmpty())
			return ResponseEntity.notFound().build();
	
		var newClient = ClientUtils.extract(result.get(),dto);
		
		return ResponseEntity.ok(clientRepository.save(newClient));
	}
}
