package json;

import Interfaces.Parsable;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Root;
import utils.GenerateData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static utils.Constants.*;

public class JacksonParser implements Parsable {

	ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public Root parseJsonToJavaObject() throws IOException {
		File file = new File(PATH_TO_JSON_TEST_FILE);
		Root root = objectMapper.readValue(file, Root.class);
		return root;
	}

	@Override
	public void writeJavaObjectToJsonFile() throws IOException {
		Root root = GenerateData.createRootObject();
		objectMapper.writeValue(new File(PATH_TO_WRITTEN_PEOPLE_JACKSON_FILE), root);
	}
	@Override
	public List<String> getListOfPeopleNames() throws IOException {
		List<String> peopleNames = new ArrayList<>();
		JsonNode rootNode = objectMapper.readTree(new File(PATH_TO_JSON_TEST_FILE));
		JsonNode peopleNode = rootNode.path(TAG_PEOPLE);
		for(JsonNode node : peopleNode){
			String name = node.path(TAG_NAME).asText();
			peopleNames.add(name);
		}
		return peopleNames;

	}
	@Override
	public List<Integer> getListOfPeopleAges() throws IOException {
		List<Integer> peopleAges = new ArrayList<>();
		JsonNode rootNode = objectMapper.readTree(new File(PATH_TO_JSON_TEST_FILE));
		JsonNode peopleNode = rootNode.path(TAG_PEOPLE);
		for(JsonNode node : peopleNode){
			int age = node.path(TAG_AGE).asInt();
			peopleAges.add(age);
		}
		return  peopleAges;
	}
}
