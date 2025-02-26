package model;

public class Person {
	
	//1.mainigie
	private String name;
	
	private String surname;
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setName(String inputName) {
		if(inputName != null 
				&& inputName.matches("[A-Z]{1}[a-z]{3,10}([ ][A-Z]{1}[a-z]{3,10})?")){
			name = inputName;
		}else {
			surname = "unknown";
		}
		
	}
	
	public void setSurname(String inputSurname) {
		if(inputSurname != null
				&& inputSurname.matches("[A-Z]{1}[a-z]{3,10}([-][A-Z]{1}[a-z]{3,10})?")) {
			surname = inputSurname;
		} else {
			surname = "unknown";
		}
	}
	
	public Person() {
		setName("Testa");
		setSurname("Persona");
	}
	
	public Person(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
	
	public String toString() {
		return name + " " + surname;
	}
	
}
