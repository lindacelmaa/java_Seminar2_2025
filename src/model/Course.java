package model;

import model.Professor;

public class Course {
	private long cID;
	private String title;
	private int creditPoints;
	Professor professor;
	
	private static long counter = 100000;

	public long getcID() {
		return cID;
	}

	public String getTitle() {
		return title;
	}

	public int getCreditPoints() {
		return creditPoints;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setcID() {
		cID= counter;
		counter++;
	}

	public void setTitle(String inputTitle) {
		if(inputTitle != null 
				&& inputTitle.matches("[A-Za-z]{3,20}([ ][A-Za-z]{3,20})?")){
			title = inputTitle;
		}else {
			title = "unknown";
		}
	}

	public void setCreditPoints(int inputCreditPoints) {
		if(inputCreditPoints > 0 && inputCreditPoints <=30)
		{
			creditPoints = inputCreditPoints;
		}else {
			creditPoints = 3;
		}
	}

	public void setProfessor(Professor inputProfessor) {
		if(inputProfessor != null) {
			professor = inputProfessor;
		}else {
			professor = new Professor();
		}
	}
	
	public Course() {
		setcID();
		setTitle("Testa kurss");
		setCreditPoints(1);
		setProfessor(new Professor());
		
	}
	
	public Course(String title, int creditPoints, Professor professor) {
		setcID();
		setTitle(title);
		setCreditPoints(creditPoints);
		setProfessor(professor);
	}
	
	@Override
	public String toString() {
		return cID + ": " + title + "; credit points - " + creditPoints + "; professor - " + professor.getName().charAt(0) + ". " + professor.getSurname();
	}
	
	
}
