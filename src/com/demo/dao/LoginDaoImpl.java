package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {
	private static Connection conn;
	public static PreparedStatement puser;
	static {
		conn=DBUtil.getMyConnection();
		
		try {
			String sql="select * from user where uname=? and pass=?";
			puser=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public boolean doAuthentication(String uname, String pass) {
		  try {
			  puser.setString(1, uname);
			  puser.setString(2, pass);
			ResultSet rs=puser.executeQuery();
			if(rs.next())
			{
				if((rs.getString(1).equals(uname)) && (rs.getString(2).equals(pass)))
				{
					return true;
				}
				
					return false;
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

}
