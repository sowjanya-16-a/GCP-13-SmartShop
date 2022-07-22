package com.wipro.capstoneshopfrohome.entity;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;


import lombok.Data;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@DynamicUpdate
@Table(name="order_main")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;


	private String buyerEmail;

	private String buyerName;

	private BigDecimal orderAmount;

	@ColumnDefault("0")
	private Integer orderStatus;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
	private Set<ProductInOrder> products = new HashSet<>();
	

	public Order(User buyer) {
		this.buyerEmail = buyer.getEmail();
		this.buyerName = buyer.getName();
		this.orderAmount = buyer.getCart().getProducts().stream()
				.map(item -> item.getProductPrice().multiply(new BigDecimal(item.getCount()))).reduce(BigDecimal::add)
				.orElse(new BigDecimal(0));
		this.orderStatus = 0;

	}
	public Order() {

	}
}