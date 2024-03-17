package tests;

import de.marhali.json5.Json5Object;
import tools.FileHandler;

import java.io.File;

public abstract class TestFileReading {
	public static void main(String[] args){
		File file = new File("./config.json5");
		String string = FileHandler.Read.text(file);
		Json5Object json5Object = FileHandler.Read.json5(file);


		System.out.println(string);
		System.out.println("\n".repeat(99));
		System.out.println(json5Object.get("workshopPath").getAsString());
		System.out.println(json5Object.get("endPath").getAsString());
	}
}
