package com.wipro.capstoneshopfrohome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.capstoneshopfrohome.entity.Product;
import com.wipro.capstoneshopfrohome.service.IProductService;


@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	
	@Autowired
	IProductService productService;
	
	@GetMapping("/getAllProduct")
	public List<Product> getAllProductInfo() {
		return productService.getAllProducts();
	}
	
			@PostMapping(value = "storeProduct",
					consumes = MediaType.APPLICATION_JSON_VALUE)
			public String storeProduct(@RequestBody Product product) {
						return productService.storeProduct(product);
			}
			
			@DeleteMapping(value = "deleteProduct/{pid}")
			public String storeProductInfo(@PathVariable("pid") int pid) {
							return productService.deleteProduct(pid);
			}
			
			@PatchMapping(value = "updateProduct")
			public String updateProductPrice(@RequestBody Product product) {
							return productService.updateProductPrice(product);
			}
		
}
