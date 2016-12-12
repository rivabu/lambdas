package domain;

public class Artist {
	public Artist(String name, String city, int age, String nationality) {
		super();
		this.name = name;
		this.city = city;
		this.age = age;
		this.nationality = nationality;
	}

	

	private String name;
	private String city;
	private int age;
	private String nationality;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFrom(String string) {
		// TODO Auto-generated method stub
		return string.equals(city);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


}
