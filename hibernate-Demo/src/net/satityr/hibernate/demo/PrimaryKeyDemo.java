package net.satityr.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import net.satityr.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		
		// create session factory ; you can use configure() or
				// cofigure("hibernate.cfg.xml") (default xml)
				SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

				// create session
				Session session = factory.getCurrentSession();

				try {
					// use the session object to save Java object
					// create 3 student objects
					System.out.println("Creating a new student object.");
					Student tempStudent1 = new Student("Hashirama", "Sinju", "first.hokage@konomail.jp");
					Student tempStudent2 = new Student("Sasuke", "Uchiha", "sasuke.ushiha@konomail.jp");
					Student tempStudent3 = new Student("Killer", "Bee", "killer.bee@kumomail.jp");

					// start a transaction
					session.beginTransaction();

					// save the student object
					System.out.println("Saving the students.");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);

					// commit transaction
					session.getTransaction().commit();
					System.out.println("Done!");
				}

				finally {
					factory.close();
				}

	}

}
