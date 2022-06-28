package Interfaces;

import model.Root;
import java.io.IOException;

public interface Parsable {

	Root parseJsonToJavaObject() throws IOException;

	void writeJavaObjectToJsonFile() throws IOException;
}
