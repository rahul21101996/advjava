package com.demo.service;

import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService{
	private LoginDao ldao;
	
	public LoginServiceImpl() {
		ldao=new LoginDaoImpl();
	}

	@Override 
	public boolean validateUser(String uname, String pass) {
		return ldao.doAuthentication(uname,pass);
		
	}
	
	

}
