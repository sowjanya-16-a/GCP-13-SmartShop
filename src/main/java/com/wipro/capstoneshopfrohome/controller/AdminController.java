package com.wipro.capstoneshopfrohome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.capstoneshopfrohome.entity.Admin;
import com.wipro.capstoneshopfrohome.service.IAdminService;

@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	@Autowired
	IAdminService adminService;
	
	@PostMapping("/login")
	public String checkAdminInfo(@RequestBody Admin adm) {
		return adminService.checkAdminDetails(adm);	
	}
	
	@GetMapping("/display")
	public List<Admin> getAllAdminAvaliable() {
		return adminService.getAllAdmins();
	}
	
	
	 @GetMapping("/logout/{email}")
	 public String adminLogoutInfo(@PathVariable("email") String email) {
		 return adminService.adminLogout(email);
     }
}
