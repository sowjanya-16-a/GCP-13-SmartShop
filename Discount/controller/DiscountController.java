package com.greatlearning.Discount.controller;

import java.util.List;

import com.greatlearning.Discount.bean.Discount;
import com.greatlearning.Discount.service.DiscountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/discount")
@CrossOrigin(origins = "http://localhost:4200")
public class DiscountController {
	
	@Autowired
	DiscountService discountService;
	
	@GetMapping(value = "discountName",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Discount> getAllDiscount(){
		return   discountService.getAllDiscount();
	}
	
	@PostMapping(value="add",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String addDiscount(@RequestBody Discount discount)
	{
		System.out.println(discount.getDname());
		return discountService.storeDiscount(discount);
	}

}
