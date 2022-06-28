package Interfaces;

import model.Root;

import java.io.IOException;
import java.util.List;

public interface Parsable {

	Root parseJsonToJavaObject() throws IOException;

	void writeJavaObjectToJsonFile() throws IOException;
	List<Integer> getListOfPeopleAges() throws IOException;

	List<String> getListOfPeopleNames() throws IOException;

}
