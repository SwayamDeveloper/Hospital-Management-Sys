package serviceImpl;

import java.util.Scanner;

import org.apache.log4j.Logger;

import Model.user;
import dao.userValidDao;
import daoImpl.userValidDaoImpl;
import exception.GlobalException;
import service.adminDashboard;
import service.doctorDashboard;
import service.loginsection;
import service.receptionistDashboard;

public class loginsectionImpl implements loginsection {
	static Logger log = Logger.getLogger(loginsectionImpl.class);
	String username,password;
	static userValidDao dao=new userValidDaoImpl();
	Scanner in = new Scanner(System.in);
	
	
	
	public void login() throws GlobalException{
	
		log.info("Enter username:");
		username = in.next();
		log.info("Enter Password");
		password = in.next();
		user u1 = dao.login(username, password);
		log.info("Hello "+u1.getFirstName()+" "+u1.getLastName());
	
	if(u1.getUserRollCode()==1)
		log.info("Logged in as a Admin");
	else if(u1.getUserRollCode()==2)
		log.info("Looged in as a Doctor");
	else if(u1.getUserRollCode()==3)
		log.info("Logged in as a Receptionist");
	
	adminDashboard ad1 = new adminDashboardImpl();
	doctorDashboard do1 = new doctorDashboardImpl();
	receptionistDashboard recep1 = new receptionistDashboardImpl();
	if(u1.getUserRollCode()==1)
		ad1.dashboard(u1);
	else if(u1.getUserRollCode()==2)
		do1.dashboard(u1);
	else if(u1.getUserRollCode()==3)
		recep1.dashboard();
}

	
	
	
	
	
	
//	public void admin() throws GlobalException{
//		
//		System.out.println("Enter username:");
//		username = in.next();
//		System.out.println("Enter Password");
//		password = in.next();
//		user u1 = dao.login(username, password);
//		System.out.println("Hello "+u1.getUserId()+"\nLogged in as a Admin");
//		adminDashboard ad1 = new adminDashboardImpl();
//		ad1.dashboard();
//	}
//	
//	public void doctor() throws GlobalException{
//		System.out.println("Enter username:");
//		username = in.next();
//		System.out.println("Enter Password");
//		password = in.next();
//		user u1=dao.login(username, password);
//		System.out.println("Hello "+u1.getUserId()+"\nLogged in as a doctor");
//		doctorDashboard do1 = new doctorDashboardImpl();
//		do1.dashboard();
//		
//	}
//	
//	public void receptionist() throws GlobalException{
//		System.out.println("Enter username:");
//		username = in.next();
//		System.out.println("Enter Password");
//		password = in.next();
//		user u1=dao.login(username, password);
//		System.out.println("Hello "+u1.getUserId()+"\nLogged in as a receptionist");
//		receptionistDashboard recep1 = new receptionistDashboardImpl();
//		recep1.dashboard();
//	}
	
	

}
