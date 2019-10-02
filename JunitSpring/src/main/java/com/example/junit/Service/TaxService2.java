package com.example.junit.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxService2 {

	@Autowired
	private TaxBracketService bracketService;

	public String getTaxBracket(int income) {
		if (income < 1000) {
			return "LOW";
		} else if (income < 5000) {
			return "MEDIUM";
		} else {
			return "HIGH";
		}
	}

	public List<String> allTaxBrackets() {
		return bracketService.all();
	}

	public void setBracketService(TaxBracketService taxBracketService) {

		this.bracketService = taxBracketService;
	}

}
