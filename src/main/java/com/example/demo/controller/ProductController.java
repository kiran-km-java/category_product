package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepo;

@RestController
@RequestMapping("api/product")
public class ProductController {

	@Autowired
	private ProductRepo pr;

	@PostMapping(value="/save")
	public com.example.demo.entity.Product saveProduct(@RequestBody Product product) {

		return this.pr.save(product);	
	}

	@DeleteMapping(value="/delete")
	public void deleteProduct(@RequestParam int id) {

		this.pr.deleteById(id);		
	}

	@PutMapping(value="/update")
	public Product updateProduct(@RequestBody Product product) {

		return this.pr.save(product);

	}

	@GetMapping(value="/getProduct/{id}")
	public Optional<Product> getProduct(@PathVariable Integer  id) {
		Optional<Product> product=this.pr.findById(id);
		return product;

	}
	@GetMapping(value="/list")
	public List<Product> listOfProduct(Product product){
		List<Product> list= this.pr.findAll();	
		return list;	
	}
}
