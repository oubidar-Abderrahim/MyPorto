package net.satityr.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import net.satityr.hibernate.entity.Student;

public class DeleteStudent {

	public static void main(String[] args) {

		// create session factory ; you can use configure() or
		// cofigure("hibernate.cfg.xml") (default xml)
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();
			
			int id = 5;
			
			Student ninja = session.get(Student.class, id);
			
			System.out.println("Ninja : " + ninja);
			
			session.delete(ninja);
			
			// delete the uchiha's as query, Danzo's wish; Itachi's work
			session.createQuery("delete from Student s where s.lastName = 'Uchiha'").executeUpdate();

			// commit transaction
			session.getTransaction().commit();

			System.out.println("\ndone !");

		}

		finally {
			factory.close();
		}

	}

}
