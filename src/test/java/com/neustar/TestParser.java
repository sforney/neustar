package com.neustar;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

public class TestParser extends TestCase {
	@Test
	public void testParser() throws Exception {
		URL testFile = ClassLoader.getSystemResource("testFile.txt");
		Parser parser = new Parser(Files.readAllLines(new File(testFile.getPath()).toPath(), StandardCharsets.UTF_8));
		//We're testing the Parser here, not the loader
		List<SimpleEntry<Category, String>> results = parser.parseList(Files.readAllLines(new File(testFile.getPath()).toPath(), StandardCharsets.UTF_8));
		assertTrue("List size incorrect.  Expected 8, actual size was: " + results.size(), results.size() == 8);
		assertTrue("Expected 2 PERSONs, found: " + getCount(results, Category.PERSON), getCount(results, Category.PERSON) == 2);
		assertTrue("Expected 2 PLACEs, found: " + getCount(results, Category.PLACE), getCount(results, Category.PLACE) == 2);
		assertTrue("Expected 2 ANIMALs, found: " + getCount(results, Category.ANIMAL), getCount(results, Category.ANIMAL) == 2);
		assertTrue("Expected 1 COMPUTER, found: " + getCount(results, Category.COMPUTER), getCount(results, Category.COMPUTER) == 1);
		assertTrue("Expected 1 OTHER, found: " + getCount(results, Category.OTHER), getCount(results, Category.OTHER) == 1);
	}
	
	/**
	 * Returns the number of occurences of Category in the list
	 * @param list
	 * @param category - The Category to count in the list
	 * @return an int representing the number of occurences of the category in the list
	 */
	private int getCount(List<SimpleEntry<Category, String>> list, Category category) {
		int count = 0;
		for(SimpleEntry<Category, String> entry : list) {
			if(entry.getKey() == category) {
				count++;
			}
		}
		return count;
	}
}
