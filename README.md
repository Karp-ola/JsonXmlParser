# JsonXmlParser

This project was created to demonstrate how to work with JSON in Java.<br/>
For this purpose were used such libraries as:<br/>
1) JsonSimple<br/>
2) Gson<br/>
3) Jackson<br/>
4) JsonPath<br/>


                                         JsonSimple
                                         
JsonSimple - library from Google.<br/>
Key concepts in this library are JSONObject, JSONArray.<br/>
JsonArray object can include several JsonObject objects. JsonObject can be used to retrieve individual properties. <br/>
example:<br/>
JSONParser parser = new JSONParser();<br/>
FileReader reader = new FileReader(PATH_TO_JSON_TEST_FILE);<br/>
JSONObject rootObject = (JSONObject) parser.parse(reader);<br/>
String name = (String)rootObject.get(TAG_NAME_MAIN);<br/>
JSONArray peopleJsonArray = (JSONArray) rootObject.get(TAG_PEOPLE);<br/>
<br/>

                                           Gson 
                                           
Gson provide simple toJson() and fromJson() methods to convert Java objects to / from JSON. <br/>
As well as JsonSimple Gson uses JSONObject and JSONArray.  <br/> 
2 ways to create Gson-object:<br/>
1) Gson gson = new Gson();<br/>
2) Gson gson = new GsonBuilder().setPrettyPrinting().create();<br/>
      Gson gson = new GsonBuilder()<br/>
			.excludeFieldsWithModifiers(Modifier.STATIC)<br/>
			.create();<br/>
      <br/>
    	Gson gson = new GsonBuilder()<br/>
			.excludeFieldsWithModifiers(Modifier.STATIC, Modifier.TRANSIENT)<br/>
			.create();<br/>
<br/>
Custom field name with @SerializedName<br/>
<br/>
      
      
                                            Jackson 
                                            
example:                                           
ObjectMapper objectMapper = new ObjectMapper();<br/>
User user = objectMapper.readValue(file, User.class);<br/>
objectMapper.writeValue(new File(PATH_TO_WRITTEN_PEOPLE_JACKSON_FILE), root);<br/>
JsonNode rootNode = objectMapper.readTree(new File(PATH_TO_JSON_TEST_FILE));<br/>
JsonNode peopleNode = rootNode.path(TAG_PEOPLE);<br/>



                                            JsonPath 
                                            
JsonPath is a query language for JSON, similar to XPath for XML. You start at the root node or element, <br/>
represented by $, and reach the required element in the JSON structure to extract data from it. You can use <br/>
either the dot-notation or the bracket-notation to form the expressions.<br/>
examples:<br/>
$.tool.jsonpath.creator.location[2]<br/>
$['tool']['jsonpath']['creator']['location'][2]<br/>
Object jsonPathValue = JsonPath.read(stringJson, "$.type");<br/>
List<String> listOfPeopleNames = JsonPath.read(stringJson, "$.people[*].name");<br/>



      
      




