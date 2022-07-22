package com.wipro.capstoneshopfrohome.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.capstoneshopfrohome.entity.Product;
import com.wipro.capstoneshopfrohome.repository.IProductRepository;
import com.wipro.capstoneshopfrohome.service.ICategoryService;
import com.wipro.capstoneshopfrohome.service.IProductService;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ProductServiceImp implements IProductService {

	@Autowired
	IProductRepository productRepo;
	
	@Autowired
	ICategoryService categoryService;
	
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public Product findOne(String productId) {
		// TODO Auto-generated method stub
		Product product = productRepo.findByProductId(productId);
		return product;
	}

	@Override
	public Page<Product> findUpAll(Pageable pageable) {
		return null;
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return null;
	}

	@Override
	public Page<Product> findAllInCategory(Integer categoryType, Pageable pageable) {
		return null;
	}


	@Override
	@Transactional
	public void increaseStock(String productId, int amount) {
		// TODO Auto-generated method stub
		Product product = findOne(productId);
		int update = product.getProductStock() + amount;
		product.setProductStock(update);
		productRepo.save(product);
	}

	@Override
	public void decreaseStock(String productId, int amount) {
		// TODO Auto-generated method stub
		Product product = findOne(productId);
		int update = product.getProductStock() - amount;
		if(update>0)
		{
			product.setProductStock(update);
			productRepo.save(product);
		}
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		categoryService.findByCategoryType(product.getCategoryType());
		return productRepo.save(product);
	}

	@Override
	public Product save(Product product) {
		return null;
	}

	@Override
	public void delete(String productId) {

	}

	public String storeProduct(Product product) {
		if (productRepo.existsById(product.getProductId())) {
			return "Product Id Should Be Unique";
		} else {
			productRepo.save(product);
			return "Product Stored Successfully";
		}
	}
	
	//update
	public String updateProductPrice(Product product) {
		if (productRepo.existsById(product.getProductId())) {
			Product pp = productRepo.getById(product.getProductId());
			pp.setProductPrice((product.getProductPrice()));
			productRepo.saveAndFlush(pp);
			return "Product Price Updated Successfully";
			
		} else {
			return "No product Found";
		}
	}
	
	//delete
	public String deleteProduct(int pid) {
		if (!productRepo.existsById(pid)) {
			return "Product  Details Not Present";
		} else {
			productRepo.deleteById(pid);
			return "Product Deleted Successfully";
		}
	}
	

}
