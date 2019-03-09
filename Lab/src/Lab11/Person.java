package Lab11;

public class Person {
	private String name;
	private int born;
	private String country;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBorn() {
		return born;
	}
	public void setBorn(int born) {
		this.born = born;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Person(String name, int born, String country) {
		super();
		this.name = name;
		this.born = born;
		this.country = country;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", born=" + born + ", country="
				+ country + "]";
	}
	
	

}
