package com.ecobazzar.ecobazzer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecobazzar.ecobazzer.service.ProductService;
import com.ecobazzar.ecobazzer.model.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
	private final ProductService productservice;
	public ProductController(ProductService productservice) {
		this.productservice=productservice;
		
	}
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return productservice.addProduct(product);
	}
	@GetMapping
	public List<Product> getAllProducts(){
		return productservice.getAllProducts();
	}
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id,@RequestBody Product product) {
		return productservice.updateProduct(id, product);
	}
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
		 productservice.deleteProduct(id);
		 return "Deletion succesful";
	}
	@GetMapping("/eco")
	public List<Product> getEcoCertifiedTrue(){
		return productservice.getEcoCertifiedTrue();
	}
	@GetMapping("/eco/sorted")
	public List<Product> getEcoCertifiedTrueOrderByCarbonImpactAsc(){
		return productservice.getEcoCertifiedTrueOrderByCarbonImpactAsc();
	}
	
	

}
