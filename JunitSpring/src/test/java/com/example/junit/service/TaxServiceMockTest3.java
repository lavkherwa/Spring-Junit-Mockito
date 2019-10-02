package com.example.junit.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.junit.service.TaxRateService;
import com.example.junit.service.TaxServiceMock3;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TaxServiceMock3.class })
public class TaxServiceMockTest3 {

	@Autowired
	private TaxServiceMock3 service;

	@MockBean
	private TaxRateService taxBracketService;

	@Test
	public void testCalculateTax() {

		/*- 
		 * Below code will make the actual IO call to target when using 
		 * @Autowire for TaxRateService and then it will not be a unit test
		 * but rather a integration test :P
		 * 
		 * final float applicatbleTax = service.calculateTax(1000);
		 * 
		 * In such case we have to create a MOCK[Dummy]
		 * @MockBean annotation is used to create a mock of 
		 * object instead of actual bean
		 * 
		 */

		// Provided
		float income = new Float(1000);

		// When
		Mockito.when(taxBracketService.getTaxRate(income)).thenReturn(new Float(20));

		final float applicableTax = service.calculateTax(1000);

		// Then
		assertThat(applicableTax).isEqualTo(new Float(200));
	}

	/*- Mockito is very powerful and you can do a lot
	 * 
	 *  Mockito.when(restaurantService.feedbaack(AdditionalMatchers.gt(value: 4))
	 *         .thenReturn("excellent");
	 *         
	 *  Mockito.when(restaurantService.chefSpecial(Mockito.anyString(), Mockito.any(Ingredients.class)))
	 *         .thenReturn("special1")
	 *         .thenReturn("special2")
	 *         .thenReturn("special3")
	 *  
	 *  ## Checking serve method is invoked 2 times
	 *  Mockito.verify(restaurantService, Mockito.times(wantedNumberOfInvocations: 2)).serve;
	 *  
	 *  ## Checking if the method is called with specific parameter
	 *  Mockito.verify(restaurantService).order(captor.capture());
	 *  AssertThat(captor.getValue()).isEqualTo("Butter Chicken");
	 *  
	 * 
	 * 
	 * */

}
