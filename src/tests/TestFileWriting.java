package tests;

import de.marhali.json5.Json5Element;
import de.marhali.json5.Json5Object;
import de.marhali.json5.Json5String;

public abstract class TestFileWriting {
	public static void main(String[] args) {
		Json5Object json5Object = new Json5Object();

		json5Object.add("foo", new Json5String("bar"));
		System.out.println(json5Object.toString());

	}
}