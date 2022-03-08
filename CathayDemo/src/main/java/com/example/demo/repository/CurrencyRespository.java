package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.entity.Currency;

public interface CurrencyRespository extends JpaRepository<Currency, Long> {

}
