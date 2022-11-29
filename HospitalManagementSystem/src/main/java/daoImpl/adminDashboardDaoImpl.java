package daoImpl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import Model.Patient;
import Model.user;
import config.HibernateUtil;
import dao.adminDashboardDao;
import exception.GlobalException;

public class adminDashboardDaoImpl implements adminDashboardDao {
	
	@Override
	public int createDoctor(user d1) throws GlobalException{
		
		try(Session session = HibernateUtil.getSession()){
			
			session.beginTransaction();
			String uId = d1.getUserId();
			user d2 = null;
			
			
			d2=(user)session.createQuery("from user where userId=:uId").setParameter("uId", uId).uniqueResult();
			
			if(d2==null)
			{
				session.save(d1);
				
				session.getTransaction().commit();
				session.close();
				return 1;
			}
			else {
				throw new GlobalException("Doctor is already existed Please enter a different Doctor UserId name ");
			}
		}
		
	}
	@Override
	public int createRecep(user recep)
	{
		try(Session session = HibernateUtil.getSession())
		{
			session.beginTransaction();
			session.save(recep);
			session.getTransaction().commit();
			session.close();
			return 1;
		}
	}
	
	public int createPatient(Patient u1) throws GlobalException{
			try(Session session = HibernateUtil.getSession()){
			
			session.beginTransaction();
			String fName = u1.getDoctorFirstName();
			String lName = u1.getDoctorLastName();
			String phoneNumber = u1.getPhoneNumber();
			String pFName = u1.getFirstName();
			user d1 = null;
			d1=(user)session.createQuery("from user where lower(firstName)=:fName and lower(lastName)=:lName and phoneNumber=:phoneNumber and lower(firstName)=:pFName").setParameter("fName", fName.toLowerCase()).setParameter("lName",lName.toLowerCase()).setParameter("phoneNumber",phoneNumber).setParameter("pFName",pFName.toLowerCase()).uniqueResult();
			
			if(d1!=null)
			{
				u1.setDoctor(d1);
				session.save(u1);
				session.close();
			}
			else {
				throw new GlobalException("Entered Doctor name is wrong or not present in the doctor list check and enter again\n Or Patient First name with combination of same mobile number exists already\nTry to edit patient");
			}
		}
		
		return 1;
	}
	
	@Override
	public List<user> viewDoctor(){
		
			try(Session ses=HibernateUtil.getSession()){
			
			Query qu=ses.createQuery("from user where userRollCode=2");
			List<user> roomList=qu.getResultList();
			ses.close();
			return roomList;
		
	}

	}
	
	@Override
	public user viewRecep() {
		try(Session ses=HibernateUtil.getSession()){
			
			user recep =(user)ses.createQuery("from user where userRollCode=3").uniqueResult();
			
			ses.close();
			return recep;
		
	}
	}
	
	@Override
	public boolean exist() {
		
		try(Session ses = HibernateUtil.getSession()){
			
			ses.beginTransaction();
			
			user recep = null;
			
			recep = (user)ses.createQuery("from user where userRollCode=3").uniqueResult();
			ses.close();
			if(recep!=null)
				return true;
			else
				return false;
				
			}
	}
	
	@Override
	public boolean isPatientExist(int id) {
		
		try(Session ses = HibernateUtil.getSession()){
			
			ses.beginTransaction();
			
			Patient pa = null;
			
			pa = (Patient)ses.createQuery("from Patient where PatientId=:id").setParameter("id", id).uniqueResult();
			ses.close();
			if(pa!=null)
				return true;
			else
				return false;
				
			}
	}
	
	@Override
	public int updatePatient(String newAD,String newTime,int id) throws GlobalException{
		
		try(Session session = HibernateUtil.getSession()){
				
			session.beginTransaction();
			int status=session.createQuery("update Patient as p set appointmentDate=:newAD , time=:newTime where PatientId=:id").setParameter("newAD", newAD).setParameter("newTime", newTime).setParameter("id", id).executeUpdate();
			session.getTransaction().commit();
			session.close();
			return status;
		}
	}
	
	@Override
	public List<Patient> viewPatient(){
		try(Session ses=HibernateUtil.getSession()){
			
			Query qu=ses.createQuery("from Patient");
			List<Patient> paList=qu.getResultList();
			ses.close();
			return paList;
		}
		}
	
	@Override
	public int deleteDoctor(String dId) throws GlobalException{
		
		try(Session ses=HibernateUtil.getSession()){
			
			ses.beginTransaction();
			int status=ses.createQuery("delete from user where userid=:dId").setParameter("dId", dId).executeUpdate();
			ses.getTransaction().commit();
			ses.close();
			return status;
		}
	}
	
	@Override
	public int deleteRecep(String rId) throws GlobalException{
			try(Session ses=HibernateUtil.getSession()){
			
			ses.beginTransaction();
			int status=ses.createQuery("delete from user where userid=:rId").setParameter("rId", rId).executeUpdate();
			ses.getTransaction().commit();
			ses.close();
			return status;
		}
	}
	
	@Override
	public int deletePatient(int pId ) throws GlobalException{
		
		try(Session ses=HibernateUtil.getSession()){
			
			ses.beginTransaction();
			int status=ses.createQuery("delete from Patient where PatientId=:pId").setParameter("pId", pId).executeUpdate();
			ses.getTransaction().commit();
			ses.close();
			return status;
		}
	}
	
}
