package com.example.junit.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TaxServiceMock3.class })
public class TaxServiceMockExceptionTest {

	@Autowired
	private TaxServiceMock3 service;

	@MockBean
	private TaxRateService taxBracketService;

	@Test(expected = RuntimeException.class)
	public void testCalculateTax() {

		// Provided
		float income = new Float(0);

		// When
		Mockito//
				.when(taxBracketService.getTaxRate(income))//
				.thenThrow(new RuntimeException());

		// Then
		service.calculateTax(income);

	}

}
