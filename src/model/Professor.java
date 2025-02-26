package model;

public class Professor extends Person{
	//mainigie
	private long profID;
	private Degree degree;
	
	
	private static long counter = 10000;
	
	//getters
	public long getProfID() {
		return profID;
	}
	
	
	public Degree getDegree() {
		return degree;
	}

	
	//setter
	
	public void setProfID() {
		profID= counter;
		counter++;
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
		super();
		setProfID();
		setDegree(Degree.Isc);
			
	}
		
	// argumenta konstruktors
	public Professor(String name, String surname, Degree degree) {
		super(name, surname);
		setProfID();
		setDegree(degree);
		
	}
	
	//toString - parraksta object klases string funkciju
	@Override
	public String toString() {
		return profID + ": " + super.toString() + ", " + degree;
	}
	
	
}
	
	
	