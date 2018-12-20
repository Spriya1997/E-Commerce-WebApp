package com.shop.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.CartDao;
import com.shop.dao.CategoryDao;
import com.shop.dao.ProductDao;
import com.shop.dao.SupplierDao;
import com.shop.dao.UserDao;
import com.shop.model.Cart;
import com.shop.model.User;


@Controller
public class IndexController {

	@Autowired
	private UserDao userdao;
	
	@Autowired
	private ProductDao productdao;
	
	@Autowired
	private CategoryDao categorydao;
	
	@Autowired
	private SupplierDao supplierdao;
	
	@Autowired 
	private CartDao cartdao;
	
	@RequestMapping("/buy")
	public ModelAndView checkout(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView("checkout");
		Principal principal = request.getUserPrincipal();
		String userEmail = principal.getName();
		User user = userdao.get(userEmail);
		List<Cart> cart = cartdao.getCartByUserId(user.getId());
		mv.addObject("user", user);
		mv.addObject("cart", cart);
		return mv;
	}

	@RequestMapping(value= {"/","home"},method=RequestMethod.GET)
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping(value="/signup")
	public String register(Model model)
	{
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@RequestMapping(value="/signup",method = RequestMethod.POST)
	public ModelAndView addUser(@Valid @ModelAttribute("user") User user, BindingResult result)
	{
		if(result.hasErrors())
		{
			System.out.println("result have errors");
			return new ModelAndView("/signup");
		}
		System.out.println("all are entered");
		user.setRole("ROLE_USER");
		user.setEnabled(false);
		userdao.insertUser(user);
		//mv.addObject("/home");
		return new ModelAndView("/home");		
	}
	
	@RequestMapping(value="/login")
	public String login()
	{
		return "login";
	}
	
	@ModelAttribute
	public void addAttributes(Model model)
	{
		model.addAttribute("plist", productdao.productList());
		model.addAttribute("slist", supplierdao.supplierList());
		model.addAttribute("clist",categorydao.categoryList());
	}
	
	@RequestMapping(value="/custProductList")
	public ModelAndView custProductList(@RequestParam ("categoryId") String cid)
	{
		//System.out.println("==================="+cid);
		ModelAndView mv = new ModelAndView("custProductList");
		mv.addObject("prodList",productdao.getProdByCategoryId(cid));
		return mv;  
	}
	
	//Cart Controller Product Details
	
	
	@RequestMapping(value="/productDetails/{pid}")
	public ModelAndView productDetails(@PathVariable("pid") int pid)
	{
		ModelAndView mv = new ModelAndView("productDetails");
		//System.out.println("------------"+pid);
		mv.addObject("prod",productdao.get(pid));
		return mv; 
	}
	
	@RequestMapping(value="/logPage")
	public String logPage()
	{
		return "redirect:home";
	}
	
	@RequestMapping("/error")
	public ModelAndView error() {
		return new ModelAndView("error");
	}
	
	@RequestMapping("/userDenied")
	public ModelAndView userDenied() {
		return new ModelAndView("userDenied");
	}


}

