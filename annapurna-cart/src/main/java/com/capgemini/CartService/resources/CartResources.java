package com.capgemini.CartService.resources;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.CartService.entity.Cart;
import com.capgemini.CartService.entity.FoodItems;
import com.capgemini.CartService.entity.FoodProducts;
import com.capgemini.CartService.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartResources {

	@Autowired
	CartService cartService;

	@GetMapping
	public ResponseEntity<List<Cart>> getAllCarts() {
		List<Cart> list = cartService.getAllCarts();
		return new ResponseEntity<List<Cart>>(list, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Cart> addToCart(@RequestBody Cart cart) {
	
		cartService.addCart(cart);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}

	
	@GetMapping("/{cartId}")
	public ResponseEntity<Cart> getCartById(@PathVariable Integer cartId) {
		Optional<Cart> cart = cartService.getCartById(cartId);
		if (!cart.isPresent()) {
			return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cart>(cart.get(), HttpStatus.OK);
	}

	@PutMapping("/{cartId}")
	public ResponseEntity<Cart> updateCart(@RequestBody Cart cart) {
		System.out.println("Inside put methode");
		Cart updateCart = cartService.getCartById(cart.getCartId()).get();
		Set<FoodProducts> products = updateCart.getProducts();					
		Set<FoodProducts> newFoodsToAdd = cart.getProducts();
		System.out.println("foodList   :"+products);									
		System.out.println("newFoodList   :"+newFoodsToAdd);
		Iterator<FoodProducts> itr = newFoodsToAdd.iterator();
		while(itr.hasNext())
		{
			products.add(itr.next());
		}
		updateCart.setProducts(products);
		updateCart.setTotalAmount(cartService.cartTotal(updateCart));
		cartService.updateCart(updateCart);
		return new ResponseEntity<>(updateCart, HttpStatus.OK);
	}

	@DeleteMapping("/{cartId}")
	public void deleteCart(@PathVariable int cartId) {
		cartService.deleteCartById(cartId);
	}
	/*
	 * @DeleteMapping public void deleteFromCart(@RequestBody Cart cart) {
	 * 
	 * Cart updateCart = cartService.getCartById(cart.getCartId()).get();
	 * Set<FoodProducts> products = updateCart.getProducts(); Set<FoodProducts>
	 * itemsToRemove = cart.getProducts(); System.out.println();
	 * Iterator<FoodProducts> itr = itemsToRemove.iterator(); while (itr.hasNext())
	 * { products.remove(itr.next()); }
	 * 
	 * updateCart.setProducts(products);
	 * updateCart.setTotalAmount(cartService.cartTotal(updateCart));
	 * cartService.updateCart(updateCart); cartService.cartTotal(updateCart); }
	 */
}

