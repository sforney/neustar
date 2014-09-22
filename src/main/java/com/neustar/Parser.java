package com.neustar;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
	private List<String> input;
	
	public Parser() {
	}
	
	public Parser(List<String> input) {
		this.input = input;
	}
	
	/**
	 * Parses a list of input into a list of Categories and items
	 * @param input
	 * @return A List of SimpleEntry containing the category and item
	 */
	public List<SimpleEntry<Category, String>> parseList(List<String> input) {
		List<SimpleEntry<Category, String>> results = new ArrayList<SimpleEntry<Category, String>>();
		for(String line : input) {
			SimpleEntry<Category, String> entry = parseLine(line);
			if(entry != null) {
				results.add(entry);
			}
		}
		return results;
	}
	
	/**
	 * Parses a line of input into a category and an item.  Ignores invalid inputs
	 * @param line
	 * @return A SimpleEntry containing the category and item if successful, null otherwise
	 */
	public SimpleEntry<Category, String> parseLine(String line) {
		line = line.trim();
		int breakpoint = line.indexOf(" ");
		Category category = null;
		if(breakpoint >= 0 ) {
			category = Category.getCategory(line.substring(0, breakpoint));
			if(category != null) {
				return new SimpleEntry<Category, String>(category, line.substring(breakpoint+1));
			}
		}
		return null;
	}
	
	/**
	 * Parses input and returns the counts of each category, along with 
	 * the list of items (with invalid entries filtered out)
	 */
	public void getCounts() {	
		Map<Category, Integer> counts = initializeCounts();
		List<SimpleEntry<Category, String>> filteredList = parseList(input);

		//Then, we iterate over the filtered list to generate the final counts
		for(SimpleEntry<Category, String> entry : filteredList) {
			counts.put(entry.getKey(), counts.get(entry.getKey()) + 1);
		}
		
		outputCounts(counts, filteredList);
	}
	
	public void outputCounts(Map<Category, Integer> counts, List<SimpleEntry<Category, String>> filteredList) {
		System.out.println("CATEGORY" + "\t" + "COUNT");
		//The Categories were listed in the proper display order initially, so this works
		for(Category category : Category.values()) {
			System.out.println(category.toString() + "\t\t" + counts.get(category));
		}
		for(SimpleEntry<Category, String> entry : filteredList) {
			System.out.println(entry.getKey().toString() + " " + entry.getValue());
		}
	}
	
	public Map<Category, Integer> initializeCounts() {
		Map<Category, Integer> counts = new HashMap<Category, Integer>();
		counts.put(Category.PERSON, 0);
		counts.put(Category.PLACE, 0);
		counts.put(Category.ANIMAL, 0);
		counts.put(Category.COMPUTER, 0);
		counts.put(Category.OTHER, 0);
		return counts;
	}
	
	public List<String> getInput() {
		return input;
	}

	public void setInput(List<String> input) {
		this.input = input;
	}
}