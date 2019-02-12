/**
 * 
 */
package com.capgemini.annapurna.restaurant.test.resource;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.annapurna.restaurant.Exception.InvalidIncommingInputException;
import com.capgemini.annapurna.restaurant.entity.Address;
import com.capgemini.annapurna.restaurant.entity.FoodItem;
import com.capgemini.annapurna.restaurant.entity.Restaurant;
import com.capgemini.annapurna.restaurant.service.RestaurantService;

/**
 * @author ugawari
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RestaurantResourceSpringBootTest {

	@Autowired
	private TestRestTemplate template;

	private Set<FoodItem> foodItems;
	private Map<Integer, Integer> ratings;
	private Map<Integer, String> reviews;
	private Set<String> photos;

	@Before
	public void setUp() throws Exception {
		foodItems = new HashSet<FoodItem>();
		ratings = new HashMap<Integer, Integer>();
		reviews = new HashMap<Integer, String>();
		photos = new HashSet<String>();

		foodItems.add(new FoodItem());
		foodItems.add(new FoodItem());

		ratings.put(101, 3);
		ratings.put(102, 4);

		reviews.put(101, "Quality Good");
		reviews.put(102, "Quality Good");

		photos.add("c:/food");
		photos.add("c:/seefood");
	}

	/*
	 * @Test public void name() { assertThat("Ujwala".isEmpty()); }
	 */

	@Test @Ignore
	public void noController() throws Exception {
		ResponseEntity<Restaurant> entity = template.getForEntity("/abc", Restaurant.class);
		assertEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());
	}

	@Test @Ignore
	public void wrongUrl() throws Exception {
		ResponseEntity<Restaurant> entity = template.getForEntity("/abc", Restaurant.class);
		assertEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());
	}

	@Test @Ignore
	public void correctUrlWithEmptyClass() throws Exception {
		ResponseEntity<Restaurant> entity = template.getForEntity("/restaurants", Restaurant.class);
		assertEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());
	}

	// Tests For List
	@Test @Ignore
	public void testToGetAllRestaurants() throws Exception {
		ResponseEntity<List> entity = template.getForEntity("/restaurants", List.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

	@Test @Ignore
	public void testForRestaurantListIsEmpty() throws Exception {
		ResponseEntity<List> entity = template.getForEntity("/restaurants", List.class);
		assertEquals( HttpStatus.NO_CONTENT, entity.getStatusCode());
	}

	// Tests For Get Restaurant By Id
	@Test @Ignore
	public void getRestaurantById() {
		ResponseEntity<Restaurant> entity = template.getForEntity("/restaurants/101", Restaurant.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

	@Test @Ignore
	public void getRestaurantByWrongId() {
		ResponseEntity<Restaurant> entity = template.getForEntity("/restaurants/104", Restaurant.class);
		assertEquals(HttpStatus.BAD_REQUEST , entity.getStatusCode());
	}

	/*
	 * @Test public void getByWrongId() throws Exception {
	 * ResponseEntity<Restaurant> entity = template.getForEntity("/restaurants/102",
	 * Restaurant.class);
	 * System.out.println(entity.getStatusCode()+", "+entity.getBody());
	 * assertEquals(entity.getStatusCode(), HttpStatus.NO_CONTENT); }
	 */

	// Tests For Create new Restaurant

	@Test @Ignore
	public void createRestaurant() {
		Restaurant restaurant = new Restaurant(103, "Chitale",
				new Address("Airoli", "Navi-Mumbai", "Maharashtra", "India", 450124), foodItems, ratings, reviews,
				"Veg-NonVeg", photos);
		ResponseEntity<Restaurant> entity = template.postForEntity("/restaurants", restaurant, Restaurant.class);
		assertNotNull(entity.getBody());
	}

	@Test @Ignore //(expected = InvalidIncommingInputException.class) -->Exception handled in try catch so no need to except
	public void nullRestaurant() {
		ResponseEntity<Restaurant> entity = template.postForEntity("/restaurants", null, Restaurant.class);
		assertEquals(HttpStatus.UNSUPPORTED_MEDIA_TYPE , entity.getStatusCode());
	}

	// Tests For Update Restaurant

	@Test @Ignore
	public void updateRestaurant() throws InvalidIncommingInputException {
		Restaurant restaurant = new Restaurant(103, "Hitchki", new Address("Nariman Point, CST", "Navi-Mumbai", "Maharashtra", "India", 450124),
				foodItems, ratings, reviews, "Veg-NonVeg", photos);
		template.put("/restaurants", restaurant);
		ResponseEntity<Restaurant> entity = template.getForEntity("/restaurants/101", Restaurant.class);
		assertEquals(restaurant.getName(), entity.getBody().getName());
	}

	@Test //@Ignore 
	public void deleteRestaurantForInvalidInput() { 
		template.delete("/restaurants/104");
		//ResponseEntity<Restaurant> entity = template.getForEntity("/restaurants/103", Restaurant.class);
		//assertEquals(HttpStatus.BAD_REQUEST, entity.getStatusCode());
	}

	@Test @Ignore
	public void deleteRestaurantById() {
		template.delete("/restaurants/102");
		//assertTrue(bool);
	}

}
