package in.suresh.dao;

import in.suresh.entity.Student;

public interface StudentDAO {

	public void saveStudent(Student std);
	
	public Student getStudentData(int sid);
	
	public Student updateStudent(int sid, int marks);
	
	public void deleteStudent(int sid);
	
	public void level1CacheTest();
	
}
