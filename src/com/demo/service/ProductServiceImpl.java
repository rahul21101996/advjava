package com.demo.service;

import java.util.ArrayList;

import com.demo.bean.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{

	ProductDao pDao;
	
	public ProductServiceImpl() {
		super();
		pDao=new ProductDaoImpl();
	}
	@Override
	public ArrayList<Product> getAllProduct() {
		return pDao.getProducts();
		
	}
	@Override
	public Product getById(int pid) {
	
	return pDao.editproduct(pid);
	}
	@Override
	public int updateProduct(Product p) {
		return pDao.updatById(p);
		
	}
	@Override
	public int addProduct(Product p) {
		return pDao.AddProduct(p);
		
	}
	@Override
	public int deleteProduct(int pid) {
		
		return pDao.DeleteProd(pid);
	}
	

	
}
