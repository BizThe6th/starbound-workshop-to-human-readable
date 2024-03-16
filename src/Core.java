import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class Core {
	public static void main(String[] args) {
		//* MEMORY
		//  Todo: Add path to the dir the jar is in
		File coreDir = new File("path/to/file");    //  The dir the jar is in
		List<PakFile> mods = new ArrayList<>();

		//* WORK
		assert coreDir.isDirectory();

		//  Assigning var dirs folders containing .pak files
		for (File a : coreDir.listFiles()) {
			if (a.isDirectory()){
				for (File b : a.listFiles()){
					if (strContains(b.getName(), ".pak") && b.isFile()) {
						mods.add(new PakFile(b.getPath(), a.getName()));
					}
				}
			} else if (a.isFile() && strContains(a.getName(), ".pak")) {
				mods.add(new PakFile(a.getPath(), a.getName()));
			}
		}
	}

	public static boolean strContains(String search, String inquiry) {
		int inquiryPos = 0;    //  Position in the "inquiry" String
		for (int searchPos = 0; searchPos < search.length() - inquiry.length() + 1; searchPos++) {
			if (search.charAt(searchPos) == inquiry.charAt(inquiryPos)) {
				if (inquiryPos == inquiry.length() - 1) return true;
				inquiryPos++;
			} else {
				inquiryPos = 0;
			}
		}
		return false;
	}
}