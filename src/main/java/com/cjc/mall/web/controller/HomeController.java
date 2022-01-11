package com.cjc.mall.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.mall.web.model.Payment;
import com.cjc.mall.web.model.Product;
import com.cjc.mall.web.model.User;
import com.cjc.mall.web.service.HomeService;

@Controller
public class HomeController {

	@Autowired
	HomeService hs;

	@RequestMapping("/")
	public String toLogin() {
		return "login";
	}

	@RequestMapping("/login")
	public String login(@RequestParam("user") String username, @RequestParam("pass") String password,Model model) {
		String page = null;
		if (username.equals("admin") && password.equals("admin")) {
			page = "adminPage";
		}else {
			User user = hs.getUser(username,password);
			if(user!= null) {
				
				List<Product> products = hs.getAllProducts();
				model.addAttribute("products", products);
				model.addAttribute("user",user);
				page = "userPage1";
				
			}else {
				System.out.println("Invalid Login credentials...");
				
			}
		}
		return page;
	}

	@RequestMapping("/toRegistration")
	public String toRegistration() {
		return "registration";
	}

	@RequestMapping("/registration")
	public String registration(@ModelAttribute User user) {
		String page = hs.addUser(user);
		return page;
	}

	@RequestMapping("/home")
	public String backToHome() {
		return "login";
	}

	@RequestMapping("/showAllUsers")
	public String showAllUsers(Model model) {
		List<User> users = hs.getAllUsers();
		model.addAttribute("users", users);
		return "showAllUsers";
	}

	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam("uid") int uid, Model model) {
		String msg = hs.deleteUser(uid);

		List<User> users = hs.getAllUsers();
		model.addAttribute("users", users);

		return "deleteUser";
	}

	@RequestMapping("/toAddNewProduct")
	public String toAddNewProduct() {
		return "addNewProduct";
	}

	@RequestMapping("/toAdmin")
	public String toAdmin() {
		return "adminPage";
	}

	@RequestMapping("/addNewProduct")
	public String addNewProduct(@ModelAttribute Product product) {
		String page = hs.addProduct(product);
		return page;
	}

	@RequestMapping("/showAllProducts")
	public String showAllProducts(Model model) {
		List<Product> products = hs.getAllProducts();
		model.addAttribute("products", products);
		return "showAllProducts";
	}

	@RequestMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("productId") int productId, Model model) {
		String page = hs.deleteProduct(productId);
		List<Product> products = hs.getAllProducts();
		model.addAttribute("products", products);
		return page;
	}
	
	@RequestMapping("/viewProduct")
	public String viewProduct(@RequestParam("productId") int productId, Model model) {
		Product product = hs.viewProduct(productId);
		model.addAttribute("product", product);
		return "viewProduct";
	}
	@RequestMapping("/addMoreQuantity")
	public String addMoreQuantity(@RequestParam("productId") int productId, @RequestParam("moreQuantity") int moreQuantity ,Model model ) {
		String page = hs.addMoreQuantity(productId,moreQuantity);
		List<Product> products = hs.getAllProducts();
		model.addAttribute("products", products);
		return page;
	}
	
	@RequestMapping("/editProduct")
	public String editProduct(@RequestParam("productId") int productId,Model model) {
		Product product = hs.viewProduct(productId);
		model.addAttribute("product", product);
		
		return "editProduct";
	}
	
	@RequestMapping("/updateProduct")
	public String updateProduct(@ModelAttribute Product product,Model model) {
		System.out.println(product);
		hs.updateProduct(product);
		List<Product> products = hs.getAllProducts();
		model.addAttribute("products", products);
		return "showAllProducts";
	}
	@RequestMapping("/toPayment")
	public String  toPayment(@RequestParam("productId") int  productId ,@RequestParam("userId") int userId,Model model) {
Product product = hs.viewProduct(productId);
User user = hs.getUser(userId);	
model.addAttribute("product", product);
	model.addAttribute("user",user);
		return "paymentPage";	
	}
	@RequestMapping("/transaction")
	public String transaction(@RequestParam("pid") int  productId ,@RequestParam("uid") int userId,@RequestParam("mode") String mode,  Model model) {
	
		String page = hs.transaction(productId, userId, mode);
		
		User user = hs.getUser(userId);	
		List<Product> products = hs.getAllProducts();
		model.addAttribute("products", products);
		model.addAttribute("user",user);
		return page;	
	}
	
}
