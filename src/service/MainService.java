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
			createProfessor("Raita", "Rollande", Degree.dr);
			createProfessor("Juris", "Zagrs", Degree.dr);
			System.out.println("10001 profesors:" + retrieveProfessorById(10001).getSurname());
			
			updateProfessorById(10001, "Janis", "Ozolins", Degree.dr);
			deleteProfessorById(10000);
			System.out.println(allProfessors);
			
			System.out.println("Profesori ar dr, gradu" + filterProfessorByDegree(Degree.dr));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(allProfessors);
		
		System.out.println("");
		
		Course cr1 = new Course();
			Course cr2 = new Course("Programmesana", 3, pr2);
			Course cr3 = new Course("Matematika", 2, pr2 );
			Course cr4 = new Course("Haoss", 2, pr1 );
		
		try {
			//System.out.println(cr1);
			//System.out.println(cr2);
		
			allCourses.addAll(Arrays.asList(cr1, cr2, cr3, cr4));
			System.out.println("Otraa profesora kursu skaits: " + courseCount(10001));
			System.out.println(allCourses);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("");
		
		try {
			Grade gr1 = new Grade();
			Grade gr2 = new Grade(8, st2, cr2);
			Grade gr3 = new Grade(5, st2, cr1);
			//System.out.println(gr1);
			//System.out.println(gr2);
		
			allGrades.addAll(Arrays.asList(gr1, gr2, gr3));
			
			System.out.println("Lindas videja atzime: " + averageGrade(1));
			System.out.println(allGrades);
			System.out.println(badMarks());
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(allGrades);
		
		
	}
	
	//CRUD
	//C-create
	public static void createProfessor(String name, String surname, Degree degree) throws Exception{
		//parbauda vai eksiste
		for(Professor tempP : allProfessors) {
			if(tempP.getName().equals(name)
				&& tempP.getSurname().equals(surname)
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
	
	public static void updateProfessorById(int id, String inputName, String inputSurname, Degree inputDegree) throws Exception {
		Professor foundProfessor = retrieveProfessorById(id);
		
		if(inputName != null && !foundProfessor.getName().equals(inputName)) {
			foundProfessor.setName(inputName);
		} if(inputSurname != null && !foundProfessor.getSurname().equals(inputSurname)) {
			foundProfessor.setSurname(inputSurname);
			
		} if(inputDegree != null && !foundProfessor.getDegree().equals(inputDegree)) {
			foundProfessor.setDegree(inputDegree);
		}
		
		
	}
	
	public static void deleteProfessorById(int id) throws Exception{
		
		Professor foundProfessor = retrieveProfessorById(id);
		
		allProfessors.remove(foundProfessor);
		
	}

	public static ArrayList<Professor> filterProfessorByDegree(Degree inputDegree) throws Exception{
		if(inputDegree == null) {
			throw new Exception("Nav pareiziievaditi dati");
		}
		
		ArrayList<Professor> results = new ArrayList<Professor>();
		
		for(Professor tempP : allProfessors) {
			if(tempP.getDegree().equals(inputDegree)) {
				results.add(tempP);
			}
		}
		
		return results;
	} 
	
	
	
	public static Student retrieveStudentById(int id) throws Exception {
		if(id < 0) {
			throw new Exception("ID nevar b'ut negativs");
		}
		
		for(Student tempP : allStudents) {
			if(tempP.getStID() == id){
				return tempP;
			}
		}
		
		throw new Exception("Students ar noradito id neeksistee");
	}
	
	public static float averageGrade(int id) throws Exception{
		Student foundStudent = retrieveStudentById(id);
		
		int gradesCount = 0;
		float sum = 0;
		
		for(Grade tempG : allGrades) {
			if(tempG.getStudent().getStID() == id) {
				gradesCount++;
				sum += tempG.getValue();
				
			}
		}
		
		
		if(gradesCount == 0) {
			throw new Exception("Studentam nav neviena atz'ime");
		}
		
		return sum / gradesCount;
	}
		
	public static float averageWeightedGrade(int id) throws Exception{
		
		Student foundStudent = retrieveStudentById(id);
		
		int cpTimesGradeSum = 0;
		float CPsum = 0;
		
		for(Grade tempG : allGrades) {
			if(tempG.getStudent().getStID() == id) {
				float grade = tempG.getValue();
				float creditPoints = tempG.getCourse().getCreditPoints();
				cpTimesGradeSum += grade * creditPoints;
				CPsum += creditPoints;
			}
		}
		
		if (CPsum == 0) {
			throw new Exception("Studentam nav neviena atzīme");
			
		}
		
		return cpTimesGradeSum/CPsum;
	}
		
	
	public static int courseCount(int id) throws Exception{
		Professor foundProfessor = retrieveProfessorById(id);
		
		int count = 0;
		
		for (Course tempC : allCourses) {
			if (tempC.getProfessor().getProfID() == id) {
				count++;
			}
		}
		if(count == 0) {
			throw new Exception("Pasniedzejam nav kursu");
		}
		return count;
	}
	

	//saskaita, cik ir kursi pie noteikta CP skaita
	
	public static ArrayList<Grade> badMarks(){
		ArrayList<Grade> results = new ArrayList<Grade>();
		
		for(Grade tempG: allGrades) {
			if(tempG.getValue() < 4)
			{
				results.add(tempG);
			}
		}
		
		return results;
		
	}
	
	
	public static int courseCountByCreditPoints (int creditPointCount) throws Exception {
		
		int count = 0;
		
		for (Course tempC : allCourses) {
			if(tempC.getCreditPoints() == creditPointCount) {
				count++;
			}
		}
		if (count == 0 ) {
			throw new Exception("Nevienam kursam nav šāds kredītpunktu skaits");
		}
		return count;
	}
	
	public static Course retrieveCoursetById(int id) throws Exception {
		if(id < 0) {
			throw new Exception("ID nevar b'ut negativs");
		}
		
		for(Course tempC : allCourses) {
			if(tempC.getcID() == id){
				return tempC;
			}
		}
		
		throw new Exception("Kurss ar noradito id neeksistee");
	}
	
	public static float averageGradeForCourse(int id) throws Exception{
		Course foundCourse = retrieveCoursetById(id);
		
		int gradesCount = 0;
		float sum = 0;
		
		for(Grade tempG : allGrades) {
			if(tempG.getCourse().getcID() == id) {
				gradesCount++;
				sum += tempG.getValue();
				
			}
		}
		
		
		if(gradesCount == 0) {
			throw new Exception("Kursā nav neviena atz'ime");
		}
		
		return sum / gradesCount;
	}
	
	//jasakarto pec vid atz
	
}















