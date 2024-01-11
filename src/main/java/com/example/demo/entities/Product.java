package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	public int id;
	
	@Column(name="Name")
	public String name;
	
	@Column(name="Description")
	public String desc;
	
	@Column(name="Category")
	public String category;
	
	@Column(name="Creation Date")
	public Date creationDate;
	
}
