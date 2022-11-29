package dao;

import java.util.List;

import Model.Patient;
import Model.user;
import exception.GlobalException;

public interface doctorDashboardDao {

	public List<Patient> viewPatient(user u1);
	public void editProfile() throws GlobalException;
}
