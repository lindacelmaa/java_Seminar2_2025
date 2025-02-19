package service;

import model.Student;
import model.Degree;
import model.Professor;

public class MainService {

	public static void main(String[] args) {
		Student  st1 = new Student();
		Student st2 = new Student("Linda", "Celma");
		
		System.out.println(st1);
		System.out.println(st2);
		
		Student st3 = new Student("Anna Paula", "Jauka-Nejauka");
		System.out.println(st3);
		
		System.out.println("");
		
		Professor pr1 = new Professor();
		Professor pr2 = new Professor("Janis", "Berzins", Degree.Isc);
		System.out.println(pr1);
		System.out.println(pr2);
		
		
		
	}

}
