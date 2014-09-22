package com.neustar;

public enum Category {
	PERSON, PLACE, ANIMAL, COMPUTER, OTHER;
	
	//Used to convert from file text to enum
	public static Category getCategory(String category) {
		if(category.equalsIgnoreCase("PERSON")) {
			return Category.PERSON;
		} else if (category.equalsIgnoreCase("PLACE")) {
			return Category.PLACE;
		} else if (category.equalsIgnoreCase("ANIMAL")) {
			return Category.ANIMAL;
		} else if (category.equalsIgnoreCase("COMPUTER")) {
			return Category.COMPUTER;
		} else if (category.equalsIgnoreCase("OTHER")) {
			return Category.OTHER;
		} else {
			//Maybe this should throw an exception instead?
			return null;
		}
	}
}