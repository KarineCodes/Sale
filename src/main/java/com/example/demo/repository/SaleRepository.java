package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}

