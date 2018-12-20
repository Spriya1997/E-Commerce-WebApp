package com.shop.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.CartDao;
import com.shop.dao.OrderDao;
import com.shop.dao.ProductDao;
import com.shop.dao.UserDao;
import com.shop.model.Cart;
import com.shop.model.Product;
import com.shop.model.User;

@Controller
public class CartController {

	@Autowired
	private ProductDao productdao;
	
	@Autowired 
	private CartDao cartdao;
	
	@Autowired 
	private UserDao userdao;
	
	@Autowired
	private OrderDao orderdao;
	
	@RequestMapping(value="/deleteCart/{cartId}")
	public String deleteCart(@PathVariable("cartId") int cartId)
	{
		cartdao.deleteCart(cartId);
		return "redirect:/cart";
	}	
	
	@RequestMapping(value="/addCart",method=RequestMethod.POST)
	public ModelAndView addCart(HttpServletRequest request, @RequestParam("pid") int pid, @RequestParam("quantity") int quantity/*@ModelAttribute("product") Product prod*/)
	{
		ModelAndView mv = new ModelAndView("cart");
		Principal principal = request.getUserPrincipal();
		String userEmail = principal.getName();
		User user = userdao.get(userEmail);
		Product prod = productdao.get(pid);
		System.out.println("username=="+userEmail);
		try
		{
			Double price = Double.parseDouble(prod.getPrice().toString());
			String prodName = prod.getPname();
			Cart cartItems = cartdao.get(pid, user.getId());
			if(cartItems == null)
			{
				System.out.println("new cart");
				Cart c = new Cart();
				c.setCartImage(prod.getImgName());
				c.setCartPrice(price);
				c.setCartProductId(pid);
				c.setCartProductName(prodName);
				c.setQuantity(quantity);
				c.setUserCartDetails(user);
				cartdao.insert(c);
			}
			else if(cartItems!=null)
			{
				System.out.println("exist cart");
				Cart c = new Cart();
				c.setCartId(cartItems.getCartId());
				c.setCartPrice(price);
				c.setCartProductId(pid);
				c.setCartProductName(prodName);
				c.setQuantity(quantity);
				c.setCartImage(prod.getImgName());
				c.setUserCartDetails(user);
				cartdao.updateCart(c);
			}
			mv.addObject("cartInfo", cartdao.getCartByUserId(user.getId()));
			return mv;
		}
		catch(Exception e) {
			System.out.println("exception");
			mv.addObject("cartInfo", cartdao.getCartByUserId(user.getId()));
			return mv;
		}		
	}
	
	@RequestMapping(value="/cart")
	public ModelAndView cartview(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView("cart");
		Principal principal = request.getUserPrincipal();
		String userEmail = principal.getName();
		User user = userdao.get(userEmail);
		mv.addObject("cartInfo", cartdao.getCartByUserId(user.getId()));
		return mv;
	}
	
	


	
}
