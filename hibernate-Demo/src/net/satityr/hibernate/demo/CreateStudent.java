package net.satityr.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import net.satityr.hibernate.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {

		// create session factory ; you can use configure() or
		// cofigure("hibernate.cfg.xml") (default xml)
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object
			// create a student object
			System.out.println("Creating a new student object.");
			Student tempStudent = new Student("Shikamaru", "Nara", "shiko.nara@konomail.jp");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student.");
			session.save(tempStudent);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("done !");
		}

		finally {
			factory.close();
		}

	}

}
