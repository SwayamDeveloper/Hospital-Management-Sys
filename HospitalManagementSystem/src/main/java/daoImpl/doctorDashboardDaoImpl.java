package daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import Model.Patient;
import Model.user;
import config.HibernateUtil;
import dao.doctorDashboardDao;
import exception.GlobalException;

public class doctorDashboardDaoImpl implements doctorDashboardDao {

	@Override
	public List<Patient> viewPatient(user u1) {
		int uIdNumber = u1.getId();
		
		try(Session ses=HibernateUtil.getSession()){
			
			Query qu=ses.createQuery("from Patient where doctor_id=:uIdNumber").setParameter("uIdNumber",uIdNumber);
			List<Patient> paList=qu.getResultList();
			ses.close();
			return paList;
	}
	}
	public void editProfile() throws GlobalException{
		
	}
}
