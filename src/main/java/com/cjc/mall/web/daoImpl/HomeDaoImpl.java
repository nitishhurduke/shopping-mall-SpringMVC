package com.cjc.mall.web.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cjc.mall.web.dao.HomeDao;
import com.cjc.mall.web.model.Payment;
import com.cjc.mall.web.model.Product;
import com.cjc.mall.web.model.User;
import com.cjc.mall.web.service.HomeService;

@Repository
public class HomeDaoImpl implements HomeDao {

	@Autowired
	SessionFactory factory;
	List<User> users = new ArrayList<User>();
	
	@Autowired
	HomeService hs;

	@Override
	public String addUser(User user) {
		String msg = null;
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		msg = "registrationSuccess";
		session.close();

		return msg;
	}

	@Override
	public List<User> getAllUsers() {
		Session session = factory.openSession();
		session.beginTransaction();
		Query<User> query = session.createQuery("From User");
		users = (List<User>) query.getResultList();
		return users;
	}

	@Override
	public String deleteUser(int uid) {

		Session session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("DELETE FROM User WHERE uid = :id");
		query.setParameter("id", uid);
		int check = query.executeUpdate();
		if (check != 0) {
			System.out.println("Deleted Successfully.....");
			return "deleteSuccess";
		} else {
			return "adminPage";
		}
	}

	@Override
	public String addProduct(Product product) {

		Session session = factory.openSession();
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		session.close();

		return "addProductSuccess";
	}

	@Override
	public List<Product> getAllProducts() {
		Session session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Product");
		List<Product> products = query.getResultList();
		return products;
	}

	@Override
	public String deleteProduct(int productId) {
		Session session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("DELETE FROM Product WHERE productId = :id");
		query.setParameter("id", productId);
		query.executeUpdate();
		return "deleteProduct";
	}

	@Override
	public Product viewProduct(int productId) {
		Session session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Product WHERE productId = :id");
		query.setParameter("id", productId);
		Product product= (Product)query.getSingleResult();
		session.getTransaction().commit();
		session.close();
		
		return product;
	}

	@Override
	public String addMoreQuantity(int productId, int moreQuantity) {
		Session session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Product WHERE productId = :id");
		query.setParameter("id", productId);
		Product product= (Product)query.getSingleResult();
		product.setQuantity( product.getQuantity()+moreQuantity);
		session.update(product);
		session.getTransaction().commit();
		session.close();
		return "showAllProducts";
	}

	@Override
	public void updateProduct(Product product) {
		Session session = factory.openSession();
		session.beginTransaction();
		String hql = "UPDATE Product SET name = :nm,quantity = :quan,price = :price,discount = :dis,newPrice = :np WHERE productId = :id";
		Query query = session.createQuery(hql);
		query.setParameter("nm", product.getName());
		query.setParameter("quan", product.getQuantity());
		query.setParameter("price", product.getPrice());
		query.setParameter("dis", product.getDiscount());
		query.setParameter("id", product.getProductId());
		query.setParameter("np", product.getNewPrice());
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public User getUser(String username, String password) {
		Session session = factory.openSession();
		session.beginTransaction();
		String hql = "FROM User WHERE username = :user AND password = :pass";
		Query query = session.createQuery(hql);
		query.setParameter("user", username);
		query.setParameter("pass", password);
		User user = (User) query.getSingleResult();
		return user;
	}
	@Override
	public User getUser(int userId) {
		Session session = factory.openSession();
		session.beginTransaction();
		String hql = "FROM User WHERE uid = :id ";
		Query query = session.createQuery(hql);
		query.setParameter("id", userId);
		User user = (User) query.getSingleResult();
		return user;
	}
	@Override
	public String transaction(int productId, int userId, String mode,String date) {
		Session session = factory.openSession();
		session.beginTransaction();
		Product prod = session.get(Product.class, productId);
		User user1 = session.get(User.class,userId);
		Payment transaction = new Payment();
	
		transaction.setAmount(prod.getNewPrice());
		transaction.setDate(date);
		transaction.setStatus(true);
		transaction.setMode(mode);
		
		transaction.setProduct(prod);
		transaction.setUser(user1);
		
		prod.getPayments().add(transaction);
		prod.getUsers().add(user1);
		
		user1.getPayments().add(transaction);
		user1.getProducts().add(prod);
		
		session.save(transaction);
		session.update(prod);
		session.update(user1);
		
		session.getTransaction().commit();
		session.close();
		
		return "userPage1";
	}

	

}
