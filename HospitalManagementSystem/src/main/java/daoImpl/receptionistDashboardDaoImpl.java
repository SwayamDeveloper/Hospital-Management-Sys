package daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import Model.Patient;
import Model.user;
import config.HibernateUtil;
import dao.receptionistDashboardDao;
import exception.GlobalException;

public class receptionistDashboardDaoImpl implements receptionistDashboardDao {
	
	public List<Patient> viewPatient(){
		try(Session ses=HibernateUtil.getSession()){
			
			Query qu=ses.createQuery("from Patient");
			List<Patient> paList=qu.getResultList();
			ses.close();
			return paList;
	}

	}
	
	public int createPatient(Patient u1) throws GlobalException{
			try(Session session = HibernateUtil.getSession()){
			
			session.beginTransaction();
			String fName = u1.getDoctorFirstName();
			String lName = u1.getDoctorLastName();
			user d1 = null;
			d1=(user)session.createQuery("from user where firstName=:fName and lastName=:lName").setParameter("fName", fName).setParameter("lName",lName).uniqueResult();
			
			if(d1!=null)
			{
				u1.setDoctor(d1);
				session.save(u1);
				session.close();
			}
			else {
				throw new GlobalException("Entered Doctor name is wrong or not present in the doctor list check and enter again");
			}
		}
		return 1;
	}
	
	@Override
	public int deletePatient(String pName,String pEmailId,String mobNum) throws GlobalException{
		try(Session ses=HibernateUtil.getSession()){
			
			ses.beginTransaction();
			int status=ses.createQuery("delete from Patient where lower(firstName)=:pName and lower(email)=:pEmailId and lower(phoneNumber)=:mobNum").setParameter("pName", pName.toLowerCase()).setParameter("pEmailId", pEmailId.toLowerCase()).setParameter("mobNum", mobNum.toLowerCase()).executeUpdate();
			ses.getTransaction().commit();
			ses.close();
			return status;
		}
	}
}
