package utils;

import model.People;
import model.Root;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GenerateData {

	public  static Root createRootObject(){

		Root root = new Root();
		List<People> peopleList = new ArrayList<>();
		People person1 = new People(30, "Kate");
		peopleList.add(person1);
		People people2 = new People(20, "Katerina");
		peopleList.add(people2);

		root.setName("File created with GSON");
		root.setPeopleList(peopleList);
		return root;
	}

	public static JSONObject createJsonObject(){

		JSONObject resultJson = new JSONObject();
		// create first person
		People person1 = new People(30, "Kate");
		JSONObject personObject = new JSONObject();
		personObject.put("name", person1.getName());
		personObject.put("age", person1.getAge());
		//create second person
		People person2 = new People(20, "Katerina");
		JSONObject personObject2 = new JSONObject();
		personObject2.put("name", person2.getName());
		personObject2.put("age", person2.getAge());
		//add people to list
		JSONArray peopleList = new JSONArray();
		peopleList.add(personObject);
		peopleList.add(personObject2);
		//add data to resultJson
		resultJson.put("name", "Written Json File");
		resultJson.put("people", peopleList);
		return  resultJson;
	}

}
