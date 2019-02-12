/**
 * 
 */
package com.capgemini.annapurna.restaurant.test.resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.capgemini.annapurna.restaurant.entity.Address;
import com.capgemini.annapurna.restaurant.entity.FoodItem;
import com.capgemini.annapurna.restaurant.entity.Restaurant;
import com.capgemini.annapurna.restaurant.resources.RestaurantResource;
import com.capgemini.annapurna.restaurant.service.RestaurantService;

/**
 * @author ugawari
 *
 */
//@RunWith(SpringRunner.class)
//@WebMvcTest(value = RestaurantResource.class, secure = false)
public class RestaurantResourceWebMvcTest {
	
	/*
	 * @Autowired private MockMvc mockMvc;
	 * 
	 * @MockBean private RestaurantService service;
	 * 
	 * @Test public void testing() { System.out.println(5555); }
	 * 
	 * Set<FoodItem> foodItems = new HashSet<FoodItem>(); Map<Integer, Integer>
	 * ratings =new HashMap<Integer, Integer>(); Map<Integer, String> reviews = new
	 * HashMap<Integer, String>(); Set<String> photos = new HashSet<String>();
	 * List<Restaurant> list = new ArrayList<Restaurant>();
	 * 
	 * @Test public void getAllRestaurantTest () throws Exception {
	 * foodItems.add(new FoodItem()); foodItems.add(new FoodItem());
	 * 
	 * ratings.put(101, 3); ratings.put(102, 4);
	 * 
	 * reviews.put(101, "Quality Good"); reviews.put(102, "Quality Good");
	 * 
	 * photos.add("c:/food"); photos.add("c:/seefood");
	 * 
	 * Restaurant restaurant = new Restaurant(101, "Royal Foods", new
	 * Address("Vitawa", "Thane", "Maharashtra", "India", 450124), foodItems,
	 * ratings, reviews, "Veg-NonVeg", photos); list.add(restaurant);
	 * Mockito.when(service.getAllRestaurant()).thenReturn(list);
	 * System.out.println(2222); RequestBuilder requestBuilder =
	 * MockMvcRequestBuilders.get("/restaurants").accept(
	 * MediaType.APPLICATION_JSON);
	 * 
	 * MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	 * 
	 * System.out.println(result.getResponse().getContentAsString()); //String
	 * expected = "{id:Course1,name:Spring,description:10Steps}";
	 * 
	 * //JSONAssert.assertEquals(expected,
	 * result.getResponse().getContentAsString(), false); }
	 */
}
