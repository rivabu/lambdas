package domain;

public class Track {

	public Track(int length, String name) {
		super();
		this.length = length;
		this.name = name;
	}
	private int length;
	private String name;
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return name + " " + length;
	}

}
