package service;

import exception.GlobalException;

public interface receptionistDashboard {
	public void dashboard()	throws GlobalException;
	public void addPatient() throws GlobalException;
	public void viewPatient();
	public void deletePatient() throws GlobalException;
	public void editPatient() throws GlobalException;

	
}
