package com.cjc.mall.web.serviceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.mall.web.dao.HomeDao;
import com.cjc.mall.web.model.Product;
import com.cjc.mall.web.model.User;
import com.cjc.mall.web.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	HomeDao hd;

	@Override
	public String addUser(User user) {
		return hd.addUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return hd.getAllUsers();
	}

	@Override
	public String deleteUser(int uid) {
		return hd.deleteUser(uid);
	}

	@Override
	public String addProduct(Product product) {
		return hd.addProduct(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return hd.getAllProducts();
	}

	@Override
	public String deleteProduct(int productId) {
		return hd.deleteProduct(productId);
	}

	@Override
	public Product viewProduct(int productId) {
		return hd.viewProduct(productId);
	}

	@Override
	public String addMoreQuantity(int productId, int moreQuantity) {

		return hd.addMoreQuantity(productId, moreQuantity);
	}

	@Override
	public void updateProduct(Product product) {
		hd.updateProduct(product);
	}

	@Override
	public User getUser(String username, String password) {
		return hd.getUser(username, password);
	}

	@Override
	public String getDate() {
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
		String instance = date.format(format);
		return instance;
	}

	@Override
	public String transaction(int productId, int userId, String mode) {
		String date = getDate();
		
		return hd.transaction(productId,userId,mode,date);
	}

	@Override
	public User getUser(int userId) {
		return hd.getUser(userId);
	}

}
