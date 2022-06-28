# JsonXmlParser

This project was created for demonstration how to work with JSON in Java.
For this purpose were used such libraries as:
1) JsonSimple
2) Gson
3) Jackson
4) JsonPath


                                         JsonSimple
                                         
JsonSimple - library from Google.
Key concepts in this library are JSONObject, JSONArray.
JsonArray object can include several JsonObject objects. JsonObject can be used to retrieve individual properties. 
example:
JSONParser parser = new JSONParser();
FileReader reader = new FileReader(PATH_TO_JSON_TEST_FILE);
JSONObject rootObject = (JSONObject) parser.parse(reader);
String name = (String)rootObject.get(TAG_NAME_MAIN);
JSONArray peopleJsonArray = (JSONArray) rootObject.get(TAG_PEOPLE);


                                           Gson 
                                           
Gson provide simple toJson() and fromJson() methods to convert Java objects to / from JSON. 
As well as JsonSimple Gson uses JSONObject and JSONArray.   
2 ways to create Gson-object:
1) Gson gson = new Gson();
2) Gson gson = new GsonBuilder().setPrettyPrinting().create();
      Gson gson = new GsonBuilder()
			.excludeFieldsWithModifiers(Modifier.STATIC)
			.create();
      
    	Gson gson = new GsonBuilder()
			.excludeFieldsWithModifiers(Modifier.STATIC, Modifier.TRANSIENT)
			.create();
      
Custom field name with @SerializedName
      
      
      
                                            Jackson 
                                            
example:                                           
ObjectMapper objectMapper = new ObjectMapper();
User user = objectMapper.readValue(file, User.class);
objectMapper.writeValue(new File(PATH_TO_WRITTEN_PEOPLE_JACKSON_FILE), root);
JsonNode rootNode = objectMapper.readTree(new File(PATH_TO_JSON_TEST_FILE));
JsonNode peopleNode = rootNode.path(TAG_PEOPLE);



                                            JsonPath 
                                            
JsonPath is a query language for JSON, similar to XPath for XML. You start at the root node or element, 
represented by $, and reach the required element in the JSON structure to extract data from it. You can use 
either the dot-notation or the bracket-notation to form the expressions.
examples:
$.tool.jsonpath.creator.location[2]
$['tool']['jsonpath']['creator']['location'][2]
Object jsonPathValue = JsonPath.read(stringJson, "$.type");
List<String> listOfPeopleNames = JsonPath.read(stringJson, "$.people[*].name");



      
      




