package tests;

import tools.FileHandler;

import java.io.File;

public abstract class TestFileReading {
	public static void main(String[] args){
		String string = FileHandler.readText(new File("./Boo!"));
		System.out.println(string);


	}
}
