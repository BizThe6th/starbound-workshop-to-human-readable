package tests;

import java.io.File;
import java.io.IOException;

public class TestFileSystem {

	public static void main(String[] args) throws IOException {
		File testFile = new File("boo.json5");
		testFile.createNewFile();
		File testDir = new File(".");
		for(File currFile : testDir.listFiles()) {
			System.out.println(currFile.getAbsolutePath());
		}
	}
}
