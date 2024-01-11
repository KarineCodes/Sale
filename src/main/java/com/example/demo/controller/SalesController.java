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

import com.example.demo.dto.SalesDto;
import com.example.demo.entities.Sale;
import com.example.demo.repository.SaleRepository;
import com.example.demo.utils.SaleUtils;

import jakarta.transaction.Transactional;

@RestController
@Transactional
public class SalesController {

	Logger logger = LoggerFactory.getLogger(SalesController.class);

	@Autowired
	SaleRepository saleRepository;
	
	@RequestMapping(value = "/sale", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Sale>> getSales(){
		
		var result = saleRepository.findAll();

		if(!result.isEmpty())
		{
			return ResponseEntity.ok(result);
		}
		return null;
	}
	
	@RequestMapping(value = "/sale", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sale> CreateSales(@RequestPart(required = true) SalesDto dto){
	
		Sale newSale = SaleUtils.extract(dto);
		newSale = saleRepository.save(newSale);
		
		return ResponseEntity.ok(newSale);
	}
	
	@RequestMapping(value = "/sale/{id}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sale> updateSales(@PathVariable long id, @RequestPart(required = true) SalesDto dto){
	
		var result = saleRepository.findById(id);
		if (result.isEmpty())
			return ResponseEntity.notFound().build();
	
		var newSale = SaleUtils.extract(result.get(),dto);
		
		logger.info("Sale Updated - Sale ID: .., Client: ..., Seller : ..., Total: ...", newSale.id, newSale.client, newSale.seller, newSale.total);
		
		return ResponseEntity.ok(saleRepository.save(newSale));
	}
}
