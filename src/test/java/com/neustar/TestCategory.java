package com.neustar;

import org.junit.Test;

import junit.framework.TestCase;

public class TestCategory extends TestCase {

	@Test
	public void testGetCategory() throws Exception{
		assertTrue(Category.getCategory("Person") == Category.PERSON);
		assertTrue(Category.getCategory("PLACE") == Category.PLACE);
		assertTrue(Category.getCategory("ComPUTER") == Category.COMPUTER);
		assertTrue(Category.getCategory("Animal") == Category.ANIMAL);
		assertTrue(Category.getCategory("oTHER") == Category.OTHER);
		assertTrue(Category.getCategory("Monkeys!") == null);
	}
}
