package com.fdm.cc;

import java.util.HashMap;
import java.util.Map;

public class Checkout {
	
	Map<Character, Integer> prices = new HashMap<Character, Integer>();
	
	public Checkout() {
		prices.put('A', 50);
		prices.put('B', 30);
		prices.put('C', 20);
		prices.put('D', 15);
	}

	public int calculatePrice(String items) throws InvalidItemException {
		if (items.equals("")) {
			return 0;
		}
		
		char firstItem = items.charAt(0);
		
		if (!prices.containsKey(firstItem)) {
			throw new InvalidItemException();
		}
		
		int numberOfOccurencesOfFirstItem = countNumberOfLetterOccurences(firstItem, items);
		
		return applyPriceRule(firstItem, numberOfOccurencesOfFirstItem) 
				+ calculatePrice(stripCharactersFromString(firstItem, items));
	}

	public int applyPriceRule(char item, int quantity) {
		int total = prices.get(item)*quantity;
		switch (item) {
			case 'A':
				total = (quantity/3)*130 + (quantity%3)*prices.get('A');
				break;
			case 'B':
				total = (quantity/2)*45 + (quantity%2)*prices.get('B');
				break;
		}
		return total;
	}
	
	public int countNumberOfLetterOccurences(char c, String str) {
		int numOccurences=0;
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i) == c) {
				numOccurences++;
			}
		}
		return numOccurences;
	}
	
	public String stripCharactersFromString(char c, String str) {
		String result = "";
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i) != c) {
				result += str.charAt(i);
			}
		}
		return result;
	}
}
