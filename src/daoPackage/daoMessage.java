package daoPackage;


import java.sql.Timestamp;
import logicPackage.PrivateMessage;

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
			pm.setReciver(reciver);
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
}
