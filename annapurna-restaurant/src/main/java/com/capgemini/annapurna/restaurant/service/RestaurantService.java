package com.capgemini.annapurna.restaurant.service;
import java.util.List;

import com.capgemini.annapurna.restaurant.Exception.InvalidIncommingInputException;
import com.capgemini.annapurna.restaurant.entity.Restaurant;

/**
 * @author ugawari
 *
 * This abstract class is used to perform all operations related to restaurant. 
 */
public interface RestaurantService {

	List<Restaurant> getAllRestaurant();

	Restaurant getRestaurantById(int restaurantId) throws InvalidIncommingInputException;

	Restaurant registerRestaurant(Restaurant restaurant) throws InvalidIncommingInputException;

	void deleteRestaurant(int restaurantId);

}
