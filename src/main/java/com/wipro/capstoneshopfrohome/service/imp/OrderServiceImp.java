package com.wipro.capstoneshopfrohome.service.imp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.capstoneshopfrohome.entity.Order;
import com.wipro.capstoneshopfrohome.service.IOrderService;

@Service
public class OrderServiceImp implements IOrderService {

	@Override
	public Page<Order> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Order> findByStatus(Integer status, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Order> findByBuyerEmail(String email, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Order> findByBuyerPhone(String phone, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findOne(Long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order finish(Long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order cancel(Long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
