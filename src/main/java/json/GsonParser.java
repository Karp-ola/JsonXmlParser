package json;

import Interfaces.Parsable;
import com.google.gson.*;
import model.People;
import model.Root;
import utils.GenerateData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static utils.Constants.*;

public class GsonParser implements Parsable {

	@Override
	public Root parseJsonToJavaObject() throws IOException {

		Gson gson = new Gson();
		FileReader reader = new FileReader(PATH_TO_JSON_TEST_FILE);
		Root root = gson.fromJson(reader, Root.class);
		reader.close();
		return root;
	}

	@Override
	public void writeJavaObjectToJsonFile() throws IOException {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Root root = GenerateData.createRootObject();

		FileWriter writer = new FileWriter(PATH_TO_WRITTEN_PEOPLE_GSON_FILE);
		gson.toJson(root, writer);
		writer.flush();
	}



	public List<Integer> getListOfPeopleAges() throws FileNotFoundException {
		List<Integer> listOfAges = new ArrayList<>();
		File file = new File(PATH_TO_JSON_TEST_FILE);
		JsonElement fileElement = JsonParser.parseReader(new FileReader(file));
		JsonObject fileObject = fileElement.getAsJsonObject();

		JsonArray jsonArrayOfPeople = fileObject.get(TAG_PEOPLE).getAsJsonArray();
		for(JsonElement jsonElement : jsonArrayOfPeople){
			JsonObject personJsonObject = jsonElement.getAsJsonObject();
			int ageOfPerson = personJsonObject.get(TAG_AGE).getAsInt();
			listOfAges.add(ageOfPerson);
		}
		return  listOfAges;
	}

	public List<String> getListOfPeopleNames() throws FileNotFoundException {
		List<String> listOfNames = new ArrayList<>();
		File file = new File(PATH_TO_JSON_TEST_FILE);
		JsonElement fileElement = JsonParser.parseReader(new FileReader(file));
		JsonObject fileObject = fileElement.getAsJsonObject();

		JsonArray jsonArrayOfPeople = fileObject.get(TAG_PEOPLE).getAsJsonArray();
		for(JsonElement jsonElement : jsonArrayOfPeople){
			JsonObject personJsonObject = jsonElement.getAsJsonObject();
			String nameOfPerson = personJsonObject.get(TAG_NAME).getAsString();
			listOfNames.add(nameOfPerson);
		}
		return listOfNames;
	}

}
