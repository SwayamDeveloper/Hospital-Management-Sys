package service;

import Model.user;
import exception.GlobalException;

public interface doctorDashboard {
	public void dashboard(user u1)	throws GlobalException;
	public void viewPatient(user u1);
	public void viewProfile(user u1);

}
