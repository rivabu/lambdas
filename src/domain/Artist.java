package domain;

public class Artist {

	public Artist(String name, String from, int age) {
		super();
		this.setName(name);
		this.from = from;
		this.setAge(age);
	}

	private String from;
	private String name;
	private int age;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	
	public boolean isFrom(String from) {
		return this.from.equals(from);
	}

	public String getName() {
		return name;
	}

	public String setName(String name) {
		this.name = name;
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return name + " " + from  + " " + age;
	}
}
