package serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project.HospitalManagementSystem.App;

import Model.Patient;
import Model.user;
import dao.doctorDashboardDao;
import daoImpl.doctorDashboardDaoImpl;
import exception.GlobalException;
import service.doctorDashboard;

public class doctorDashboardImpl implements doctorDashboard {
	static Scanner in = new Scanner(System.in);
	static doctorDashboard do1 = new doctorDashboardImpl();
	static doctorDashboardDao dao = new doctorDashboardDaoImpl();
	static Logger log = Logger.getLogger(doctorDashboardImpl.class);
	
	@Override
	public void dashboard(user u1)	throws GlobalException{
		log.info("\t\t\t\t---------------------WELCOME TO DOCTOR DASHBOARD-------------------------");
		int op=0;
		do {
			log.info("\n\tPress 1 For View Patients\t\t\tPress 2 For View Profile\t\t\tPress 3 For LogoutFrom Doctor");
			op=in.nextInt();
			
			switch(op) {
			
			case 1->do1.viewPatient(u1);
			case 2->do1.viewProfile(u1);
			case 3->App.loginArea();
			default->log.info("Wrong Choice");
			}
			}while(true);
		}
		
	
	@Override
	public void viewPatient(user u1) {
		int x=1;
		List<Patient> paList = dao.viewPatient(u1);
		log.info("\nS.No.\t\tName\t\t|\tEmailId\t\t|\tMobile No.\t\t|\tDoctor Name\t\t|\tAppointment Date & Time\t\t|\tCity\t\t|\tAddress");
		for(Patient u:paList)
		{
			
			log.info("\n"+(x++)+"\t\t"+u.getFirstName()+" "+u.getLastName()+"\t|\t"+u.getEmail()+"\t\t|\t"+u.getPhoneNumber()+"\t\t|\t"+u.getDoctorFirstName()+" "+u.getDoctorLastName()+"\t\t|\t"+u.getAppointmentDate()+" "+u.getTime()+"\t\t|\t"+u.getCity()+"\t\t|\t"+u.getAddress());
			
		}
	}
	@Override
	public void viewProfile(user u) {
		log.info("\nS.No.\t\tName\t\t|\tEmailId\t\t|\tMobile No.\t\t|\tSpecialization\t\t|\tCity\t\t|\tAddress");
		log.info("\n"+1+"\t\t"+u.getFirstName()+" "+u.getLastName()+"\t|\t"+u.getEmail()+"\t\t|\t"+u.getPhoneNumber()+"\t\t|\t"+u.getSpecialization()+"\t\t|\t"+u.getCity()+"\t\t|\t"+u.getAddress());
		log.info("\n\n\t\t\t\t--------------------------------Profile View---------------------------------");
	}
	

}
