package net.satityr.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import net.satityr.hibernate.entity.Student;

public class QueringStudent {

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
			List<Student> students = session.createQuery("from Student").getResultList(); // .List()
																							// was
																							// deprecated

			// display students
			displayStudents(students);

			// query students looking for uchiha's
			students = session.createQuery("from Student s where s.lastName='Uchiha'").getResultList();

			// display again
			System.out.println("\nStudents from Uchiha clan :\n");
			displayStudents(students);

			// query students looking for uchiha's and sinju's
			students = session
					.createQuery("from Student s where s.lastName='Uchiha' or s.lastName='Sinju' or s.lastName='Senju'")
					.getResultList();

			// display again
			System.out.println("\nStudents from Uchiha & Senju clan :\n");
			displayStudents(students);

			// query students looking for hokages
			students = session.createQuery("from Student s where s.email LIKE '%hokage@konomail.jp'").getResultList();

			// display again
			System.out.println("\nHokages :\n");
			displayStudents(students);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("\ndone !");
		}

		finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> students) {
		for (Student temp : students)
			System.out.println(temp);
	}

}
