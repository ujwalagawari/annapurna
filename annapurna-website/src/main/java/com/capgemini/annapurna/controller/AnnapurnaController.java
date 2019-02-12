/**
 * 
 */
package com.capgemini.annapurna.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.capgemini.annapurna.restaurant.entity.Address;
import com.capgemini.annapurna.restaurant.entity.Cart;
import com.capgemini.annapurna.restaurant.entity.FoodItem;
import com.capgemini.annapurna.restaurant.entity.FoodProducts;
import com.capgemini.annapurna.restaurant.entity.Order;
import com.capgemini.annapurna.restaurant.entity.Restaurant;

/**
 * @author ugawari
 *
 */
@Controller
public class AnnapurnaController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	public String getAllRestaurants(Model model) {
		ResponseEntity<List> entity = restTemplate.getForEntity("http://annapurna-restaurant/restaurants", List.class);
		model.addAttribute("list", entity.getBody());
		return "Home";
	}
	
	@RequestMapping("/search")
	public String search(Model model, @RequestParam String search) {
		ResponseEntity<Restaurant[]> entity = restTemplate.getForEntity("http://annapurna-restaurant/restaurants",
				Restaurant[].class);
		List<Restaurant> restaurantlist = Arrays.asList(entity.getBody());
		List<Restaurant> searchedList = new ArrayList<>();
		// List<FoodItem> foodItems = new ArrayList<>();
		for (Restaurant restaurant : restaurantlist) {
			if (restaurant.getName().equalsIgnoreCase(search))
				searchedList.add(restaurant);
			if (restaurant.getAddress().getCity().equalsIgnoreCase(search))
				searchedList.add(restaurant);
			for (FoodItem foodItem : restaurant.getFoodItems()) {
				if (foodItem.getFoodName().equalsIgnoreCase(search))
					searchedList.add(restaurant);
				// foodItems.add(foodItem);
			}
		}
		// System.out.println(foodItems.toString());
		model.addAttribute("list", searchedList);
		return "Home";
	}

	private Restaurant restaurant;
	private Address address;
	private Cart cart;

	@RequestMapping("/foodItems")
	public String getFoodItemsById(Model model, @RequestParam int restaurantId) {
		ResponseEntity<Restaurant> entity = restTemplate.getForEntity("http://annapurna-restaurant/restaurants/"+restaurantId, Restaurant.class);
		restaurant=entity.getBody();
		model.addAttribute("restaurant", entity.getBody());
		return "FoodItems";
	}
	
	@RequestMapping("/cart/getAll")// /cart/getAll
	public String getAllCarts(Model model) {
		System.out.println("getAll");
		ResponseEntity<List> carts = restTemplate.getForEntity("http://annapurna-cart/carts", List.class);
		model.addAttribute("carts", carts.getBody());
		return "GetAllCart";
	}
	
	@RequestMapping("/cart/addCart")
	public String addCart(/* @RequestParam String restaurantName, */ @RequestParam String foodName,
			@RequestParam double price, @RequestParam int quantity/* ,@RequestParam Address address */, Model model) {
		Set<FoodProducts> products = new HashSet<FoodProducts>();
		products.add(new FoodProducts(foodName, price, quantity));
		cart = new Cart(106, restaurant.getName(), products, price,restaurant.getAddress());
		restTemplate.postForEntity("http://annapurna-cart/carts", cart, Cart.class);
		model.addAttribute("cart", cart);
		return "GetAllCart";
	}

	private Integer getUniqueId() {
		UUID idOne = UUID.randomUUID();
		int uid = idOne.hashCode();
		return uid;
	}

	private static Set<FoodProducts> orderProducts;

	@RequestMapping("/cart/getById")
	public String getOrderById(@RequestParam("orderId") Integer orderId, Model model) {
		ResponseEntity<Order> order = restTemplate.getForEntity("http://annapurna-order/orders/" + orderId + " ",
				Order.class);
		System.out.println(order.getBody());
		model.addAttribute("message", "heyyyyyyyy !!!!");
		model.addAttribute("Order", order.getBody());
		return "Order";
	}
	
	@RequestMapping("/cart/submitAddress")
	public String placeOrder(@ModelAttribute Address address1, Model model) {
		address=address1;
		model.addAttribute("totalAmount", cart.getTotalAmount());
		return "passMoney";
	}
	
	@RequestMapping("/cart/passMoneyForm")
	public String deduct(/* @RequestParam Integer profileId, */ @RequestParam Double amount, Model model) {
		restTemplate.put("http://annapurna-ewallet/ewallets/" + 1 + "/pay?currentBalance=" + amount, null);
		model.addAttribute("message", "money deducted and Order placed Successfully!");
		String modeOfPayment = "E-Wallet"; // for now
		Double totalAmount = 100.0; // for now
		String restaurantName = "GrandMama's Cafe"; // for now
		Integer id = getUniqueId();
		Order order = new Order(id, modeOfPayment, "pending", cart.getProducts(), cart.getTotalAmount(), cart.getRestaurantName(), address,
				cart.getCartId());
		ResponseEntity<Order> order1 = restTemplate.postForEntity("http://annapurna-order/orders", order, Order.class);
		model.addAttribute("Order", order1.getBody());
		System.out.println(order1.getBody());
		return "Order";
	}

	@RequestMapping("/cart/placeOrder")
	public String getPlaceOrder(/* @RequestBody Cart cart, */Model model) {
		Set<FoodProducts> products = new HashSet<FoodProducts>();
		products.add(new FoodProducts("Brinjal", 234, 12));
		orderProducts = products;
		return "AddressForm";
	}
	
	@RequestMapping("/AddMoneyLink")
	public String depositForm() {
		return "addMoney";
	}

	@RequestMapping("/AddMoneyForm")
	public String deposit(@RequestParam Integer profileId, @RequestParam Double amount, Model model) {
		restTemplate.put("http://annapurna-ewallet/ewallets/" + profileId + "?currentBalance=" + amount, null);
		model.addAttribute("message", "money added Successfully!");
		return "addMoney";
	}

	@RequestMapping("/PassMoneyLink")
	public String deductAmount() {
		return "passMoney";
	}

	@RequestMapping("/StatementForm")
	public String statementForm() {
		return "statements";
	}

	@RequestMapping("/statement/{profileId}")
	public String statement(@RequestParam Integer profileId, Model model) {
		ResponseEntity<List> entity = restTemplate
				.getForEntity("http://annapurna-ewallet/ewallets/statements/" + profileId, List.class);
		model.addAttribute("statements", entity.getBody());
		return "statements";
	}

}
