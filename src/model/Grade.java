package model;

public class Grade {
	private long gID;
	private int grValue;
	private Student student;
	private Course course;
	
	private static long counter = 200000;

	public long getgID() {
		return gID;
	}

	public int getValue() {
		return grValue;
	}

	public Student getStudent() {
		return student;
	}

	public Course getCourse() {
		return course;
	}

	public void setgID() {
		gID= counter;
		counter++;
	}

	public void setValue(int inputValue) {
		if (inputValue > 1 || inputValue <= 10) {
			grValue = inputValue;
		}else {
			grValue = 1;
		}
	}

	public void setStudent(Student inputStudent) {
		if(inputStudent != null) {
			student = inputStudent;
		}else {
			student = new Student();
		}
	}

	public void setCourse(Course inputCourse) {
		if(inputCourse != null) {
			course = inputCourse;
		}else {
			course = new Course();
		}
	}
	
	public Grade() {
		setgID();
		setValue(1);
		setStudent(student);
		setCourse(course);
	}
	
	public Grade(int value, Student student, Course course) {
		setgID();
		setValue(value);
		setStudent(student);
		setCourse(course);
	}
	
	@Override
	public String toString() {
		return gID + ": " + grValue + " - " + student.getName() + " " + student.getSurname() + ", " + course.getTitle();

	}
}
