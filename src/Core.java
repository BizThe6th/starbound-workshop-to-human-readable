import tools.FileHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Core {
	public static void main(String[] args) {
		//* MEMORY
		File wsDir = new File(FileHandler.Read.json5("./config.json5").get("workshopPath").getAsString());    //  The dir where the .pak files are
		File endDir = new File(FileHandler.Read.json5("./config.json5").get("endPath").getAsString());
		List<PakFile> mods = new ArrayList<>();                                                                 //  A list of the .pak mod files


		//* WORK
		assert wsDir.isDirectory();   //  Pointless to search a file

		//  Assigning var dirs folders containing .pak files
		for (File a : Objects.requireNonNull(wsDir.listFiles())) {
			if (a.isDirectory()) {
				for (File b : Objects.requireNonNull(a.listFiles())) {
					if (FileHandler.Read.extensionEquals(b, "pak")) {
						System.out.println("Checking file at \"" + b.getAbsolutePath() + "\"...");
						try {
							String bPath = b.getPath();
							String aName = a.getName();
							mods.add(new PakFile(bPath, aName, a));

							System.out.println("This mod is \"" + mods.getLast().getWorkshopName() + "\"!\n");
							break;
						} catch (IOException e) {
							System.out.println("Failed to find the workshop name of " + b.getAbsolutePath());
						}
					}
				}
			} else if (FileHandler.Read.extensionEquals(a, "pak")) {
				System.out.println("Checking file at \"" + a.getAbsolutePath() + "\"...");
				try {
					mods.add(new PakFile(a.getPath(), a.getName()));
					System.out.println("This mod is \"" + mods.getLast().getWorkshopName() + "\"!\n");
				} catch (IOException e) {
					System.out.println("Failed to find the workshop name of " + a.getAbsolutePath() + "\n");
				}
			}
		}

		//  Move the files
		for (PakFile currentMod : mods) {
			File newLocation = new File(endDir.getPath() + "/" + currentMod.getEndFileName() + ".pak");
			System.out.println("Moving \"" + currentMod.getWorkshopName() + "\"...");
			try {
				Files.move(currentMod.toPath(), newLocation.toPath(), StandardCopyOption.REPLACE_EXISTING);
				System.out.println("Move successful" + (currentMod.getWorkshopName().equals(currentMod.getEndFileName()) ? "!" : ("\nNOTE: (File name has been changed to \"" + currentMod.getEndFileName() + "\" in order to prevent windows from complaining.)")));

				if (currentMod.getSuperFolder() != null) {
					System.out.println("Deleting previous super-folder \"" + currentMod.getSuperFolder().getAbsolutePath() + "\"...");
					if (currentMod.getSuperFolder().delete()) System.out.println("Empty folder deletion Successful!\n");
					else System.out.println("Empty folder deletion Failed for unknown reason.\n");
				}
			} catch (IOException e) {
				System.out.println(
						"Failed to move\n" +
								"\"" + currentMod.getAbsolutePath() + "\"\n" +
								"Because of IOException\n" +
								"\"" + e + "\"\n"
				);
			}
		}
	}
}