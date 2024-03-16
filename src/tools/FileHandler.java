package tools;

import de.marhali.json5.Json5Element;
import de.marhali.json5.Json5Object;
import de.marhali.json5.Json5Options;
import de.marhali.json5.stream.Json5Lexer;
import de.marhali.json5.stream.Json5Parser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <h1>
 * {@code class} FileHandler
 * <p>
 *          Todo
 *      </p>
 *  </h1>
 */
public abstract class FileHandler {
	/**
	 * <h2>
	 * {@code class} Read
	 * <p>
	 *          Todo
	 *      </p>
	 *  </h2>
	 */
	public static abstract class Read {
		public static String text(File in) {
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

		public static Json5Object json5(File in) {
			try (FileReader reader = new FileReader(in)) {
				return Json5Parser.parseObject(new Json5Lexer(reader, Json5Options.DEFAULT));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * <h2>
	 * {@code class} Write
	 * <p>
	 *          Todo
	 *      </p>
	 *  </h2>
	 */
	public static abstract class Write {
		public static void json5(File file, Json5Element in) {
			json5(file.getPath(), in);
		}

		public static void json5(String path, Json5Element in) {
			try (FileWriter fileWriter = new FileWriter(path)) {
				fileWriter.write(in.toString());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public static void text(File file, String in) {
			text(file.getPath(), in);
		}

		public static void text(String path, String in) {
			try (FileWriter fileWriter = new FileWriter(path)) {
				fileWriter.write(in);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
