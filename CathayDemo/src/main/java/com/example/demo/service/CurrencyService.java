package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Currency;
import com.example.demo.repository.CurrencyRespository;

@Service
public class CurrencyService {

	@Autowired
	private CurrencyRespository currencyRespository;

	public List<Currency> selectAll() {
		return currencyRespository.findAll();
	}
	
	public Currency findById(long id) {
		return currencyRespository.findById(id).get();
	}
	
	public void save(Currency currency) {
		currencyRespository.save(currency);
	}

	public void update(Currency currency) {
		currencyRespository.save(currency);
	}
	
	public void deleteById(long id) {
		currencyRespository.deleteById(id);
	}
}
