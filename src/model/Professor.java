package model;

public class Professor{
	//mainigie
	private long profID;
	private String profName;
	private String profSurname;
	private Degree degree;
	
	
	private static long counter = 10000;
	
	//getters
	public long getProfID() {
		return profID;
	}
	
	public String getProfName(){
		return profName;
	}
	
	public String getProfSurname() {
		return profSurname;
	}
	
	public Degree getDegree() {
		return degree;
	}

	
	//setter
	
	public void setProfID() {
		profID= counter;
		counter++;
	}

	public void setProfName(String inputName) {
		if(inputName != null 
				&& inputName.matches("[A-Z]{1}[a-z]{3,10}([ ][A-Z]{1}[a-z]{3,10})?")){
			profName = inputName;
		}else {
			profName = "unknown";
		}
		
		
	}

	public void setProfSurname(String inputSurname) {
		if(inputSurname != null
				&& inputSurname.matches("[A-Z]{1}[a-z]{3,10}([-][A-Z]{1}[a-z]{3,10})?")) {
			profSurname = inputSurname;
		} else {
			profSurname = "unknown";
		}
		
	}
	
	public void setDegree(Degree inputDegree) {
		if(inputDegree != null) {
			degree = inputDegree;
		}else {
			degree = Degree.unknown;
		}
	}
	
	//bez argumenta konstruktors
	
	public Professor() {
		setProfID();
		setProfName("Testa");
		setProfSurname("Profesors");
		setDegree(Degree.Isc);
			
	}
		
	// argumenta konstruktors
	public Professor(String name, String surname, Degree degree) {
		setProfID();
		setProfName(name);
		setProfSurname(surname);
		setDegree(degree);
		
	}
	
	//toString - parraksta object klases string funkciju
	@Override
	public String toString() {
		return profID + ": " + profName + " " + profSurname + ", " + degree;
	}
	
	
}
	
	
	