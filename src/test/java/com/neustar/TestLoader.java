package com.neustar;

import java.io.File;
import java.net.URL;

import org.junit.Test;

import junit.framework.TestCase;

public class TestLoader extends TestCase {

	@Test
	public void testLoader() throws Exception {
		URL testFile = ClassLoader.getSystemResource("testFile.txt");
		if(testFile != null) {
			Loader.load(new File(testFile.getPath()));
		} else {
			fail("Test file failed to load!");
		}
	}
}
