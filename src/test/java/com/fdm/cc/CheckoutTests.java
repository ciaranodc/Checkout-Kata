package com.fdm.cc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckoutTests {
	
	Checkout co = new Checkout();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test(expected=InvalidItemException.class)
	public void testCalculatePriceOfInvalidItemThrowsInvalidItemException() throws InvalidItemException {
		co.calculatePrice("X");
		fail();
	}
	
	@Test
	public void testCalculatePriceOfNoItemsReturnsTotalOfZero() throws InvalidItemException {
		assertEquals(0, co.calculatePrice(""));
	}

	@Test
	public void testCalculatePriceOfSingleItemReturnsCorrectValue() throws InvalidItemException {
		assertEquals(50, co.calculatePrice("A"));
		assertEquals(30, co.calculatePrice("B"));
		assertEquals(20, co.calculatePrice("C"));
		assertEquals(15, co.calculatePrice("D"));
	}
	
	@Test
	public void testCalculatePriceOfMoreThanOneItemProvidedNoSpecialPriceRulesAreAppliedReturnsCorrectTotal() 
			throws InvalidItemException{
		assertEquals(80, co.calculatePrice("AB"));
		assertEquals(100, co.calculatePrice("ABC"));
		assertEquals(115, co.calculatePrice("ABCD"));
		assertEquals(70, co.calculatePrice("AC"));
		assertEquals(65, co.calculatePrice("AD"));
		assertEquals(130, co.calculatePrice("AAB"));
		assertEquals(65, co.calculatePrice("BCD"));
		assertEquals(70, co.calculatePrice("CCDD"));
	}
	
	@Test
	public void testCalculatePriceOfMoreThanOneItemWithSpecialPriceRulesApplied() throws InvalidItemException {
		assertEquals(130, co.calculatePrice("AAA"));
		assertEquals(160, co.calculatePrice("ABAA"));
		assertEquals(65, co.calculatePrice("BBC"));
		assertEquals(570, co.calculatePrice("ABCDDCCCDDAAAABBBBAA"));
	}
	
	
	

}
