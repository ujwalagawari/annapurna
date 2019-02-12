/**
 * 
 */
package com.capgemini.annapurna.restaurant.test.service;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
public class RestaurantServiceTest {

	@Autowired
	private RestaurantService service;
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

	//Tests For List
	@Test @Ignore
	public void testForRestaurantList() {
		List<Restaurant> restaurantList = service.getAllRestaurant();
		assertEquals(1, restaurantList.size());
	}
	
	@Test @Ignore
	public void testForEmptyRestaurantList() {
		List<Restaurant> restaurantList = service.getAllRestaurant();
		assertEquals(0, restaurantList.size());
	}
	
	//Tests For Get Restaurant By Id
	@Test @Ignore
	public void testForRestaurantById() {
		Restaurant restaurant = service.getRestaurantById(101);
		assertEquals("Royal Foods", restaurant.getName());
	}
	
	@Test(expected=InvalidIncommingInputException.class) @Ignore
	public void testForRestaurantByIdIsZero() throws InvalidIncommingInputException {
		service.getRestaurantById(0);
	}
	
	@Test(expected = InvalidIncommingInputException.class) @Ignore
	public void testForRestaurantByWrongId() {
		service.getRestaurantById(104); //for invalid id like -ve, absent
	}

	//Tests For Create new Restaurant
	@Test @Ignore
	public void createRestaurant() throws InvalidIncommingInputException {
		Restaurant restaurant = service.registerRestaurant(new Restaurant(103, "Chitale", new Address("Airoli", "Navi-Mumbai", "Maharashtra", "India", 450124),
				foodItems, ratings, reviews, "Veg-NonVeg", photos));
		assertNotNull(restaurant);
	}
	
	@Test(expected=InvalidIncommingInputException.class) @Ignore
	public void nullRestaurant() throws InvalidIncommingInputException {
		service.registerRestaurant(null);
	}
	
	//Tests For Update Restaurant
	@Test @Ignore
	public void updateRestaurant() {
		Restaurant restaurant = service.registerRestaurant(new Restaurant(103, "taj", new Address("Nariman Point, CST", "Navi-Mumbai", "Maharashtra", "India", 450124),
				foodItems, ratings, reviews, "Veg-NonVeg", photos));
		assertNotNull(restaurant);
	}
	
	@Test(expected=InvalidIncommingInputException.class) @Ignore
	public void deleteRestaurantForInvalidInput() {
		service.deleteRestaurant(104);
	}
	
	@Test @Ignore
	public void deleteRestaurantById() throws InvalidIncommingInputException {
		service.deleteRestaurant(104);
	}
}
