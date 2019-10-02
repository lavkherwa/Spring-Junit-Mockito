package com.example.junit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxServiceMock3 {

	@Autowired
	private TaxRateService taxRateService;

	public float calculateTax(float income) {

		/* Getting rates from external service or database [any IO operation] */
		float taxRate = taxRateService.getTaxRate(income); // we will have to create MOCK for this
		float tax = (income * taxRate) / 100;
		return tax;
	}

}
