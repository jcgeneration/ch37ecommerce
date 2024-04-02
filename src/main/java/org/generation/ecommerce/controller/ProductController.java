package org.generation.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.generation.ecommerce.model.Product;
import org.generation.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//@CrossOrigin (origins="https://lizeth9797.github.io/manahuia/", methods= {RequestMethod.GET,RequestMethod.POST})
//@CrossOrigin (origins="*", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping(path="/api/products/") // http://localhost:8080/api/products/
public class ProductController {
	private final ProductService productService;
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}//constructor
		
	//GET
	@GetMapping
	public List<Product> getProducts() {
		return productService.getAllProducts(); 
	}//getProducts
		
	//GET
	@GetMapping (path="{prodId}")  // http://localhost:8080/api/products/1
	public Product getProduct(@PathVariable("prodId") Long prodId) {
		return productService.getProduct(prodId); 
	}//getProduct
	
	//POST
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}//addProduct
	
	//DELETE
	@DeleteMapping(path="{prodId}")  // http://localhost:8080/api/products/1
	public Product deleteProduct(@PathVariable("prodId") Long prodId) {
		return productService.deleteProduct(prodId); 
	}//getProduct
	
	
	//PUT
	@PutMapping(path="{prodId}")  // http://localhost:8080/api/products/17?price=70.20 
	public Product updateProduct(@PathVariable("prodId") Long prodId, 
			@RequestBody Product product) {
		return productService.updateProduct(prodId, product.getName(), 
				product.getDescription(), product.getURL_image(), 
				Double.valueOf(product.getPrice()));
	}//updateProduct
	
//	@PutMapping(path="{prodId}")  // http://localhost:8080/api/products/17?price=70.20 
//	public Product updateProduct(@PathVariable("prodId") int prodId, 
//			@RequestParam (required=false) String name, 
//			@RequestParam (required=false)String description,
//			@RequestParam (required=false)String URL_image,
//			@RequestParam (required=false)Double price) {
//		return productService.updateProduct(prodId, name, description, URL_image, price);
//	}//updateProduct
	
}//class ProductController












