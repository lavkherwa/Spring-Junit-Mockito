package com.example.junit.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.junit.service.TaxRateService;
import com.example.junit.service.TaxServiceSpy4;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TaxServiceSpy4.class })
public class TaxServiceSpyTest4 {

	/*
	 * With spy bean we can choose which methods to return dummyResponse and which
	 * one to return actual response
	 */
	@SpyBean
	private TaxServiceSpy4 service;

	@MockBean
	private TaxRateService taxRateService;

	@Test
	public void calculateTax() {

		// Provided
		float income = new Float(1000);

		// When
		Mockito.when(taxRateService.getTaxRate(income)).thenReturn(new Float(20));
		doNothing().when(service).logForAudit(any(Float.class), any(Float.class));

		final float applicableTax = service.calculateTax(1000);

		// Then
		assertThat(applicableTax).isEqualTo(new Float(200));
	}

}
