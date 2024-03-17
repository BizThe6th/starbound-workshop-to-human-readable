package tests;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class TestFileSystem {

	public static void main(String[] args) throws IOException {
		File testFile = new File("config.json5");
		boolean fileCreated = testFile.createNewFile();
		System.out.println(fileCreated ? "File has been created!" : "File failed to be created...");
		File testDir = new File(".");
		assert testDir.isDirectory();
		for(File currFile : Objects.requireNonNull(testDir.listFiles())) {
			System.out.println(currFile.getAbsolutePath());
		}
	}
}
