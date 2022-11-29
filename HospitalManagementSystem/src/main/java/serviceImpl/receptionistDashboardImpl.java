package serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project.HospitalManagementSystem.App;

import Model.Patient;
import dao.receptionistDashboardDao;
import daoImpl.receptionistDashboardDaoImpl;
import exception.GlobalException;
import service.adminDashboard;
import service.receptionistDashboard;

public class receptionistDashboardImpl implements receptionistDashboard{
	static Scanner in = new Scanner(System.in);
	static  receptionistDashboard recep1 = new receptionistDashboardImpl();
	static receptionistDashboardDao dao = new receptionistDashboardDaoImpl();
	static Logger log = Logger.getLogger(receptionistDashboardImpl.class);
	public void dashboard()	throws GlobalException{
		log.info("\t\t\t\t---------------------WELCOME TO RECEPTIONIST DASHBOARD-------------------------");
		int op=0;
		do {
			log.info("\n\tPress 1 For Add Patient\t\t\tPress 2 For View Patients\n\tPress 3 For Edit/Update Patient\t\tPress 4 For Delete Patient\n\tPress 5 For LogoutFrom Receptionist");
			op=in.nextInt();
			
			switch(op) {
			
			case 1->recep1.addPatient();
			case 2->recep1.viewPatient();
			case 3->recep1.editPatient();
			case 4->recep1.deletePatient();
			case 5->App.loginArea();
			default->log.info("Wrong Choice");
			}
			}while(true);
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
	public void deletePatient() throws GlobalException{
		log.info("Enter Patient's First Name:");
		String pName = in.next();
		log.info("Enter Patient's EmailId");
		String pEmailId = in.next();
		log.info("Enter Patient's Mobile Number");
		String mobNum = in.next();
		try {
			int st = dao.deletePatient(pName,pEmailId,mobNum);
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
	public void editPatient() throws GlobalException{
		adminDashboard ad = new adminDashboardImpl();
		ad.editPatient();
	}


}
