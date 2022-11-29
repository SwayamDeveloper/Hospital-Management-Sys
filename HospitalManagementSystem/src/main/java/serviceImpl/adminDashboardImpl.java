package serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.hibernate.internal.build.AllowSysOut;

import com.project.HospitalManagementSystem.App;

import Model.Patient;
import Model.user;
import dao.adminDashboardDao;
import daoImpl.adminDashboardDaoImpl;
import exception.GlobalException;

import service.adminDashboard;

public class adminDashboardImpl implements adminDashboard {
	
	static Scanner in = new Scanner(System.in);
	static adminDashboard ad1 = new adminDashboardImpl();
	static adminDashboardDao dao = new adminDashboardDaoImpl();
	static Logger log = Logger.getLogger(adminDashboardImpl.class);
	
	public void dashboard(user u1)	throws GlobalException{
		System.out.println("\t\t\t\t---------------------WELCOME TO ADMIN DASHBOARD-------------------------");
		int op=0;
		do {
			log.info("\n\tPress 1 For Add Doctor\t\t\tPress 2 For View Doctor\n\tPress 3 For Add Receptionist\t\tPress 4 For View Receptionist\n\tPress 5 For Add Patient\t\t\tPress 6 For View Patients\n\tPress 7 For Edit Doctor\t\t\tPress 8 For Edit Patient\n\tPress 9 For Edit Receptionist\t\tPress 10 For Delete Doctor\n\tPress 11 For Delete Patient\t\tPress 12 For Delete Receptionist\n\tPress 13 For Edit Profile\t\tPress 14 For LogoutFrom Admin");
			op=in.nextInt();
			
			switch(op) {
			
			case 1->ad1.addDoctor();
			case 2->ad1.viewDoctor();
			case 3->ad1.addReceptionist();
			case 4->ad1.viewReceptionist();
			case 5->ad1.addPatient();
			case 6->ad1.viewPatient();
			case 7->ad1.editDoctor();
			case 8->ad1.editPatient();
			case 9->ad1.editReceptionist();
			case 10->ad1.deleteDoctor();
			case 11->ad1.deletePatient();
			case 12->ad1.deleteReceptionist();
			case 13->ad1.viewProfile(u1);
			case 14->App.loginArea();
			default->log.info("Wrong Choice");
			}
			}while(true);
		}
		
		@Override
		public void addDoctor() throws GlobalException{
			
			log.info("Enter First Name:");
			String fName = in.next();
			log.info("Enter Last Name:");
			String Lname = in.next();
			log.info("Enter Mobile Number");
			String mNum = in.next();
			log.info("Enter User Id");
			String uId = in.next();
			log.info("Enter Password");
			String upassword = in.next();
			log.info("Enter Email");
			String email = in.next();
			log.info("Enter Blood Group");
			String bg = in.next();
			log.info("Enter Gender (Male/Female/Other)");
			String gender = in.next();
			log.info("Enter Date Of Birth (dd/mm/yyyy)");
			String dob = in.next();
			log.info("Enter Age");
			int age = in.nextInt();
			in.nextLine();
			log.info("Specialization");
			String specs = in.nextLine();
			log.info("Enter Qualification");
			String quali = in.nextLine();
			log.info("Enter Joining Date (dd/mm/yyyy)");
			String jt = in.next();
			in.nextLine();
			log.info("Enter City");
			String city = in.nextLine();
			log.info("Enter Address");
			String add = in.nextLine();
			user u1 = new user();
			u1.setFirstName(fName);
			u1.setLastName(Lname);
			u1.setPhoneNumber(mNum);
			u1.setUserRollCode(2);
			u1.setUserId(uId);
			u1.setUserPassword(upassword);
			u1.setEmail(email);
			u1.setAddress(add);
			u1.setAge(age);
			u1.setBloodGroup(bg);
			u1.setDateOfBirth(dob);
			u1.setGender(gender);
			u1.setJoiningDate(jt);
			u1.setQualification(quali);
			u1.setCity(city);
			u1.setSpecialization(specs);
			
			try {
				int st=dao.createDoctor(u1);
				if(st==1) {
					log.info("Doctor Created SuccessFully");
				}
				
			}
			catch(Exception e)
			{
				log.info(e.getMessage());
			}
			
		}
		
