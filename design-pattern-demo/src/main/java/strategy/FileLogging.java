package strategy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogging implements Logging {
	private final File toWrite;

	public FileLogging(final File toWrite) {
		this.toWrite = toWrite;
	}

	@Override
	public void write(final String message) {
		try {
			final FileWriter fos = new FileWriter(toWrite);
			fos.write(message);
			fos.close();
		} catch (IOException e) {
			// handle IOException
		}
	}

}
