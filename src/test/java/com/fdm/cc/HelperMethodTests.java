package com.fdm.cc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HelperMethodTests {
	
	Checkout co;

	@Before
	public void setUp() throws Exception {
		co = new Checkout();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCountNumberOfLetterOccurencesReturnsCorrectResult() {
		assertEquals(4, co.countNumberOfLetterOccurences('A', "AABCDACA"));
		assertEquals(0, co.countNumberOfLetterOccurences('B', "AAC"));
		assertEquals(2, co.countNumberOfLetterOccurences('C', "CCDD"));
		assertEquals(2, co.countNumberOfLetterOccurences('D', "CCDD"));
	}

	@Test
	public void testStripOutCharactersReturnStringMinusOccurencesOfTheSpecifiedCharacter() {
		assertEquals("heo", co.stripCharactersFromString('l', "hello"));
		assertEquals("DD", co.stripCharactersFromString('C', "CCDD"));
		assertEquals("CC", co.stripCharactersFromString('D', "CCDD"));
	}
	
	@Test
	public void testApplyPriceRuleReturnsAdjustedTotal() {
		assertEquals(130, co.applyPriceRule('A', 3));
		assertEquals(45, co.applyPriceRule('B', 2));
	}
	
	@Test
	public void testApplyPriceRuleReturnsNormalPriceOfItemIfNoPriceRulesAvailable() {
		assertEquals(50, co.applyPriceRule('A', 1));
		assertEquals(30, co.applyPriceRule('B', 1));
		assertEquals(20, co.applyPriceRule('C', 1));
		assertEquals(15, co.applyPriceRule('D', 1));
		assertEquals(40, co.applyPriceRule('C', 2));
		assertEquals(30, co.applyPriceRule('D', 2));
	}

}
