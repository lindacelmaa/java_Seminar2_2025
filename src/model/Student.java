package model;

public class Student {
	//mainigie
	private long stID;
	private String name;
	private String surname;
	
	private static long counter = 0;
	
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
	
	public void setStID(long stID) {
		stID= counter;
		counter++;
	}

	public void setName(String inputName) {
		if(inputName != null && inputName.isEmpty() && inputName.matches("[A-Z]{1}[a-z]{3,10}([ ][A-Z]{1}[a-z]{3,10})?")) {
			name = inputName;
		}else {
			surname = "unknown";
		}
		
		
	}

	public void setSurname(String inputSurname) {
		if(inputSurname != null && inputSurname.isEmpty() && inputSurname.matches("[A-Z]{1}[a-z]{3,10}([ ][A-Z]{1}[a-z]{3,10})?")) {
			surname = inputSurname;
		} else {
			surname = "unknown";
		}
		
	}
}
