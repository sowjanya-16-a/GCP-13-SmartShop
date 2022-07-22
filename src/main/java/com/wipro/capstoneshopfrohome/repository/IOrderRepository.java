package com.wipro.capstoneshopfrohome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.capstoneshopfrohome.entity.Order;


@Repository
public interface IOrderRepository extends JpaRepository<Order, Long>{
	
//	Order findByOrderId(Long orderId);
//
//	Page<Order> findAllByOrderStatusOrderByCreateTimeDesc(Integer orderStatus, Pageable pageable);
//
//	Page<Order> findAllByBuyerEmailOrderByOrderStatusAscCreateTimeDesc(String buyerEmail, Pageable pageable);
//
//	Page<Order> findAllByOrderByOrderStatusAscCreateTimeDesc(Pageable pageable);
//
//	Page<Order> findAllByBuyerPhoneOrderByOrderStatusAscCreateTimeDesc(String buyerPhone, Pageable pageable);
}
