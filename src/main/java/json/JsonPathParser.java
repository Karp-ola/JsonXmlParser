package json;

import com.jayway.jsonpath.JsonPath;
import java.util.List;

public class JsonPathParser{

	public List<String> getPeopleNames (String json) {
		List<String> listOfPeopleNames = JsonPath.read(json, "$.people[*].name");
		return listOfPeopleNames;
	}

	public List<Integer> getPeoplesAges (String json){
		List<Integer> listOfPeoplesAges = JsonPath.read(json, "$.people[*].age");
		return listOfPeoplesAges;
	}

}
