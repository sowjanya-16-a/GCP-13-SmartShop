package com.wipro.capstoneshopfrohome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.capstoneshopfrohome.entity.Category;


@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer>{
	
}
