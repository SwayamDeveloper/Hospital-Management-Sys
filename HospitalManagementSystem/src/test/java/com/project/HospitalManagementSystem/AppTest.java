package com.project.HospitalManagementSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Model.Patient;
import Model.user;
import config.HibernateUtil;
import dao.adminDashboardDao;
import dao.userValidDao;
import daoImpl.adminDashboardDaoImpl;
import daoImpl.userValidDaoImpl;
import exception.GlobalException;

class AppTest {

	//1st Test
	@Disabled
	@Test
	@DisplayName("This is a test case for login testing")
	void loginTest() throws GlobalException {
	
	
	userValidDao dao = new userValidDaoImpl();             
	Session ses = HibernateUtil.getSession();           

	user u = ses.get(user.class, 2);			
	String UPCombo = u.getUserId() + u.getUserPassword();
	user a = dao.login("Doctor@123","Went@123");
	String UPCombo2 = a.getUserId() + a.getUserPassword();
	
	assertEquals(UPCombo,UPCombo2);		//Checking for successFull login

    }
	
	//2nd Test
	@Disabled
	@Test
	@DisplayName("This test case is for doctor creation")
	void createDoctorTest() {
		adminDashboardDao dao = new adminDashboardDaoImpl();
		user u1 = new user();
		u1.setUserId("Doctor@123");
		u1.setUserPassword("Went@123");
		u1.setUserRollCode(2);
		u1.setFirstName("Karma");
		u1.setLastName("Thakur");
		u1.setPhoneNumber("6788987867");
		
		user u2 = new user();
		u2.setUserId("DoctorKarma@123");
		u2.setUserPassword("Went@123");
		u2.setUserRollCode(2);
		u2.setFirstName("Karma");
		u2.setLastName("Thakur");
		u2.setPhoneNumber("6788987867");
		
		assertAll(
				()->assertEquals(1,dao.createDoctor(u2)),    //New Doctor creation 
				()->assertThrows(GlobalException.class,()->dao.createDoctor(u1))	//Throws Exception when Doctor user id exists already
			);
		
		
		
	}
	
	
	
	
	@Disabled
	//3rd Test
	@Test
	@DisplayName("This is the test case for creating patient")
	void createPatientTest() {
		adminDashboardDao dao = new adminDashboardDaoImpl();
		//new patient details which doet not exist is the database
		Patient p1 = new Patient();
		p1.setFirstName("Himanshu");
		p1.setLastName("Shukla");
		p1.setPhoneNumber("7867564589");
		p1.setDoctorFirstName("Raj");
		p1.setDoctorLastName("Dadlani");
		p1.setAppointmentDate("15/9/2022");
		p1.setTime("11:14");
		
		Patient p2 = new Patient();
		p2.setFirstName("Kabir");
		p2.setLastName("Kuereja");
		p2.setPhoneNumber("6778987867");
		p2.setDoctorFirstName("Raj");
		p2.setDoctorLastName("Dadlani");
		p2.setAppointmentDate("15/9/2022");
		p2.setTime("11:14");
		
		assertAll(
					()->assertEquals(1,dao.createPatient(p1)),    //New Patient creation 
					()->assertThrows(GlobalException.class,()->dao.createPatient(p2))	//Throws Exception when patient exist already or doctor name is wrong
				);
		
	}
	
	
	//4th Test
	@Disabled
	@Test
	@DisplayName("This is the test case for deleting doctor")
	void deleteDoctorTest() {
		adminDashboardDao dao = new adminDashboardDaoImpl();
		
		assertAll(
					()->assertEquals(1,dao.deleteDoctor("ArvindDoc@123")),    //Note:- Doctor only be deleted if not patient is alloted to that docor user id
					()->assertEquals(0,dao.deleteDoctor("Doctor@12"))		//Returns 0 if doctor id doest'nt exist
				);
		
	}
	
	
	//5th Test
	@Disabled
	@Test
	@DisplayName("This is test case for deleting patient")
	void deletePatientTest() {
	adminDashboardDao dao = new adminDashboardDaoImpl();
	
		assertAll(
					()->assertEquals(1,dao.deletePatient(3)),    
					()->assertEquals(0,dao.deletePatient(5))		
				);
	}
}
