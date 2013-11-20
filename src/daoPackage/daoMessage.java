package daoPackage;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import logicPackage.Friends;
import logicPackage.PrivateMessage;
import logicPackage.User;
import logicPackage.WallMessages;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class daoMessage {

	public boolean sendPrivateMessage(int sender,int reciver, String message)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
	
		java.util.Date date= new java.util.Date();
		
		try
		{
			tx = session.beginTransaction();
			PrivateMessage pm = new PrivateMessage();
			pm.setSender(sender);
			pm.setReciever(reciver);
			pm.setPrivateMessage(message);
			pm.setDatasent(new Timestamp(date.getTime()));
			session.save(pm);
			
			session.getTransaction().commit();
			return true;
		}
		
		catch(Exception e) 
		{
			System.out.println(e);
			if(tx!=null) tx.rollback(); 
			return false;
		}
		finally {
			session.close();
		}
	}
		
	@SuppressWarnings("unchecked")
	public List<PrivateMessage> getPrivateMessages(int userId){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		List<PrivateMessage> privateMessage = new LinkedList<PrivateMessage>();
		try{ 
			Query query = session.createQuery("From PrivateMessage as pm where pm.reciever=:USERID");
			query.setParameter("USERID", userId);	
			privateMessage = query.list();	
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		finally
		{
			session.close();
		}
		return privateMessage;
	}	
	
	@SuppressWarnings("unchecked")
	public List<WallMessages> getWallMessageForUser(int id)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		List<WallMessages> WallMessages = new LinkedList<WallMessages>();
		try{
			Query query = session.createQuery("From WallMessages as wm where wm.reciever=:USERID");
			query.setParameter("USERID", id);
			WallMessages = query.list();
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		finally
		{
			session.close();
		}
		return WallMessages;
	}
	
	public boolean sendWallMessage(int sender,int reciver, String message)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
	
		java.util.Date date= new java.util.Date();
		
		try
		{
			tx = session.beginTransaction();
			WallMessages pm = new WallMessages();
			pm.setSender(sender);
			pm.setReciever(reciver);
			pm.setWallMessages(message);
			pm.setDatasent(new Timestamp(date.getTime()));
			session.save(pm);
			
			session.getTransaction().commit();
			return true;
		}
		
		catch(Exception e) 
		{
			System.out.println(e);
			if(tx!=null) tx.rollback(); 
			return false;
		}
		finally {
			session.close();
		}
	}
}