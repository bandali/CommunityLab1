package daoPackage;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import logicPackage.Friends;
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
	
	public User loginFillBean(String email,String password)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Query query = session
				.createQuery("FROM User WHERE email = :email AND password = :password");
		query.setParameter("email", email);
		query.setParameter("password", password);

		@SuppressWarnings("unchecked")
		List<User> l = query.list();
		
		return l.get(0);
	}

	public boolean register(String email, String password, String firstname, String lastname, String country)
	{
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
	
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
	
	public ArrayList<User> initFriendList(int UserId)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ArrayList<User> userFriends = new ArrayList<User>();
		try{ //createNativeQuery
			Query query = session.createQuery("From Friends as friend where friend.userId =:USERID");
			query.setParameter("USERID", UserId);	
			
			@SuppressWarnings("unchecked")
			List<Friends> friends = (List<Friends>)query.list();
			
			for (Friends friend : friends) {
				query = session.createQuery("From User as u Where u.idUser=:friendId");
				query.setParameter("friendId", friend.getFriendId());
				userFriends.add((User)query.uniqueResult());
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return userFriends;
	}
	
	
	
}
