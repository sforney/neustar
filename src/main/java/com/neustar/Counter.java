package com.neustar;

import java.io.File;

/**
 * The main class of the counting program
 * @author SFORNEY
 *
 */
public class Counter {
	
	public static void main(String [] args) throws Exception {
		if(args[0] != null) {
			File file = new File(args[0]);
			Parser parser = new Parser(Loader.load(file));
			parser.getCounts();
		}
	}
}
