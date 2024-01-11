package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.example.demo.entities.Client;

public class SalesDto {
	
	public int id;
	public User seller;
	public double total;
	public Client client;
	public Date creationDate;
	public List<TransactionDto> transactions;
	
}
