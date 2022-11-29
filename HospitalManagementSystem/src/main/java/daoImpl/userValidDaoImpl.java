package daoImpl;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Model.user;
import config.HibernateUtil;
import dao.userValidDao;
import exception.GlobalException;

public class userValidDaoImpl implements userValidDao{

	public user login(String username,String password) throws GlobalException{
			try(Session ses=HibernateUtil.getSession()){
			
			user u2=null;
			Query q =ses.createQuery("from user where userId=:username").setParameter("username", username);
			u2 = (user)q.uniqueResult();
			if(u2!=null)
			{
			if(u2.getUserPassword().equals(password)) {
				return u2;
			}
			else {
				throw new GlobalException("Wrong Username or Password....!!");
			}
			}
			else {
				throw new GlobalException("INVALID USERNAME...!!");
			}	
		}	
		
	}
	
}
