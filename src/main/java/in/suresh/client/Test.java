package in.suresh.client;

import in.suresh.dao.StudentDAO;
import in.suresh.dao.impl.StudentDAOImpl;
import in.suresh.entity.Student;

public class Test {

	public static void main(String[] args) {
		StudentDAO dao = new StudentDAOImpl();

		// Create Student object

		/*
		 * Student s1 = new Student(101, "Suresh", "Male", 600); Student s2 = new
		 * Student(102, "Rahul", "Male", 550); Student s3 = new Student(103, "Ramya",
		 * "Fe-Male", 500); Student s4 = new Student(104, "Shanvy", "Fe-Male", 570);
		 * 
		 * dao.saveStudent(s1);
		 */

		// To select the data

		/*
		 * Student student = dao.getStudentData(103); System.out.println(student);
		 */

		/*
		Student updateStudent = dao.updateStudent(101, 300);
		System.out.println(updateStudent);
		*/
		
		//dao.deleteStudent(101);
		
		
		dao.level1CacheTest();
	}
}
