import tools.FileHandler;

import java.io.File;

/**
 *  <h1>
 *      {@code class} Config
 *      <p>
 *          Represents configuration information
 *      </p>
 *  </h1>
 */
public class Config {
	String path = "";

	public Config(File configFile) {
		this(FileHandler.readText(configFile));
	}

	public Config(String configString) {
	}
}
