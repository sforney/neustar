package com.neustar;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class Loader {
	public static List<String> load(File file) throws IOException{
		//We're assuming the file is small enough to read in all at once
		//For a coding assignment, that seems like a safe bet
		return Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
	}
}
