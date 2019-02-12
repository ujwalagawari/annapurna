package com.capgemini.CartService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.CartService.entity.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart, Integer>  {
	
}
