package dao;

import Model.user;
import exception.GlobalException;

public interface userValidDao {
	
	public user login(String username,String password) throws GlobalException;
}
