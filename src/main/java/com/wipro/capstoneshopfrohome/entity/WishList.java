package com.wipro.capstoneshopfrohome.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


import lombok.Data;

@Data
@Entity
public class WishList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "user_id")
	private User user;
	
	@ManyToOne()
	@JoinColumn(name = "product_id")
	private Product product;
	
	public WishList() {
	}

	public WishList(User user, Product product) {
		this.user = user;
		this.product = product;
	}
	
}