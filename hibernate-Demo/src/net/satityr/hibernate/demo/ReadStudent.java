package net.satityr.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import net.satityr.hibernate.entity.Student;

public class ReadStudent {
		
		public static void main(String[] args) {

			// create session factory ; you can use configure() or
			// cofigure("hibernate.cfg.xml") (default xml)
			SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

			// create session
			Session session = factory.getCurrentSession();

			try {
				// use the session object to save Java object
				
				System.out.println("retrieving a student object.");

				// start a transaction
				session.beginTransaction();

				// get the student object with id
				
				int id = 5;
				
				Student ninja = session.get(Student.class, id);
				
				System.out.println("Ninja : " + ninja);

				// commit transaction
				session.getTransaction().commit();
				System.out.println("done !");
			}

			finally {
				factory.close();
			}

	}

}
