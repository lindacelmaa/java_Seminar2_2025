package service;

import model.Student;

public class MainService {

	public static void main(String[] args) {
		Student  st1 = new Student();
		Student st2 = new Student("Linda", "Celma");
		
		System.out.println(st1);
		System.out.println(st2);
		
		Student st3 = new Student("Anna Paula", "Jauka-Nejauka");
		System.out.println(st3);
	}

}
