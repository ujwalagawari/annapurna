/**
 * 
 */
package com.capgemini.annapurna.restaurant.resources;
import java.util.List;

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

import com.capgemini.annapurna.restaurant.Exception.InvalidIncommingInputException;
import com.capgemini.annapurna.restaurant.entity.Restaurant;
import com.capgemini.annapurna.restaurant.service.RestaurantService;

/**
 * @author ugawari
 *
 * 
 */
//@EnableOAuth2Sso
@RestController
@RequestMapping("/restaurants")
public class RestaurantResource {

	private RestaurantService service;

	@Autowired
	public void setService(RestaurantService service) {
		this.service = service;
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Restaurant>> getAllRestaurant() {
		List<Restaurant> restaurantlist = service.getAllRestaurant();
		//System.out.println(restaurantlist);
		if (restaurantlist.isEmpty()) {
			return new ResponseEntity<>(restaurantlist, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(restaurantlist, HttpStatus.OK);
		}
	}

	/*
	 * @GetMapping("{restaurantId}") public Optional<Restaurant>
	 * getById(@PathVariable int restaurantId) { System.out.println(1111);
	 * Optional<Restaurant> restaurant = service.getRestaurantById(restaurantId);
	 * System.out.println("Rest " + restaurant); return restaurant; }
	 */

	/**
	 * 
	 * @param restaurantId
	 * @return
	 */
	@GetMapping("{restaurantId}")
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable int restaurantId) {
		Restaurant restaurant = null;
		try {
			restaurant = service.getRestaurantById(restaurantId);
		} catch (InvalidIncommingInputException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);		
		}
		if (restaurant == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else 
			return new ResponseEntity<>(restaurant, HttpStatus.OK);		
	}
	
	/**
	 * 
	 * @param restaurant
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Restaurant> registerRestaurant(@RequestBody Restaurant restaurant) {
		Restaurant registerRestaurant = null;
		try {
			registerRestaurant = service.registerRestaurant(restaurant);
		} catch (InvalidIncommingInputException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(registerRestaurant, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param restaurant
	 * @return
	 */
	@PutMapping
	public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant restaurant) {
		Restaurant registerRestaurant = null;
		try {
			registerRestaurant = service.registerRestaurant(restaurant);
		} catch (InvalidIncommingInputException e) { //e.printStackTrace();
			return new ResponseEntity<>(registerRestaurant, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(registerRestaurant, HttpStatus.OK);
	}

	/**
	 * 
	 * @param restaurantId
	 * @return
	 */
	@DeleteMapping("/{restaurantId}")
	public ResponseEntity<Restaurant> deleteRestaurant(@PathVariable int restaurantId) {
		try {
			service.deleteRestaurant(restaurantId);
		} catch (InvalidIncommingInputException e) { //e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
