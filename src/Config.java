import de.marhali.json5.Json5Object;
import tools.FileHandler;
import tools.StringHandler;

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
		this(FileHandler.Read.json5(configFile));
	}

	public Config(String configString) {
		this(StringHandler.toJson5(configString));
	}

	public Config(Json5Object configJson5) {

	}
}
