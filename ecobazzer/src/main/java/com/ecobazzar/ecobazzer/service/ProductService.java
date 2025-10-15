package com.ecobazzar.ecobazzer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecobazzar.ecobazzer.model.Product;
import com.ecobazzar.ecobazzer.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productrepo;
	public ProductService(ProductRepository productrepo) {
		this.productrepo=productrepo;
	}
	public Product addProduct(Product product) {
		return productrepo.save(product);
	}
	public List<Product> getAllProducts(){
		return productrepo.findAll();
	}
	public Product updateProduct(Long id,Product productToUpdate) {
		return productrepo.findById(id)
				.map(product->{
					product.setName(productToUpdate.getName());
					product.setDetails(productToUpdate.getDetails());
					product.setPrice(productToUpdate.getPrice());
					product.setCarbonImpact(productToUpdate.getCarbonImpact());
					product.setEcoCertified(productToUpdate.getEcoCertified());
					product.setSellerId(productToUpdate.getSellerId());
					return productrepo.save(product);
				})
				.orElseThrow(()->new RuntimeException("Product not found to update"));

	}
	public void deleteProduct(Long id) {
		if(productrepo.existsById(id)) {
			productrepo.deleteById(id);
		}
		else {
			new RuntimeException("To product to delete for this id");
		}
			

}
	public List<Product> getEcoCertifiedTrue(){
		return productrepo.findByEcoCertifiedTrue();
		
	}
	public List<Product>getEcoCertifiedTrueOrderByCarbonImpactAsc(){
		return productrepo.findByEcoCertifiedTrueOrderByCarbonImpactAsc();
	}
}
