package com.wipro.capstoneshopfrohome.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.capstoneshopfrohome.entity.Product;



public interface IProductService {
	
	public List<Product> getAllProducts();

	Product findOne(String productId);

	Page<Product> findUpAll(Pageable pageable);

	Page<Product> findAll(Pageable pageable);

	Page<Product> findAllInCategory(Integer categoryType, Pageable pageable);

	void increaseStock(String productId, int amount);

	void decreaseStock(String productId, int amount);

	Product update(Product product);

	Product save(Product product);

	void delete(String productId);

	public String deleteProduct(int pid);

	public String updateProductPrice(Product product);
	public String storeProduct(Product product);
	
}