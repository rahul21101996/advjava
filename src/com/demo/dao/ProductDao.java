package com.demo.dao;

import java.util.ArrayList;

import com.demo.bean.Product;

public interface ProductDao {

	ArrayList<Product> getProducts();

	Product editproduct(int pid);

	int updatById(Product p);

	int AddProduct(Product p);

	int DeleteProd(int pid);

}
