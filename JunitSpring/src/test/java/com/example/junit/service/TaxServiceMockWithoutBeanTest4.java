package com.example.junit.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TaxServiceMockWithoutBeanTest4 {

	private TaxServiceMock3 service;

	private TaxRateService taxBracketService;

	@Before
	public void init() {

		taxBracketService = mock(TaxRateService.class);
		service = new TaxServiceMock3(taxBracketService);
	}

	@Test
	public void testCalculateTax() {

		// Provided
		float income = new Float(1000);

		// When
		Mockito.when(taxBracketService.getTaxRate(income)).thenReturn(new Float(20));

		final float applicatbleTax = service.calculateTax(1000);

		// Then
		assertThat(applicatbleTax).isEqualTo(new Float(200));
	}

}