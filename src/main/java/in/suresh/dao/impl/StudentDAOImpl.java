package in.suresh.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.suresh.dao.StudentDAO;
import in.suresh.entity.Student;

public class StudentDAOImpl implements StudentDAO {

	SessionFactory factory;

	public StudentDAOImpl() {

		/*
		 * ServiceRegistry registry = new
		 * StandardServiceRegistryBuilder().configure().build(); Metadata metadata = new
		 * MetadataSources(registry).buildMetadata(); factory =
		 * metadata.getSessionFactoryBuilder().build();
		 */

		Configuration configure = new Configuration().configure();

		factory = configure.buildSessionFactory();
	}

	@Override
	public void saveStudent(Student std) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(std);
			System.out.println("Student object is persisted in database");
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			System.out.println("Issue in persistung object ...");
			System.out.println(e);
		} finally {
			session.close();
			factory.close();
		}
	}

	@Override
	public Student getStudentData(int sid) {

		/*
		 * load() : lazy loading get() : early loading args: 1. classname.class 2. id
		 * value
		 */

		Session session = factory.openSession();
		Student student = session.load(Student.class, sid);

		try {
			Thread.sleep(20000);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(student.getSname());
		session.close();

		return student;

	}

	@Override
	public Student updateStudent(int sid, int marks) {

		Session session = factory.openSession();
		Student student = session.get(Student.class, sid);
		Transaction t = session.beginTransaction();
		try {
			student.setMarks(marks);
			session.update(student);
			t.commit();
			System.out.println("Object is updated");
		} catch (Exception e) {
			t.rollback();
			System.out.println("Object is not updated");
		} finally {
			session.close();
		}

		return student;
	}

	@Override
	public void deleteStudent(int sid) {
		Session session = factory.openSession();
		Student student = session.get(Student.class, sid);
		Transaction t = session.beginTransaction();
		try {
			session.delete(student);
			System.out.println("object is deleted.....");
			t.commit();
		} catch (Exception e) {
			t.rollback();
			System.out.println("object is not deleted....");
		} finally {
			session.close();
		}

	}

	@Override
	public void level1CacheTest() {
		Session session = factory.openSession();
		Session another_session = factory.openSession();

		Student s1 = session.get(Student.class, 101);  
		//session.evict(s1);
		Student s2 = session.get(Student.class, 102);
		session.clear();
		Student s3 = session.get(Student.class, 101);
		Student s4 = another_session.get(Student.class, 101);
		session.close();
		another_session.close();

	}
}
