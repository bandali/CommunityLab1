package daoPackage;

import java.util.List;

import logicPackage.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class daoUser {

	public boolean login(String email, String password) {
		boolean answer = false;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Query query = session
				.createQuery("FROM User WHERE email = :email AND password = :password");
		query.setParameter("email", email);
		query.setParameter("password", password);

		@SuppressWarnings("unchecked")
		List<User> l = query.list();

		if (l.get(0).getEmail().compareTo(email) == 0
				&& l.get(0).getPassword().compareTo(password) == 0) {
			answer = true;
		}

		return answer;
	}

	public boolean register(String email, String password, String firstname, String lastname, String country)
	{
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		
//		Query query = session.createQuery("FROM User WHERE email = :email AND password = :password");
//		query.setParameter("email", email);
//		query.setParameter("password", password);
//		query.setParameter("firstname", firstname);
//		query.setParameter("lastname", lastname);
//		query.setParameter("lastname", lastname);
		try
			{
			
			tx = session.beginTransaction();
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setCountry(country);
			
			session.save(user);
			
			session.getTransaction().commit();
			return true;
			}
		catch(Exception e) 
			{
				if(tx!=null) tx.rollback(); 
				return false;
			}
		finally {
		session.close();
		}
		
		
	}
}
