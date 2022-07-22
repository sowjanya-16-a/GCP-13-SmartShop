package com.wipro.capstoneshopfrohome.service.imp;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.wipro.capstoneshopfrohome.entity.Cart;
import com.wipro.capstoneshopfrohome.entity.User;
import com.wipro.capstoneshopfrohome.repository.ICartRepository;
import com.wipro.capstoneshopfrohome.repository.IUserRepository;
import com.wipro.capstoneshopfrohome.service.IUserService;

@Service
public class UserServiceImp implements IUserService {

	
	@Autowired
	IUserRepository userRepo;
	
	@Autowired
	ICartRepository cartRepo;
	
	@Override
	public String storeUserDetails(User user) {
		// TODO Auto-generated method stub
		if(!userRepo.existsByEmail(user.getEmail())) {
			User savedUser = userRepo.save(user);

			Cart savedCart = cartRepo.save(new Cart(savedUser));
			savedUser.setCart(savedCart);
			userRepo.save(savedUser);
			return "User Added Sucessfully";
		}else {
			return "User Already Exists!!!";
		}
	}

	@Override
	public String checkUserDetails(User user) {
		   if(userRepo.existsByEmail(user.getEmail())) {
			   User u = userRepo.findByEmail(user.getEmail());
			   if(u.getPassword().equals(user.getPassword())) {
				   return "You Logged In Sucessfully";
			   }else {
				   return "Please Enter Correct Details";
			   }				   
		   }else {
			   return "Your Details Are Not Exists!!";
		   }   
	   }
	
	@Override
	public List<User> getAllUsersDetails() {
		return userRepo.findAll();
	}
	
	
	@Override
	public User findOne(String email) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(email);
	}




	@Override
	public String deleteUserDetails(String email) {
		if(!userRepo.existsByEmail(email)) {
			return "User not Exists!!";
		}else {
			userRepo.deleteByEmail(email);
			return "User Deleted Sucessfully";
		}
	}


}
