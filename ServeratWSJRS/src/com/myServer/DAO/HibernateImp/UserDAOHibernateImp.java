package com.myServer.DAO.HibernateImp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.myServer.DAO.UserDAO;
import com.myServer.entities.User;

public class UserDAOHibernateImp implements UserDAO {
	
	private SessionFactory factory ;
	private Session session = null;

	public UserDAOHibernateImp() {
		super();
		this.factory = new Configuration().configure()
				.addAnnotatedClass(User.class).buildSessionFactory();
	}
	
	
	
	@Override
	public void initFactory(){
		this.factory = new Configuration().configure()
			.addAnnotatedClass(User.class).buildSessionFactory();
		this.session = factory.getCurrentSession();
	}
	
	@Override
	public void closeFactory(){
		session.close();
		factory.close();
	}
	

	@Override
	public boolean add(User u) {
		
		boolean status = false;
		
		try {

			// start a transaction
			session.beginTransaction();

			// save the student object
			session.save(u);

			// commit transaction
			session.getTransaction().commit();

			status = true;
		}

		catch (Exception e) {

			status = false;

		}
		
		return status;
	}

	@Override
	public boolean update(User u) {

		boolean status = false;

		try {

			// start a transaction
			session.beginTransaction();

			// save the student object
			session.saveOrUpdate(u);

			// commit transaction
			session.getTransaction().commit();

			status = true;
		}

		catch (Exception e) {

			status = false;

		}
		return status;
	}

	@Override
	public User findByUsername(String userName) {

		User user = null;

		try {

			// start a transaction
			session.beginTransaction();

			user = (User) session.createQuery(
					"from User u where u.userName='" + userName + "'")
					.uniqueResult();

			// commit transaction
			session.getTransaction().commit();

		}

		finally {
		}

		return user;
	}

	@Override
	public User findByEmail(String email) {
		

		User user = null;

		try {

			// start a transaction
			session.beginTransaction();

			user = (User) session.createQuery(
					"from User u where u.email='" + email + "'").uniqueResult();

			// commit transaction
			session.getTransaction().commit();

		}

		finally {
		}

		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {

		List<User> users = null;

		try {

			// start a transaction
			session.beginTransaction();

			users = session.createQuery("from User").getResultList();

			// commit transaction
			session.getTransaction().commit();

		}

		finally {
		}

		return users;
	}

	@Override
	public User findByID(int id) {

		User user = null;

		try {

			// start a transaction
			session.beginTransaction();

			user = session.get(User.class, id);

			// commit transaction
			session.getTransaction().commit();

		}

		finally {
		}

		return user;

	}

	@Override
	public User findForAuthen(String userName, String password) {

		
		User user = null;

		try {

			// start a transaction
			session.beginTransaction();

			user = (User) session.createQuery(
					"from User u where u.userName='" + userName
							+ "' and u.password='" + password + "'")
					.uniqueResult();

			// commit transaction
			session.getTransaction().commit();

		}

		finally {
		}

		return user;
	}

	@Override
	public boolean delete(User u) {
		
		
		boolean status = false;

		try {

			// start a transaction
			session.beginTransaction();

			// save the student object
			session.delete(u);

			// commit transaction
			session.getTransaction().commit();

			status = true;
		}

		catch (Exception e) {

			status = false;

		}

		finally {
		}

		return status;
	}

}
