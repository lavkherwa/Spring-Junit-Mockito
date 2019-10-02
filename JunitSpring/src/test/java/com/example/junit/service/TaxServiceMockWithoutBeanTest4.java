package com.example.junit.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = { TaxServiceMock3.class })
public class TaxServiceMockWithoutBeanTest4 {

	private TaxServiceMock3 service;

	private TaxRateService taxBracketService;

	@Before
	public void init() {

		/*- Another way to mock, instead of using @MockBean 
		 * 
		 *  NOTE: You should remove any annotation with
		 *  
		 *        @ContextConfiguration
		 *        @SpringBootTest  
		 *        
		 *        Because now we don't want spring application
		 *        context to initialize the beans and rather we 
		 *        do it ourself
		 */
		taxBracketService = mock(TaxRateService.class);

		service = new TaxServiceMock3(taxBracketService);
	}

	@Test
	public void testCalculateTax() {

		// Provided
		float income = new Float(1000);

		// When
		Mockito.when(taxBracketService.getTaxRate(income)).thenReturn(new Float(20));

		final float applicableTax = service.calculateTax(1000);

		// Then
		assertThat(applicableTax).isEqualTo(new Float(200));
	}

}
