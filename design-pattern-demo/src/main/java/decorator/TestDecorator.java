package decorator;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TestDecorator {

	public void decoratorPattern() throws IOException {
		final File f = new File("target", "out.bin");
		final FileOutputStream fos = new FileOutputStream(f);
		final BufferedOutputStream bos = new BufferedOutputStream(fos);
		final ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeBoolean(true);
		oos.writeInt(42);
		oos.writeObject(new ArrayList<Integer>());
		
		oos.flush();
		oos.close();
		bos.close();
		fos.close();
	}

}
