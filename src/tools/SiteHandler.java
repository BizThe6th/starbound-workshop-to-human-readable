package tools;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Objects;

public class SiteHandler {
	public static String scrapeClass(String urlStr, String className) throws IOException {
		return Objects.requireNonNull(Jsoup.connect(urlStr).get().getElementsByClass(className).first()).text();
	}
}
