package com.shop.dao;

import java.util.List;

import com.shop.model.Category;

public interface CategoryDao {

	boolean addCategory(Category category);
	Category get(String id);
	List<Category> categoryList();
}
