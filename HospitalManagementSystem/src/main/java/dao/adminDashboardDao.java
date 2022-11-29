package dao;


import java.util.List;

import Model.Patient;
import Model.user;
import exception.GlobalException;

public interface adminDashboardDao {
	
	public int createDoctor(user d1) throws GlobalException;
	public List<user> viewDoctor();
	public boolean exist();
	public int createRecep(user recep);
	public user viewRecep();
	public int createPatient(Patient u1) throws GlobalException;
	public List<Patient> viewPatient();
	public int deleteDoctor(String dId) throws GlobalException;
	public int deleteRecep(String rId) throws GlobalException;
	public int deletePatient(int pId ) throws GlobalException;
	public boolean isPatientExist(int id) throws GlobalException;
	public int updatePatient(String newAD,String newTime,int id) throws GlobalException;
	
}
