package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepo;


@RestController
@RequestMapping("api/category")
public class CategoryController {

	@Autowired
	private CategoryRepo cr;
	@PostMapping(value="/save")
	public Category saveCategory(@RequestBody Category category) {

		return this.cr.save(category);
	}

	@DeleteMapping(value="/delete")
	public void deleteCategory(@RequestParam int id) {
		this.cr.deleteById(id);		
	}

	@PutMapping(value="/update")
	public Category updateCategory(@RequestBody Category category) {

		return this.cr.save(category);
	}

	@GetMapping(value="/getCategory/{id}")
	public Optional<Category> getCategory(@PathVariable  Integer id) {
		Optional<Category> category= this.cr.findById(id);
		return category;

	}
	@GetMapping(value="/list")
	public List<Category> listOfCategory(Category category){
		List<Category> list= this.cr.findAll();	
		return list;	
	}


}
