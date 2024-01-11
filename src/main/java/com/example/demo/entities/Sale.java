package com.example.demo.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.example.demo.dto.TransactionDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Sale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column(name="Seller_id")
	public User seller;
	
	@Column(name="Total")
	public Double total;
	
	@ManyToOne
	@Column(name="Client_id")
	public Client client;
	
	@Column(name="Creation Date")
	public Date creationDate;
	
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    public List<TransactionDto> transactions = new ArrayList<>();
}
