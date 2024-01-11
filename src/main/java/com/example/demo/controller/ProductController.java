package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDto;
import com.example.demo.entities.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.utils.ProductUtils;

@RestController
@Transactional
public class ProductController {

	Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductRepository productRepository;
	
	@RequestMapping(value = "/product", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getProduct(){
		
		var result = productRepository.findAll();

		if(!result.isEmpty())
		{
			return ResponseEntity.ok(result);
		}
		return null;
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> CreateProduct(@RequestPart(required = true) ProductDto dto){
	
		Product newProduct = ProductUtils.extract(dto);
		newProduct = productRepository.save(newProduct);
		
		return ResponseEntity.ok(newProduct);
	}
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestPart(required = true) ProductDto dto){
	
		var result = productRepository.findById(id);
		if (result.isEmpty())
			return ResponseEntity.notFound().build();
	
		var newProduct = ProductUtils.extract(result.get(),dto);
		
		return ResponseEntity.ok(productRepository.save(newProduct));
	}
	
}
