/**
 * 
 */
package com.capgemini.annapurna.restaurant.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.annapurna.restaurant.Exception.InvalidIncommingInputException;
import com.capgemini.annapurna.restaurant.entity.Restaurant;
import com.capgemini.annapurna.restaurant.repository.RestaurantRepository;

/**
 * @author ugawari
 *
 * 
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

	private RestaurantRepository repository;

	@Autowired
	public void setRepository(RestaurantRepository repository) {
		this.repository = repository;
	}

	/**
	 * 
	 */
	@Override
	public List<Restaurant> getAllRestaurant() {
		return repository.findAll();
	}

	/*
	 * @Override public Restaurant getRestaurantById(int restaurantId) throws
	 * Exception { if(restaurantId>0) { Optional<Restaurant> entity =
	 * repository.findById(restaurantId); return entity.equals(Optional.empty())?
	 * null : entity.get(); //!entity.isPresent() } else { throw new
	 * Exception("Invalid Input"); } }
	 */

	/**
	 * 
	 */
	@Override
	public Restaurant getRestaurantById(int restaurantId) {
		Optional<Restaurant> entity = repository.findById(restaurantId);
		if(!entity.isPresent())
			throw new InvalidIncommingInputException("Invalid Input Exception.");
		return entity.get();
		/*
		 * Optional<Restaurant> entity = Optional.empty(); if (restaurantId > 0) entity
		 * = repository.findById(restaurantId); return entity.equals(Optional.empty()) ?
		 * null : entity.get(); // !entity.isPresent()
		 */	
		}

	/**
	 * 
	 */
	@Override
	public Restaurant registerRestaurant(Restaurant restaurant) throws InvalidIncommingInputException {
		if (restaurant == null)
			throw new InvalidIncommingInputException("Invalid Input Exception.");
		return repository.save(restaurant);
	}

	/**
	 * Delete re
	 */
	@Override
	public void deleteRestaurant(int restaurantId) {
		Restaurant restaurant = getRestaurantById(restaurantId);
		if(restaurant == null)
			throw new InvalidIncommingInputException("Invalid Input Exception.");
		repository.deleteById(restaurantId);
	}

}
