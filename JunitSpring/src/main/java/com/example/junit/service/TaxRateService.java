package com.example.junit.service;

import org.springframework.stereotype.Component;

@Component
public class TaxRateService {

	public float getTaxRate(float income) {

		if (income <= 0) {
			throw new RuntimeException("income can't be less than 0");
		}

		if (income < 1000.00) {
			return 10;
		} else if (income < 5000) {
			return 20;
		} else {
			return 30;
		}
	}

}
