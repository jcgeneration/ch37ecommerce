package org.generation.ecommerce.service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.generation.ecommerce.model.Product;
import org.generation.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	public final ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}//constructor

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}//getAllProducts

	public Product getProduct(Long prodId) {
		return productRepository.findById(prodId).orElseThrow(
					()-> new IllegalArgumentException("El Producto con el id [" +
								prodId + "] no existe")	);
	}//getProduct

	public Product deleteProduct(Long prodId) {
		Product tmpProd = null;
		if(productRepository.existsById(prodId)) {
			tmpProd = productRepository.findById(prodId).get();
			productRepository.deleteById(Long.valueOf(prodId));
		}//if
		return tmpProd;
	}//deleteProduct

	public Product addProduct(Product product) {
		Optional<Product> tmpProd= productRepository.findByName(product.getName());
		if (tmpProd.isEmpty()) {
			return productRepository.save(product);
		}else {
			System.out.println("Ya existe el producto con el nombre ["+
					product.getName() + "]");
			return null;
		}//if
	}//addProduct

	public Product updateProduct(Long prodId, String name, String description, 
			String uRL_image, Double price) {
		Product product = null;
		if(productRepository.existsById(prodId)) {
			product = productRepository.findById(prodId).get();
			if (name.length()!=0) product.setName(name);
			if (description.length()!=0) product.setDescription(description);
			if (uRL_image.length()!=0) product.setURL_image(uRL_image);
			if (price.doubleValue()>0) product.setPrice(price);
			productRepository.save(product);	 
		}// exist
		return product;
	}//updateProduct
//	public Product updateProduct(int prodId, String name, String description, 
//			String uRL_image, Double price) {
//		Product tmpProd = null;
//		for (Product product : list) {
//			if(product.getId() == prodId) {
//				if (name!=null) product.setName(name);
//				if (description!=null) product.setDescription(description);
//				if (uRL_image!=null) product.setURL_image(uRL_image);
//				if (price!=null) product.setPrice(price);
//				tmpProd=product;
//				break;
//			}//if ==
//		}//foreach
//		return tmpProd;
//	}//updateProduct
	
	
}//class ProductService
