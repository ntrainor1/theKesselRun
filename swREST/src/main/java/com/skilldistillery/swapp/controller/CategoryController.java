//CARTController works, need to check updates when further along
package com.skilldistillery.swapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.swapp.Cart;
import com.skilldistillery.swapp.Category;
import com.skilldistillery.swapp.service.CategoryService;

@CrossOrigin({ "*", "http://localhost:4200" })
@RestController
@RequestMapping("api")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;


	@RequestMapping(path = "categories", method = RequestMethod.GET)
	public List<Category> index(HttpServletRequest req, HttpServletResponse res) {
		return categoryService.index();
	}

	@RequestMapping(path = "categories/{id}", method = RequestMethod.GET)
	public Category show(HttpServletRequest req, HttpServletResponse res, @PathVariable("id") int id) {
		return categoryService.show(id);
	}

}
