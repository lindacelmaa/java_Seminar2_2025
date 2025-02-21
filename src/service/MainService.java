package service;

import model.Student;
import model.Degree;
import model.Professor;
import model.Course;
import model.Grade;
import java.util.ArrayList;
import java.util.Arrays;

public class MainService {
	
	
	private static ArrayList<Student> allStudents = new ArrayList<Student>();
	private static ArrayList<Professor> allProfessors = new ArrayList<Professor>();
	private static ArrayList<Course> allCourses= new ArrayList<Course>();
	private static ArrayList<Grade> allGrades = new ArrayList<Grade>();
	
	
	

	public static void main(String[] args) {
		Student  st1 = new Student();
		Student st2 = new Student("Linda", "Celma");
		
		//System.out.println(st1);
		//System.out.println(st2);
		
		Student st3 = new Student("Anna Paula", "Jauka-Nejauka");
		//System.out.println(st3);
		
		
		allStudents.addAll(Arrays.asList(st1, st2, st3));
		System.out.println(allStudents);
		
		
		System.out.println("");
		
		Professor pr1 = new Professor();
		Professor pr2 = new Professor("Janis", "Berzins", Degree.Isc);
		//System.out.println(pr1);
		//System.out.println(pr2);
		
		allProfessors.addAll(Arrays.asList(pr1, pr2));
		
		try{
			//createProfessor("Karlis", "Immers", Degree.mg);
			createProfessor("Karlis", "Immers", Degree.mg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(allProfessors);
		
		System.out.println("");
		
		Course cr1 = new Course();
		Course cr2 = new Course("Programmesana", 3, pr2);
		
		//System.out.println(cr1);
		//System.out.println(cr2);
		
		allCourses.addAll(Arrays.asList(cr1, cr2));
		System.out.println(allCourses);
		
		System.out.println("");
		Grade gr1 = new Grade();
		Grade gr2 = new Grade(8, st2, cr2);
		//System.out.println(gr1);
		//System.out.println(gr2);
		
		allGrades.addAll(Arrays.asList(gr1, gr2));
		System.out.println(allGrades);
		
		
	}
	
	//CRUD
	//C-create
	public static void createProfessor(String name, String surname, Degree degree) throws Exception{
		//parbauda vai eksiste
		for(Professor tempP : allProfessors) {
			if(tempP.getProfName().equals(name)
				&& tempP.getProfSurname().equals(surname)
				&& tempP.getDegree().equals(degree)) {
				throw new Exception("Profesors jau eksiste");
			}
		}
		
		allProfessors.add(new Professor(name, surname, degree));
	}
	
	//r = retrieve
	
	public static Professor retrieveProfessorById(int id) throws Exception {
		if(id < 0) {
			throw new Exception("ID nevar b'ut negativs");
		}
		
		for(Professor tempP : allProfessors) {
			if(tempP.getProfID() == id){
				return tempP;
			}
		}
		
		throw new Exception("Profesors ar noradito id neeksistee");
	}
	
	

}















