package tools;

import de.marhali.json5.Json5Object;
import de.marhali.json5.Json5Options;
import de.marhali.json5.stream.Json5Lexer;
import de.marhali.json5.stream.Json5Parser;

import java.io.StringReader;

public abstract class StringHandler {
	public static Json5Object toJson5(String in) {
		return Json5Parser.parseObject(new Json5Lexer(new StringReader(in), Json5Options.DEFAULT));
	}
}
