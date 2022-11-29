package com.project.HospitalManagementSystem;

import java.util.Scanner;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Model.user;
import config.HibernateUtil;
import exception.GlobalException;
import service.loginsection;
import serviceImpl.loginsectionImpl;

public class App 
{
	static Logger log = Logger.getLogger(App.class);
	
    public static void main( String[] args ) throws GlobalException
    {

    	log.info("\t\t\t\t\t---------WELCOME TO HOSPITAL MANAGMENT SYSTEM----------");
    	
    	loginArea();
    

    }
    
    public static void loginArea() throws GlobalException
    {
    	loginsection logg=new loginsectionImpl();
    	Scanner bs=new Scanner(System.in);
    	
    	log.info("\nPRESS 1. For Login as a Admin\nPRESS 2. For Login as a Doctor\nPRESS 3. For Login as a Receptionist");
    	
    	int op=bs.nextInt();   //Here we are taking user choice of login according to his profession                                                    
    	
    	switch(op) {
    	case 1->logg.login();     //function for calling to login as a admin  
    	case 2->logg.login(); 		//function for calling to login as a doctor 
    	case 3->logg.login();	//function for calling to login as a receptionist  
    	}	
    }
   
} 
    
    
    
    
    
    
    
    
    
    
//	Transaction tx=session.beginTransaction();
//	
//	user u1 = new user();
//	u1.setUserId("Recep@123");
//	u1.setUserPassword("Gone@123");
//	u1.setUserRollCode(3);
//	
//	session.save(u1);
//	
//	session.getTransaction().commit();
//
//	session.close();
//	sf.close();
    
//	
//	SessionFactory sf = HibernateUtil.getSessionFactory();
//	Session session = HibernateUtil.getSession();
//	
//	System.out.println("Got the Session Factory"+sf);
//	System.out.println("Got the Session"+session);
//System.out.println("SuccessFully Exited");
//System.out.println("EveryThing is going Well till NOW");
