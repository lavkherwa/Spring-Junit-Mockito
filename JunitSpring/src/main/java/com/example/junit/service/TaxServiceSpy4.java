package com.example.junit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxServiceSpy4 {

	@Autowired
	private TaxRateService taxRateService;

	public float calculateTax(float income) {

		/* Getting rates from external service or database [any IO operation] */
		float taxRate = taxRateService.getTaxRate(income);
		float tax = (income * taxRate) / 100;

		/*- This will make a actual call and we cannot mock this as
		 *  this is a part of TaxServiceSoy4 [current class] which we
		 *  are going to test and therefore can't mock
		 * 
		 *  SOLUTION: We will have to create SPY for this 
		 *  
		 */
		logForAudit(income, tax);
		return tax;
	}

	public void logForAudit(float income, float tax) {
		// IO call to maintain logs
	}

}