		@Override
		public void viewDoctor() {
			int x=1;
			List<user> docList = dao.viewDoctor();
			log.info("\nS.No.\t\tName\t\t\tEmailId\t\t\tMobile No.\t\tSpecialization\t\tCity\t\tAddress");
			for(user u:docList)
			{
				
				log.info("\n"+(x++)+"\t\t"+u.getFirstName()+" "+u.getLastName()+"\t\t"+u.getEmail()+"\t\t"+u.getPhoneNumber()+"\t\t"+u.getSpecialization()+"\t\t"+u.getCity()+"\t\t"+u.getAddress());
				
			}
			
		}
		
		@Override
		public void addReceptionist() throws GlobalException{
			user recep = new user();
			if(dao.exist())
			{
				log.info("Receptionist Exists already Can not have more than one receptionist remove first");
			}
			else {
				log.info("Enter First Name:");
				String fName = in.next();
				log.info("Enter Last Name:");
				String Lname = in.next();
				log.info("Enter Mobile Number");
				String mNum = in.next();
				log.info("Enter User Id");
				String uId = in.next();
				log.info("Enter Password");
				String upassword = in.next();
				log.info("Enter Email");
				String email = in.next();
				log.info("Enter Blood Group");
				String bg = in.next();
				log.info("Enter Gender (Male/Female/Other)");
				String gender = in.next();
				log.info("Enter Date Of Birth (dd/mm/yyyy)");
				String dob = in.next();
				log.info("Enter Age");
				int age = in.nextInt();
				in.nextLine();
				log.info("Enter Qualification");
				String quali = in.nextLine();
				log.info("Enter Joining Date (dd/mm/yyyy)");
				String jt = in.next();
				in.nextLine();
				log.info("Enter City");
				String city = in.nextLine();
				log.info("Enter Address");
				String add = in.nextLine();
				recep.setFirstName(fName);
				recep.setLastName(Lname);
				recep.setPhoneNumber(mNum);
				recep.setUserRollCode(3);
				recep.setUserId(uId);
				recep.setUserPassword(upassword);
				recep.setEmail(email);
				recep.setAddress(add);
				recep.setAge(age);
				recep.setBloodGroup(bg);
				recep.setDateOfBirth(dob);
				recep.setGender(gender);
				recep.setJoiningDate(jt);
				recep.setQualification(quali);
				recep.setCity(city);
				
				
				try {
					int st=dao.createDoctor(recep);
					if(st==1) {
						log.info("Recepstionist Created SuccessFully");
					}
					
				}
				catch(Exception e)
				{
					log.info(e.getMessage());
				}
				
			}
			
			
			
		}
		
		@Override
		public void viewReceptionist() {
			user recep= dao.viewRecep();
			log.info("\nS.No.\t\tName\t\t\tEmailId\t\t\tMobile No.\t\tQualification\t\tCity\t\tAddress");
			log.info("\n"+1+"\t\t"+recep.getFirstName()+" "+recep.getLastName()+"\t\t"+recep.getEmail()+"\t\t"+recep.getPhoneNumber()+"\t\t"+recep.getQualification()+"\t\t"+recep.getCity()+"\t\t"+recep.getAddress());
				
			
		}
		
		@Override
		public void addPatient() throws GlobalException{
			
			log.info("Enter First Name:");
			String fName = in.next();
			log.info("Enter Last Name:");
			String Lname = in.next();
			log.info("Enter Mobile Number");
			String mNum = in.next();
			log.info("Enter Email");
			String email = in.next();
			log.info("Enter Blood Group");
			String bg = in.next();
			log.info("Enter Gender (Male/Female/Other)");
			String gender = in.next();
			log.info("Enter Date Of Birth (dd/mm/yyyy)");
			String dob = in.next();
			in.nextLine();
			log.info("Doctor First Name");
			String fname = in.nextLine();
			log.info("Doctor Last Name");
			String lName = in.nextLine();
			log.info("Enter Desease");
			String quali = in.nextLine();
			log.info("Enter Appointment Date");
			String sDate = in.nextLine();
			log.info("Enter time");
			String sTime = in.nextLine();
			log.info("Enter City");
			String city = in.nextLine();
			log.info("Enter Address");
			String add = in.nextLine();
			Patient u1 = new Patient();
			u1.setFirstName(fName);
			u1.setLastName(Lname);
			u1.setPhoneNumber(mNum);;
			u1.setEmail(email);
			u1.setAddress(add);
			u1.setBloodGroup(bg);
			u1.setDateOfBirth(dob);
			u1.setGender(gender);
			u1.setCity(city);
			u1.setDeceased(quali);
			u1.setDoctorFirstName(fname);
			u1.setDoctorLastName(lName);
			u1.setAppointmentDate(sDate);
			u1.setTime(sTime);
			
			try {
				int st=dao.createPatient(u1);
				if(st==1) {
					log.info("Patient Created SuccessFully");
				}
				
			}
			catch(Exception e)
			{
				log.info(e.getMessage());
			}
			

		}
		
