package com.wipro.capstoneshopfrohome.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.capstoneshopfrohome.entity.Order;


public interface IOrderService {

	public Page<Order> findAll(Pageable pageable);
	
	public Page<Order> findByStatus(Integer status,Pageable pageable);
	
	public Page<Order> findByBuyerEmail(String email, Pageable pageable);

	public Page<Order> findByBuyerPhone(String phone, Pageable pageable);

	public Order findOne(Long orderId);

	public Order finish(Long orderId);

	public Order cancel(Long orderId);
}
