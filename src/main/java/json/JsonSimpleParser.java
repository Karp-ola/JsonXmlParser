package json;

import Interfaces.Parsable;
import model.People;
import model.Root;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utils.GenerateData;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static utils.Constants.*;

public class JsonSimpleParser implements Parsable {

	@Override
	public Root parseJsonToJavaObject() throws IOException {
		Root root = new Root();
		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(PATH_TO_JSON_TEST_FILE);
		JSONObject rootObject = null;
		try {
			rootObject = (JSONObject) parser.parse(reader);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String name = (String)rootObject.get(TAG_NAME_MAIN);
		JSONArray peopleJsonArray = (JSONArray) rootObject.get(TAG_PEOPLE);

		List<People> peopleList = new ArrayList<>();
		for(Object it: peopleJsonArray){
			JSONObject peopleJsonObject = (JSONObject) it;
			String namePeople = (String) peopleJsonObject.get(TAG_NAME);
			long age = (long)peopleJsonObject.get(TAG_AGE);
			People people = new People((int)age, namePeople);
			peopleList.add(people);
		}
		root.setName(name);
		root.setPeopleList(peopleList);
		return root;
	}

	@Override
	public void writeJavaObjectToJsonFile() throws IOException {

		JSONObject jsonObject = GenerateData.createJsonObject();

		try(FileWriter file = new FileWriter(PATH_TO_WRITTEN_PEOPLE_JSON_FILE)){
			file.write(jsonObject.toJSONString());
			file.flush();
		}
	}

	@Override
	public List<String> getListOfPeopleNames() throws IOException {
		Root root = parseJsonToJavaObject();
		List<String> peopleNames = new ArrayList<>();
		List<People> people = root.getPeople();
		for(People p : people){
			String name = p.getName();
			peopleNames.add(name);
		}
		return peopleNames;
	}

	@Override
	public List<Integer> getListOfPeopleAges() throws IOException {
		Root root = parseJsonToJavaObject();
		List<Integer> peopleAges = new ArrayList<>();
		List<People> people = root.getPeople();
		for(People p : people){
			int age = p.getAge();
			peopleAges.add(Integer.valueOf(age));
		}
		return peopleAges;
	}
}