		@Override
		public void viewPatient() {
			int x=1;
			List<Patient> paList = dao.viewPatient();
			log.info("\nS.No.\t\tPatient Id\t|\tName\t\t|\tEmailId\t\t|\tMobile No.\t\t|\tDoctor Name\t\t|\tAppointment Date & Time\t\t|\tCity\t\t|\tAddress");
			for(Patient u:paList)
			{
				
				log.info("\n"+(x++)+"\t\t"+u.getPatientId()+"\t|\t"+u.getFirstName()+" "+u.getLastName()+"\t|\t"+u.getEmail()+"\t\t|\t"+u.getPhoneNumber()+"\t\t|\t"+u.getDoctorFirstName()+" "+u.getDoctorLastName()+"\t\t|\t"+u.getAppointmentDate()+" "+u.getTime()+"\t\t|\t"+u.getCity()+"\t\t|\t"+u.getAddress());
				
			}
		}
		
		@Override
		public void editDoctor() throws GlobalException{
			log.info("Enter Doctor's User id:");
			String dId = in.next();
			
			
			log.info("___Doctor Information Updated Successfully___");
		}
		
		@Override
		public void editPatient() throws GlobalException{
			log.info("Enter Patient Id");
			int id = in.nextInt();
			if(dao.isPatientExist(id)) {
				log.info("Enter new Appointment Date (dd/mm/yyyy)");
				String newAD = in.next();
				log.info("Enter new updated time");
				String newTime = in.next();
				
				try {
					int st = dao.updatePatient(newAD,newTime,id);
					if(st==1)
						log.info("Patient updated SuccessFully");
				}
				catch(Exception e)
				{
					log.info(e.getMessage());
				}
			}
			else
			{
				log.info("Patient id doesn't exist try with another id");
			}
		}
		
		@Override
		public void editReceptionist() throws GlobalException{
			log.info("Edited Receptionist");
		}
		
		@Override
		public void deleteDoctor() throws GlobalException{
			log.info("Enter Doctor's User id:");
			String dId = in.next();
			try {
				int st = dao.deleteDoctor(dId);
				if(st==1) {
				
					log.info("Doctor Deleted Successfully");
				}
			}
				catch(Exception e)
				{
					throw new GlobalException("Something went Wrong or Doctor have alloted patients which needs to be deleted first");
				}
		}
		
		@Override
		public void deletePatient() throws GlobalException{
			log.info("Enter Patient's unique id");
			int pId = in.nextInt();
			try {
				int st = dao.deletePatient(pId);
				if(st==1) {
				
					log.info("Patient Deleted Successfully");
				}
			}
				catch(Exception e)
				{
					throw new GlobalException("Something went Wrong or Check Details Carefully and try again");
				}
		}
		
		
		@Override
		public void deleteReceptionist() throws GlobalException{
			log.info("Enter Receptionist's User id:");
			String rId = in.next();
			try {
				int st = dao.deleteRecep(rId);
				if(st==1) {
				
					log.info("Receptionist Deleted Successfully");
				}
			}
				catch(Exception e)
				{
					throw new GlobalException("Something Went Wrong or User id is incorrect");
				}
		}
		@Override
		public void viewProfile(user u){
			log.info("\nS.No.\t\tName\t\t|\tEmailId\t\t|\tMobile No.\t\t|\tUserId\t\t|\tCity\t\t|\tAddress");
			log.info("\n"+1+"\t\t"+u.getFirstName()+" "+u.getLastName()+"\t|\t"+u.getEmail()+"\t\t|\t"+u.getPhoneNumber()+"\t\t|\t"+u.getUserId()+"\t\t|\t"+u.getCity()+"\t\t|\t"+u.getAddress());
			log.info("\n\n\t\t\t\t--------------------------------Profile View---------------------------------");
			
			
		}
		
		
	}


