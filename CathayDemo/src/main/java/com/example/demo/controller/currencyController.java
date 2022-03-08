package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entity.Currency;
import com.example.demo.service.CurrencyService;

@RestController
public class currencyController {

	@Autowired
	private CurrencyService currencyService;

	@GetMapping("/selectAll")
	public List<Currency> selectAll() {
		return currencyService.selectAll();
	}
	
	@GetMapping("/findById")
	public Currency findById(long id) {
		return currencyService.findById(id);
	}
	
	@PostMapping("/save")
	public void save(Currency currency) {
		currencyService.save(currency);
	}

	@PutMapping("/update")
	public void update(Currency currency) {
		currencyService.update(currency);
	}

	@DeleteMapping("/delete")
	public void deleteById(long id) {
		currencyService.deleteById(id);
	}
}
