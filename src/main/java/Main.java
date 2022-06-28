import Interfaces.Parsable;
import json.GsonParser;
import json.JacksonParser;
import json.JsonPathParser;
import json.JsonSimpleParser;
import model.Root;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {


	public static void main(String[] args) throws FileNotFoundException {

		System.out.println("------------------------JsonSimpleParser-----------------------------------------");
		Parsable parser = new JsonSimpleParser();
		Root root = null;
		try {
			root = parser.parseJsonToJavaObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			parser.writeJavaObjectToJsonFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Root " + root.toString());

		try {
			List<String> peopleNames = parser.getListOfPeopleNames();
			System.out.println("People's names are: " + peopleNames);
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Integer> peopleAges = null;
		try {
			peopleAges = parser.getListOfPeopleAges();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("People's ages are: " + peopleAges);


		System.out.println("_________________________GsonParser_____________________________________________");

		Parsable gsonParser = new GsonParser();
		Root gsonRoot;
		try {
			// Read object 'Root' from json file and create Java object
			gsonRoot = gsonParser.parseJsonToJavaObject();
			System.out.println(gsonRoot.toString());
			// write Java object to json file
			gsonParser.writeJavaObjectToJsonFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<String> people = null;
		try {
			people = gsonParser.getListOfPeopleNames();
			System.out.println("People's names are: ");
			people.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}


		List<Integer> listOfAges = null;
		try {
			listOfAges = gsonParser.getListOfPeopleAges();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("People's ages are: ");
		listOfAges.forEach(System.out::println);

		System.out.println("------------------------------Jackson--------------------------------------------");

		Parsable jacksonParser = new JacksonParser();
		Root jacksonRoot = null;
		try {
			jacksonRoot = jacksonParser.parseJsonToJavaObject();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		try {
			jacksonParser.writeJavaObjectToJsonFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Root " + jacksonRoot.toString());
		try {
			List<String> peopleNames = jacksonParser.getListOfPeopleNames();
			System.out.println("People's names are: ");
			peopleNames.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			List<Integer> peopleAge = jacksonParser.getListOfPeopleAges();
			System.out.println("People's ages are: ");
			peopleAge.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}


		System.out.println("------------------------------JsonPath---------------------------------------------");

		String jsonPeople = "{\"name\":\"Written Json File\",\"people\":[{\"name\":\"Kate\",\"age\":30},{\"name\":\"Katerina\",\"age\":20}]}";
		JsonPathParser jsonPathParser = new JsonPathParser();
		System.out.println("people's names are: " + jsonPathParser.getPeopleNames(jsonPeople));
		System.out.println("people's ages are: " + jsonPathParser.getPeoplesAges(jsonPeople));
	}
}
