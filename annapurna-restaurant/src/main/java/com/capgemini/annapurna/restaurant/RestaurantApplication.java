package com.capgemini.annapurna.restaurant;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.capgemini.annapurna.restaurant.entity.Address;
import com.capgemini.annapurna.restaurant.entity.FoodItem;
import com.capgemini.annapurna.restaurant.entity.Restaurant;
import com.capgemini.annapurna.restaurant.repository.RestaurantRepository;

/**
 * 
 * @author ugawari
 *
 * @SpringBootApplication to start a Spring application context
 */
@SpringBootApplication
//@EnableOAuth2Sso
@EnableDiscoveryClient
public class RestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

	Set<FoodItem> foodItems = new HashSet<FoodItem>();
	Map<Integer, Integer> ratings = new HashMap<Integer, Integer>();
	Map<Integer, String> reviews = new HashMap<Integer, String>();
	Set<String> photos = new HashSet<String>();
	Set<String> photos1 = new HashSet<String>();
	Set<String> photos2 = new HashSet<String>();
	Set<String> photos3 = new HashSet<String>();

	@Bean
	public CommandLineRunner produceData(RestaurantRepository repository) {
		foodItems.add(new FoodItem("Fish Fry", false, 100.9, "Food", photos));

		ratings.put(101, 3);
		
		reviews.put(102, "Quality Good");

		photos.add(
				"https://github.com/annapurna-website/Annapurna-Images/blob/master/Restaurant-Images/food1.jpg?raw=true");
		photos3.add(
				"https://github.com/annapurna-website/Annapurna-Images/blob/master/Restaurant-Images/food2.jpg?raw=true");
		photos1.add(
				"https://github.com/annapurna-website/Annapurna-Images/blob/master/Restaurant-Images/food3.jpg?raw=true");
		photos2.add(
				"https://github.com/annapurna-website/Annapurna-Images/blob/master/Restaurant-Images/food4.jpg?raw=true");

		return (env) -> {
			repository.save(
					new Restaurant(101, "Royal Foods", new Address("Vitawa", "Thane", "Maharashtra", "India", 450124),
							foodItems, ratings, reviews, "Veg-NonVeg", photos));
			foodItems.add(new FoodItem("Panner Tikka", true, 200.0, "Spicy Food", photos));
			
			ratings.put(102, 4);
			reviews.put(101, "Quality Good");
			repository.save(new Restaurant(102, "Taj", new Address("CST", "Mumbai", "Maharashtra", "India", 450124),
					foodItems, ratings, reviews, "Veg-NonVeg", photos1));
			foodItems.add(new FoodItem("Biryani", true, 95.20, "Spicy Food", photos2));
			
			ratings.put(103, 5);
			repository.save(new Restaurant(103, "Kinara", new Address("CST", "Mumbai", "Maharashtra", "India", 450124),
					foodItems, ratings, reviews, "Veg-NonVeg", photos3));
			
			reviews.put(103, "foods are very Good");
			ratings.put(104, 5);
			repository.save(new Restaurant(104, "Samadhan", new Address("CST", "Mumbai", "Maharashtra", "India", 450124),
							foodItems, ratings, reviews, "NonVeg", photos2));
		};
	}

}
