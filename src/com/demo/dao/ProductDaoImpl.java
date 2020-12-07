package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.demo.bean.Product;

public class ProductDaoImpl implements ProductDao {
	private static Connection conn;
	private static PreparedStatement displayp,updt,pudpt,istp,pdlt;
	static {
		conn=DBUtil.getMyConnection();
	try {
		
		String sql="select * from product";
		displayp=conn.prepareStatement(sql);
		updt=conn.prepareStatement("select * from product where pid=?");
		pudpt=conn.prepareStatement("update product set pname=?,price=? where pid=? ");
		istp=conn.prepareStatement("insert into product values(?,?,?)");
		pdlt=conn.prepareStatement("delete from product where pid=?");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	@Override
	public ArrayList<Product> getProducts() {
		ArrayList<Product> plist=null;
		try {
			plist=new ArrayList<>();
			ResultSet rs=displayp.executeQuery();
			while(rs.next())
			{
				Product p=new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				plist.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return plist;
	}
	@Override
	public Product editproduct(int pid) {
		Product p=null;
		try {
			updt.setInt(1, pid);
			ResultSet rs=updt.executeQuery();
			if(rs.next())
			{
				p=new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				
			}
			
		} catch (SQLException|NullPointerException e ) {
			
			e.printStackTrace();
		}
		return p;
	}
	@Override
	public int updatById(Product p) {
		try {
			pudpt.setString(1,p.getPname());
			pudpt.setDouble(2,p.getPrice());
			pudpt.setInt(3,p.getPid());
			return pudpt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int AddProduct(Product p) {
		try {
			istp.setInt(1, p.getPid());
			istp.setString(2, p.getPname());
			istp.setDouble(3, p.getPrice());
			return istp.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int DeleteProd(int pid) {
		try {
			pdlt.setInt(1,pid);
			return pdlt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
