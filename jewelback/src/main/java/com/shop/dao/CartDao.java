package com.shop.dao;

import java.util.List;

import com.shop.model.Cart;

public interface CartDao {
	
		void insert(Cart cart);
		/*List<Cart> getCartByUserId(String user); 
		Cart get(int cartId, String userEmail);*/
		List<Cart> getCartByUserId(int userId); 
		Cart get(int cartId, int userId);
		void deleteCart(int cartId);
		void updateCart(Cart cart);
	

}
