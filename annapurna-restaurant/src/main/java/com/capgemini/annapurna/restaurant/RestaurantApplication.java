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

	/*
	 * @Bean public CommandLineRunner produceData(RestaurantRepository repository) {
	 * foodItems.add(new FoodItem("Fish Fry", false, 100.9, "Food", photos));
	 * 
	 * ratings.put(101, 3); ratings.put(102, 4);
	 * 
	 * reviews.put(101, "Quality Good"); reviews.put(102, "Quality Good");
	 * 
	 * photos.add("c:/food"); photos.add("c:/seefood");
	 * 
	 * return (env) -> { repository.save( new Restaurant(101, "Royal Foods", new
	 * Address("Vitawa", "Thane", "Maharashtra", "India", 450124), foodItems,
	 * ratings, reviews, "Veg-NonVeg", photos)); foodItems.add(new
	 * FoodItem("Panner Tikka", true, 200.0, "Spicy Food", photos));
	 * repository.save(new Restaurant(102, "Taj", new Address("CST", "Mumbai",
	 * "Maharashtra", "India", 450124), foodItems, ratings, reviews, "Veg-NonVeg",
	 * photos)); foodItems.add(new FoodItem("Biryani", true, 95.20, "Spicy Food",
	 * photos)); repository.save(new Restaurant(103, "Taj", new Address("CST",
	 * "Mumbai", "Maharashtra", "India", 450124), foodItems, ratings, reviews,
	 * "Veg-NonVeg", photos)); }; }
	 */

	/*
	 * server.port=8081 spring.data.mongodb.database=restaurant_db
	 * spring.main.allow-bean-definition-overriding=true
	 */

	/*
	 * security: oauth2: client: clientId: 91ae41cc2a47a598f40e clientSecret:
	 * a6a2737b7c0bab8e40a618e39388734c5987322f accessTokenUri:
	 * https://github.com/login/oauth/access_token userAuthorizationUri:
	 * https://github.com/login/oauth/authorize tokenName: oauth_token
	 * authenticationScheme: query clientAuthenticationScheme: form resource:
	 * userInfoUri: https://api.github.com/user
	 * 
	 * 
	 * server: port: 8081
	 * 
	 * spring: data: mongodb: database: restaurant_db
	 * 
	 * main: allow-bean-definition-overriding: true
	 */

}
