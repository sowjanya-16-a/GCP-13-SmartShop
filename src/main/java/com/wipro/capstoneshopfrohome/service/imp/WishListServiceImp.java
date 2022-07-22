package com.wipro.capstoneshopfrohome.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.capstoneshopfrohome.entity.User;
import com.wipro.capstoneshopfrohome.entity.WishList;
import com.wipro.capstoneshopfrohome.repository.IWishListRepository;
import com.wipro.capstoneshopfrohome.repository.WishListCustomRepository;
import com.wipro.capstoneshopfrohome.service.IWishListService;

@Service
public class WishListServiceImp implements IWishListService {

	private final IWishListRepository wishListRepository;
	
	@Autowired
	private WishListCustomRepository wishListCustomRepository;

	public WishListServiceImp(IWishListRepository wishListRepository) {
		this.wishListRepository = wishListRepository;
	}
	
	
	@Override
	@Transactional
	public Boolean deleteWishlist(User user, String productId) {
		// TODO Auto-generated method stub
		System.out.println("method called");
		Boolean h= wishListCustomRepository.deleteWishlist(user, productId);
		System.out.println(h);
		return h;
	}

	@Override
	public Page<WishList> findByBuyerEmail(Long id, PageRequest request) {
		// TODO Auto-generated method stub
		return wishListRepository.findAllByUserId(id, request);
	}

	@Override
	public WishList createWishlist(WishList wishList) {
		// TODO Auto-generated method stub
		return wishListRepository.save(wishList);
	}

}
