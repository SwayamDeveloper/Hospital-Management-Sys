package service;

import Model.user;
import exception.GlobalException;

public interface adminDashboard {
	
	public void dashboard(user u1)	throws GlobalException;
	public void addDoctor() throws GlobalException;
	public void viewDoctor();
	public void addReceptionist() throws GlobalException;
	public void viewReceptionist();
	public void addPatient() throws GlobalException;
	public void viewPatient();
	public void editDoctor() throws GlobalException;
	public void editPatient() throws GlobalException;
	public void editReceptionist() throws GlobalException;
	public void deleteDoctor() throws GlobalException;
	public void deletePatient() throws GlobalException;
	public void deleteReceptionist() throws GlobalException;
	public void viewProfile(user u1);

}
