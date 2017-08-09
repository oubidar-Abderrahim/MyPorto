package net.satityr.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import net.satityr.hibernate.entity.Student;

public class UpdateStudent {

	public static void main(String[] args) {

		// create session factory ; you can use configure() or
		// cofigure("hibernate.cfg.xml") (default xml)
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query students
			List<Student> students = session.createQuery("from Student s where s.lastName='Sinju'").getResultList();

			for (Student temp : students)
				temp.setLastName("Senju");

			// commit transaction
			session.getTransaction().commit();

			// new transaction

			 session = factory.getCurrentSession();
			 session.beginTransaction();
			 session.createQuery("update Student s set email='itachi.uchiha@akatsuki.jp' where s.firstName='Itachi'").executeUpdate();
			 session.getTransaction().commit();

			System.out.println("\ndone !");

		}

		finally {
			factory.close();
		}

	}

}
