package com.fdm.cc;

import java.util.HashSet;
import java.util.Set;

public class Offers {
	
	Set<PriceRule> offers = new HashSet<PriceRule>();

	public void loadOffers(PriceRule... priceRules) {
		for (PriceRule priceRule : priceRules) {
			offers.add(priceRule);
		}
	}
}
