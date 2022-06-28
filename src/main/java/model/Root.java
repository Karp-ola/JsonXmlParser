package model;

import java.util.List;

public class Root {

	private String name;
	private List<People> people;

	public Root() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<People> getPeople() {
		return people;
	}

	public void setPeopleList(List<People> people) {
		this.people = people;
	}

	@Override
	public String toString() {
		return "Root{" +
				"name='" + name + '\'' +
				", peopleList=" + people +
				'}';
	}
}
