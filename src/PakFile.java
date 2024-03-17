import tools.SiteHandler;

import java.io.File;
import java.io.IOException;

public class PakFile extends File {
	private final String workshopName;
	private final String endFileName;
	private final File superFolder;

	public PakFile(String pathname, String steamID) throws IOException {
		this(pathname, steamID, null);
	}

	public PakFile(String pathname, String steamID, File superFolder) throws IOException {
		//  Superclass constructor
		super(pathname);

		//  Scrape ws Name from steam
		workshopName = SiteHandler.scrapeClass(
				"https://steamcommunity.com/sharedfiles/filedetails/?id=" + steamID,
				"workshopItemTitle"
		);

		//  Build a final File name without any Illegal characters
		StringBuilder endFileNameBuilder = new StringBuilder();
		for (int i = 0; i < workshopName.length(); i++) {
			switch (workshopName.charAt(i)) {
				case '\\':
				case '/':
				case ':':
				case '*':
				case '\"':
				case '<':
				case '>':
				case '|':
					endFileNameBuilder.append('_');
					break;
				default:
					endFileNameBuilder.append(workshopName.charAt(i));
					break;
			}
		}
		endFileName = endFileNameBuilder.toString();

		//  Store super-folder
		this.superFolder = superFolder;
	}

	public String getWorkshopName() {
		return workshopName;
	}

	public File getSuperFolder() {
		return superFolder;
	}

	public String getEndFileName() {
		return endFileName;
	}
}
