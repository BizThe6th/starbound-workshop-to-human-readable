package tools;

import de.marhali.json5.Json5Object;
import de.marhali.json5.Json5Options;
import de.marhali.json5.stream.Json5Lexer;
import de.marhali.json5.stream.Json5Parser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

public abstract class StringHandler {

	public static Json5Object toJson5(String in) {
		try (StringReader reader = new StringReader(in)){
			return Json5Parser.parseObject(new Json5Lexer(reader, Json5Options.DEFAULT));
		}
	}
}
