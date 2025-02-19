package model;

public class Student {
	//mainigie
	private long stID;
	private String name;
	private String surname;
	
	//getters
	public long getStID() {
		return stID;
	}
	
	public String getName(){
		return name;
	}
	
	public String getSurname() {
		return surname;
	}

	
	//setter
	
	public void setStID(long inputStID) {
		stID= inputStID;
	}

	public void setName(String inputName) {
		if(inputName != null && inputName.isEmpty() && inputName.matches("[A-Z]{1}[a-z]{3,10}([ ][A-Z]{1}[a-z]{3,10})?")) {
			name = inputName;
		}
		
	}

	public void setSurname(String inputSurname) {
		surname = inputSurname;
	}
}
