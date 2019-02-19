/**
 * 
 */
package com.capgemini.annapurna.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.capgemini.annapurna.restaurant.entity.Address;
import com.capgemini.annapurna.restaurant.entity.Cart;
import com.capgemini.annapurna.restaurant.entity.EWallet;
import com.capgemini.annapurna.restaurant.entity.FoodItem;
import com.capgemini.annapurna.restaurant.entity.FoodProducts;
import com.capgemini.annapurna.restaurant.entity.Order;
import com.capgemini.annapurna.restaurant.entity.Profile;
import com.capgemini.annapurna.restaurant.entity.Restaurant;
import com.capgemini.annapurna.restaurant.entity.Statement;
import com.capgemini.annapurna.service.CustomUserDetailsService;

/**
 * @author ugawari
 *
 */
@Controller
public class AnnapurnaController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	/******** Restaurant ********/

	@RequestMapping("/")
	public String getAllRestaurants(Model model) {
		ResponseEntity<List> entity = restTemplate.getForEntity("http://annapurna-restaurant/restaurants", List.class);
		model.addAttribute("list", entity.getBody());
		return "Home";
		// return "NewFile";
	}

	@RequestMapping("/search")
	public String search(Model model, @RequestParam String search) {
		ResponseEntity<Restaurant[]> entity = restTemplate.getForEntity("http://annapurna-restaurant/restaurants",
				Restaurant[].class);
		List<Restaurant> restaurantlist = Arrays.asList(entity.getBody());
		List<Restaurant> searchedList = new ArrayList<>();
		for (Restaurant restaurant : restaurantlist) {
			if (restaurant.getName().equalsIgnoreCase(search))
				searchedList.add(restaurant);
			for (FoodItem foodItem : restaurant.getFoodItems()) {
				if (foodItem.getFoodName().equalsIgnoreCase(search))
					searchedList.add(restaurant);
			}
		}
		model.addAttribute("list", searchedList);
		return "Home";
	}

	@RequestMapping("/searchByCity")
	public String searchByCity(Model model, @RequestParam String search) {
		ResponseEntity<Restaurant[]> entity = restTemplate.getForEntity("http://annapurna-restaurant/restaurants",
				Restaurant[].class);
		List<Restaurant> restaurantlist = Arrays.asList(entity.getBody());
		List<Restaurant> searchedList = new ArrayList<>();
		for (Restaurant restaurant : restaurantlist) {
			if (restaurant.getAddress().getCity().equalsIgnoreCase(search))
				searchedList.add(restaurant);
			if (restaurant.getAddress().getState().equalsIgnoreCase(search))
				searchedList.add(restaurant);
			if (restaurant.getAddress().getCountry().equalsIgnoreCase(search))
				searchedList.add(restaurant);
		}
		model.addAttribute("list", searchedList);
		return "Home";
	}

	private Restaurant restaurant;
	private Address address;
	private Cart cart;
	private Set<FoodProducts> products;
	private Integer count = 0;
	private FoodProducts foodProducts;

	@RequestMapping("/foodItems")
	public String getFoodItemsById(Model model, @RequestParam int restaurantId) {
		ResponseEntity<Restaurant> entity = restTemplate
				.getForEntity("http://annapurna-restaurant/restaurants/" + restaurantId, Restaurant.class);
		restaurant = entity.getBody();
		model.addAttribute("restaurant", entity.getBody());
		return "FoodItems";
	}
	
	@RequestMapping("/viewReviews")
	public String viewReviewsByResturant(Model model, @RequestParam int restaurantId) {
		ResponseEntity<Restaurant> entity = restTemplate
				.getForEntity("http://annapurna-restaurant/restaurants/" + restaurantId, Restaurant.class);
		restaurant = entity.getBody();
		model.addAttribute("restaurant", entity.getBody());
		return "viewReviews";
	}

	/******* Login ******/

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	/******** Profile ********/

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUpPage() {
		return "AccountForm";
		// return "NewFile";
	}

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public String createAccount(@ModelAttribute Profile profile, Model model) {
		profile.setPassword(bCryptPasswordEncoder.encode(profile.getPassword()));
		profile.setRole("USER");
		ResponseEntity<Profile> profileEntity = restTemplate.postForEntity("http://annapurna-profile/profiless",
				profile, Profile.class);
		Profile profile2 = profileEntity.getBody();
		EWallet eWallet = new EWallet();
		eWallet.setProfileId(profile2.getProfileId());
		eWallet.setCurrentBalance(0.0);
		restTemplate.postForEntity("http://annapurna-ewallet/ewallets", eWallet, EWallet.class);
		ResponseEntity<List> entity = restTemplate.getForEntity("http://annapurna-restaurant/restaurants", List.class);
		model.addAttribute("list", entity.getBody());
		return "Home";
	}

	@RequestMapping("/cart/userProfile")
	public String features(Model model) {
		Profile profile = customUserDetailsService.getCurrentUser();
		model.addAttribute("profile", profile);
		return "UserProfile";
	}

	@RequestMapping("/cart/updateAccounts")
	public String updateAccounts(@RequestParam("profileId") int profileId, Model model) {
//		System.out.println("Inside update");
		System.out.println(profileId);
		ResponseEntity<Profile> profile = restTemplate.getForEntity("http://annapurna-profile/profiless/" + profileId,
				Profile.class);
		model.addAttribute("profile", profile.getBody());
		return "updateForm";
	}

	/*
	 * @RequestMapping("/cart/updatedform") public String
	 * updatedformControl(@ModelAttribute Profile profile, Model model) {
	 * restTemplate.put("http://annapurna-profile/profiless/" +
	 * profile.getProfileId(), profile); ResponseEntity<List> entity =
	 * restTemplate.getForEntity("http://annapurna-restaurant/restaurants",
	 * List.class); model.addAttribute("list", entity.getBody()); return "Home"; }
	 */

	@RequestMapping("/cart/updatedform")
	public String updatedformControl(@ModelAttribute Profile profile, Model model) {
		restTemplate.put("http://annapurna-profile/profiless/" + profile.getProfileId(), profile);
		ResponseEntity<List> entity = restTemplate.getForEntity("http://annapurna-restaurant/restaurants", List.class);
		model.addAttribute("list", entity.getBody());
		return "redirect:/cart/userProfile";
	}

	@RequestMapping("/cart/gettingAccountFromId")
	public String getAccountFromId(@RequestParam("profileId") int profileId, Model model) {
		System.out.println("Inside the gettingAccountFromId");
		Profile profile = restTemplate.getForObject("http://annapurna-profile/profiless/" + profileId, Profile.class);
		// 0 System.out.println(profile.getAddress().getStreetName());
		model.addAttribute("profile", profile);
		return "ProfileDetails";
	}

	/******** Cart ********/

	@RequestMapping("/cart/getAll") // /cart/getAll
	public String getAllCarts(Model model) {
		System.out.println("getAll");
		ResponseEntity<List> carts = restTemplate.getForEntity("http://annapurna-cart/carts", List.class);
		model.addAttribute("carts", carts.getBody());
		return "GetAllCart";
	}

	/*
	 * @RequestMapping("/cart/addCart") public String addCart( @RequestParam String
	 * restaurantName, @RequestParam String foodName,
	 * 
	 * @RequestParam double price, @RequestParam int quantity ,@RequestParam Address
	 * address , Model model) { Set<FoodProducts> products = new
	 * HashSet<FoodProducts>(); products.add(new FoodProducts(foodName, price,
	 * quantity)); cart = new Cart(106, restaurant.getName(), products, price,
	 * restaurant.getAddress());
	 * restTemplate.postForEntity("http://annapurna-cart/carts", cart, Cart.class);
	 * model.addAttribute("cart", cart); return "GetAllCart"; }
	 */

	/*
	 * @RequestMapping("/cart/addCart") public String addCart( @RequestParam String
	 * restaurantName, @RequestParam String foodName,
	 * 
	 * @RequestParam double price, @RequestParam int quantity ,@RequestParam Address
	 * address , Model model) { count++; System.out.println(cart); if (count == 1) {
	 * products = new HashSet<FoodProducts>(); foodProducts = new
	 * FoodProducts(foodName, price, quantity); products.add(foodProducts); cart =
	 * new Cart(customUserDetailsService.getCurrentUser().getProfileId(),
	 * restaurant.getName(), products, price, restaurant.getAddress());
	 * restTemplate.postForEntity("http://annapurna-cart/carts"
	 * "http://10.246.92.254:8181/carts" , cart, Cart.class); //
	 * System.out.println(cart+"before update"); } else {
	 * 
	 * FoodProducts newfoodProducts = new FoodProducts(foodName, price, quantity);
	 * products.add(newfoodProducts); cart.setProducts(products);
	 * restTemplate.put("http://annapurna-cart/carts/"
	 * "http://10.246.92.254:8181/carts/" + cart.getCartId(), cart, Cart.class); //
	 * System.out.println(cart); }
	 * 
	 * model.addAttribute("restaurantId", restaurant.getRestaurantId());
	 * 
	 * ResponseEntity<Cart> entity = restTemplate.getForEntity(
	 * "http://10.246.92.254:8181/carts/" "http://annapurna-cart/carts/" +
	 * cart.getCartId() + "", Cart.class);
	 * 
	 * System.out.println(entity.getBody() + "after getting cart"); // cart=
	 * System.out.println(entity.getBody()); model.addAttribute("cart",
	 * entity.getBody());
	 * 
	 * return "GetAllCart"; }
	 */

	@RequestMapping("/cart/addCart")
    public String addCart(/* @RequestParam String restaurantName, */ @RequestParam String foodName,@RequestParam String restaurantName,
            @RequestParam double price, @RequestParam int quantity/* ,@RequestParam Address address */, Model model) {
        count++;
        
        System.out.println(cart);
        if (count == 1) {
            products = new HashSet<FoodProducts>();
            foodProducts = new FoodProducts(foodName, price, quantity);
            products.add(foodProducts);
            
            cart = new Cart(106, restaurant.getName(), products, price, restaurant.getAddress());
            restTemplate.postForEntity( "http://annapurna-cart/carts" /*"http://10.246.92.254:8181/carts"*/, cart,
                    Cart.class);
            
        } else {
            System.out.println(restaurantName);
            if(restaurantName.equalsIgnoreCase(cart.getRestaurantName())) {
            
                FoodProducts newfoodProducts = new FoodProducts(foodName, price, quantity);
                products=cart.getProducts();
                products.add(newfoodProducts);
                cart.setProducts(products);
            
                
				restTemplate.put(
						 "http://annapurna-cart/carts/" /* "http://10.246.92.254:8181/carts/" */+cart.getCartId(), cart,
                        Cart.class);
                
            }
            else {
                products = new HashSet<FoodProducts>();
                foodProducts = new FoodProducts(foodName, price, quantity);
                products.add(foodProducts);
                cart = new Cart(106, restaurantName, products, price, restaurant.getAddress());
                restTemplate.postForEntity( "http://annapurna-cart/carts" /*"http://10.246.92.254:8181/carts"*/, cart,
                        Cart.class);
               // count=0;
            }
        }
 
        model.addAttribute("restaurantId", restaurant.getRestaurantId());
 
        ResponseEntity<Cart> entity = restTemplate
                .getForEntity("http://annapurna-cart/carts/" + cart.getCartId() + "", Cart.class);
 
         System.out.println(entity.getBody() + "after getting cart"); // cart=
        System.out.println(entity.getBody());
        model.addAttribute("cart",entity.getBody());
 
        return "GetAllCart";
    }
	
	private Integer getUniqueId() {
		UUID idOne = UUID.randomUUID();
		int uid = idOne.hashCode();
		return uid;
	}

	/* private static Set<FoodProducts> orderProducts; */

	/******** Order ********/

	@RequestMapping("/cart/getById")
	public String getOrderById(@RequestParam("orderId") Integer orderId, Model model) {
		ResponseEntity<Order> order = restTemplate.getForEntity("http://annapurna-order/orders/" + orderId + " ",
				Order.class);
		System.out.println(order.getBody());
		model.addAttribute("message", "heyyyyyyyy !!!!");
		model.addAttribute("Order", order.getBody());
		return "Order";
	}

	/*
	 * @RequestMapping("/cart/submitAddress") public String
	 * placeOrder(@ModelAttribute Address address1, Model model) { address =
	 * address1; model.addAttribute("totalAmount", cart.getTotalAmount()); return
	 * "passMoney"; }
	 */

	@RequestMapping("/cart/submitAddress")
	public String placeOrder(@ModelAttribute Address address1, Model model) {
		address = address1;

		return /* "passMoney" */"selectPaymentGateWay";
	}

	@RequestMapping("/cart/placeOrder")
	public String getPlaceOrder(

			@RequestParam("quantity") List<Integer> quantityList, @RequestParam("amount") Double totalAmount,
			Model model) {

		Iterator iterator = products.iterator();

		while (iterator.hasNext()) {

			FoodProducts product = (FoodProducts) iterator.next();
			int i = 0;
			int j = 0;

			System.out.println(quantityList.get(i).toString());
			String y = quantityList.get(i).toString();
			System.out.println(Integer.parseInt(y));
			j = Integer.parseInt(y);

			i++;
			product.setQuantity(j);
			// System.out.println(product);
		}

		cart.setTotalAmount(totalAmount);
		// System.out.println(quantityList);
		// System.out.println(totalAmount);
		return "AddressForm";
	}

	@RequestMapping("/ewallet")
	public String getPassMoneyForm(Model model) {
		model.addAttribute("totalAmount", cart.getTotalAmount());
		return "passMoney";

	}

	@RequestMapping("/cart/removeFoodProduct")
	public String removeFromCart(/* @ModelAttribute Cart cart, */@RequestParam("restaurantId") Integer restaurantId,
			@RequestParam("foodName") String foodName, @RequestParam("id") Integer id,
			@RequestParam("cartId") Integer cartId, Model model) {

		// System.out.println(foodName);

		ResponseEntity<Cart> entity1 = restTemplate.getForEntity(
				/* "http://10.246.92.254:8181/carts/" */"http://annapurna-cart/carts/" + cart.getCartId() + "",
				Cart.class);
		cart = entity1.getBody();
		Set<FoodProducts> products = cart.getProducts();

		Set<FoodProducts> products1 = new HashSet();
		Iterator iterator = products.iterator();

		while (iterator.hasNext()) {

			FoodProducts product = (FoodProducts) iterator.next();
			// System.out.println(product.getFoodName());
			if (product.getFoodName().equalsIgnoreCase(foodName)) {
				continue;
			} else {
				products1.add(product);
			}
		}

		// System.out.println(products1);
		cart.setProducts(products1);
		restTemplate.postForEntity("http://annapurna-cart/carts" /* "http://10.246.92.254:8181/carts" */, cart,
				Cart.class);
		ResponseEntity<Cart> entity = restTemplate.getForEntity(
				/* "http://10.246.92.254:8181/carts/" */ "http://annapurna-cart/carts/" + cart.getCartId() + "",
				Cart.class);
		// System.out.println(entity.getBody());
		model.addAttribute("cart", entity.getBody());
		model.addAttribute("restaurantId", restaurantId);
		if (cart.getProducts().size() == 0) {
			count = 0;
		} else {
			count = 1;
		}
		return "GetAllCart";
	}

	@RequestMapping("/cancelOrder")
	public String cancelOrder(@RequestParam("orderId") Integer orderId, Model model) {
		System.out.println(orderId);
		restTemplate.delete(/* "http://10.246.92.254:9090/orders/" */ "http://annapurna-order/orders/" + orderId + "",
				Order.class);

		ResponseEntity<List> list1 = restTemplate
				.getForEntity("http://annapurna-order/orders?cartId=" + cart.getCartId(), List.class);

		model.addAttribute("list", list1.getBody());
		return "Order";

	}

	/*
	 * @RequestMapping("/cart/placeOrder") public String getPlaceOrder( @RequestBody
	 * Cart cart, Model model) { Set<FoodProducts> products = new
	 * HashSet<FoodProducts>(); products.add(new FoodProducts("Brinjal", 234, 12));
	 * orderProducts = products; return "AddressForm"; }
	 */

	/******** eWallet ********/

	/*
	 * @RequestMapping("/cart/passMoneyForm") public String deduct( @RequestParam
	 * Integer profileId, @RequestParam Double amount, Model model) {
	 * restTemplate.put("http://annapurna-ewallet/ewallets/" + 1 +
	 * "/pay?currentBalance=" + amount, null); model.addAttribute("message",
	 * "money deducted and Order placed Successfully!"); String modeOfPayment =
	 * "E-Wallet"; // for now Double totalAmount = 100.0; // for now String
	 * restaurantName = "GrandMama's Cafe"; // for now Integer id = getUniqueId();
	 * Order order = new Order(id, modeOfPayment, "pending", cart.getProducts(),
	 * cart.getTotalAmount(), cart.getRestaurantName(), address, cart.getCartId());
	 * ResponseEntity<Order> order1 =
	 * restTemplate.postForEntity("http://annapurna-order/orders", order,
	 * Order.class); model.addAttribute("Order", order1.getBody());
	 * System.out.println(order1.getBody()); return "Order"; }
	 */

	@RequestMapping("/cart/passMoneyForm")
	public String deduct(/* @RequestParam Integer profileId, */ @RequestParam Double amount, Model model) {
		restTemplate.put("http://annapurna-ewallet/ewallets/"
				/* "http://10.246.92.254:7979/ewallets/" */ + customUserDetailsService.getCurrentUser().getProfileId()
				+ "/pay?currentBalance=" + amount, null);
		model.addAttribute("message", "money deducted and Order placed Successfully!");
		String modeOfPayment = "E-Wallet"; // for now

		Integer id = getUniqueId();
		Order order = new Order(id, modeOfPayment, "pending", cart.getProducts(), cart.getTotalAmount(),
				cart.getRestaurantName(), address, cart.getCartId());
		restTemplate.postForEntity("http://annapurna-order/orders" /* "http://10.246.92.254:9090/orders" */, order,
				Order.class);

		ResponseEntity<List> list1 = restTemplate
				.getForEntity("http://annapurna-order/orders?cartId=" + cart.getCartId(), List.class);

		model.addAttribute("list", list1.getBody());
		System.out.println(list1.getBody());
		count = 0;
		return "Order";
	}

	@RequestMapping("/cart/AddMoneyLink")
	public String depositForm(@RequestParam Integer profileId, Model model) {
		model.addAttribute("profileId", profileId);
		return "addMoney";
	}

	@RequestMapping("/cart/AddMoneyForm")
	public String deposit(@RequestParam Integer profileId, @RequestParam Double amount, Model model,
			RedirectAttributes redirectAttributes) {
		System.out.println("profileId " + profileId);
		restTemplate.put("http://annapurna-ewallet/ewallets/" + profileId + "?currentBalance=" + amount, null);
		redirectAttributes.addAttribute("profileId", profileId);
		return "redirect:/cart/currentEWalletBalance";
	}

	@RequestMapping("/cart/currentEWalletBalance")
	public String getWalletBalance(@RequestParam Integer profileId, Model model) {
		ResponseEntity<Double> entity = restTemplate.getForEntity("http://annapurna-ewallet/ewallets/" + profileId,
				Double.class);
		model.addAttribute("currentBalance", entity.getBody());
		model.addAttribute("profile", customUserDetailsService.getCurrentUser());
		return "EWalletBalance";
	}

	@RequestMapping("/cart/PassMoneyLink")
	public String deductAmount() {
		return "passMoney";
	}

	@RequestMapping("/cart/StatementForm")
	public String statementForm() {
		return "statements";
	}

	@RequestMapping("/cart/statement")
	public String statement(@RequestParam Integer profileId, Model model) {
		ResponseEntity<List> entity = restTemplate
				.getForEntity("http://annapurna-ewallet/ewallets/statements/" + profileId, List.class);
		List<Statement> statements = entity.getBody();
		System.out.println(statements);
		model.addAttribute("statements", statements);
		return "statements";
	}

}
