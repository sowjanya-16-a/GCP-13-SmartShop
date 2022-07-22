package com.wipro.capstoneshopfrohome.service;

import java.util.List;


import com.wipro.capstoneshopfrohome.entity.Admin;


public interface IAdminService {

	public String checkAdminDetails(Admin admin);
	
	public String adminLogout(String email);
	
	public List<Admin> getAllAdmins();
	
	
}
