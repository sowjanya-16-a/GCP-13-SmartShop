package com.wipro.capstoneshopfrohome.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.capstoneshopfrohome.entity.Admin;
import com.wipro.capstoneshopfrohome.repository.IAdminRepository;
import com.wipro.capstoneshopfrohome.service.IAdminService;

@Service
public class AdminServiceImp implements IAdminService {

	@Autowired
	IAdminRepository adminRepo;

	@Override
	public String checkAdminDetails(Admin admin) {
		if (adminRepo.existsByEmail(admin.getEmail())) {
			Admin a = adminRepo.findByEmail(admin.getEmail());
			if (a.getPassword().equals(admin.getPassword())) {
				return "You Logged In sucessfully";
			} else {
				return "Please Enter Correct Details";
			}
		} else {
			return "Your Details Are Not Exists!!";
		}

	}
	@Override
	public String adminLogout(String email) {
		if (adminRepo.existsByEmail(email)) {
			return " Admin LogOut Sucessfully";
		} else {
			return "Please Enter Correct Details";
		}
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepo.findAll();
	}

	   
}
