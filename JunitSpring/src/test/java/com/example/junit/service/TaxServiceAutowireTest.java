package com.example.junit.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
/*- 
 * 
 * @SpringBootTest  
 * 
 * Tell spring to create application context
 * 
 *  NOTE: This will create application context and load
 *        all the beans across application, If application is 
 *        large then it will be problematic
 *  
 *  So, instead of using @SpringBootTest, we can use @ContextConfiguration
 *  to tell spring only load provided classes in the application context
 *  at a moment
 */
@ContextConfiguration(classes = { TaxService2.class, TaxBracketService.class })
public class TaxServiceAutowireTest {

	@Autowired
	private TaxService2 service;

	@SuppressWarnings("unused")
	@Autowired
	private TaxBracketService taxBracketService;

	@Before
	public void init() {
		/*-
		 * Global @Autowire will take care as we are adding annotation
		 * 
		 * @SpringBootTest 
		 * @ContextConfiguration 
		 * 
		 * At class to tell spring to take care
		 * of initializing the application context
		 * 
		 */
	}

	@Test
	public void testGetTaxBracket() {
		final String taxBracket = service.getTaxBracket(1000);

		assertThat(taxBracket).isEqualTo("MEDIUM");
	}

	@Test
	public void testAllTaxBrackets() {
		final List<String> allTaxBrackets = service.allTaxBrackets();

		assertThat(allTaxBrackets).isNotEmpty();
		assertThat(allTaxBrackets).contains("LOW", "MEDIUM", "HIGH");
	}

}
