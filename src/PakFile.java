import java.io.File;

public class PakFile extends File {
	private final String steamID;

	public PakFile(String pathname, String steamID) {
		super(pathname);
		this.steamID = steamID;
	}

	public String getSteamID() {
		return steamID;
	}
}
