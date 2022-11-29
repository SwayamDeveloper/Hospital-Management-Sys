package dao;

import java.util.List;

import Model.Patient;
import exception.GlobalException;

public interface receptionistDashboardDao {
	
	public List<Patient> viewPatient();
	public int createPatient(Patient u1) throws GlobalException;
	public int deletePatient(String pName,String pEmailId,String mobNum) throws GlobalException;

}
