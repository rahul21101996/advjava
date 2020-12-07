package com.demo.service;

import java.util.ArrayList;

import com.demo.bean.Product;

public interface ProductService {
	ArrayList<Product> getAllProduct();

	Product getById(int pid);

	int updateProduct(Product p);

	int addProduct(Product p);

	int deleteProduct(int pid);

	

}
