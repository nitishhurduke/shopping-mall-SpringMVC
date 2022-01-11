package com.cjc.mall.web.service;

import java.util.List;

import com.cjc.mall.web.model.Product;
import com.cjc.mall.web.model.User;

public interface HomeService {

	String addUser(User user);

	List<User> getAllUsers();

	String deleteUser(int uid);

	String addProduct(Product product);

	List<Product> getAllProducts();

	String deleteProduct(int productId);

	Product viewProduct(int productId);

	String addMoreQuantity(int productId, int moreQuantity);

	void updateProduct(Product product);

	User getUser(String username, String password);

	User getUser(int userId);

	String getDate();

	String transaction(int productId, int userId, String mode);



}
