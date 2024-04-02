package org.generation.ecommerce.repository;

import java.util.Optional;

import org.generation.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	Optional<Product> findByName(String name);
}//interface ProductRepository 
