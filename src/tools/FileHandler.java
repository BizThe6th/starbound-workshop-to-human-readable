package tools;

import de.marhali.json5.Json5Object;
import de.marhali.json5.Json5Options;
import de.marhali.json5.stream.Json5Lexer;
import de.marhali.json5.stream.Json5Parser;

import java.io.*;

public abstract class FileHandler {
	public static String readText(File in) {
		try (FileReader reader = new FileReader(in)) {
			StringBuilder out = new StringBuilder();
			int currChar = reader.read();
			while (currChar > -1) {
				out.append((char) currChar);
				currChar = reader.read();
			}
			reader.close();
			return out.toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static Json5Object readJson5(File in) {
		try (FileReader reader = new FileReader(in)){
			return Json5Parser.parseObject(new Json5Lexer(reader, Json5Options.DEFAULT));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
