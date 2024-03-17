import tools.SiteHandler;

import java.io.IOException;

public abstract class TestSiteHtml {
	public static void main(String[] args) throws IOException {
		System.out.println(
				SiteHandler.scrapeClass(
						"https://steamcommunity.com/sharedfiles/filedetails/?id=3182671454/",
						"workshopItemTitle"
				)
		);
	}
}
