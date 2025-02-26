package model;

public class Student extends Person{
	//mainigie
	private long stID;
	
	private static long counter = 0;
	
	//getters
	public long getStID() {
		return stID;
	}

	
	//setter
	
	public void setStID() {
		stID= counter;
		counter++;
		
	}
	
	//bez argumenta konstruktors
	
	public Student() {
		super(); // izsaukts bazes klases constructors
		setStID();
		setSurname("Students"); //izsaukta no bazes klases
			
	}
		
	// argumenta konstruktors
	public Student(String name, String surname) {
		super(name, surname);
		setStID();
		
	}
	
	//toString - parraksta object klases string funkciju
	@Override
	public String toString() {
		return stID + ": " +  super.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
