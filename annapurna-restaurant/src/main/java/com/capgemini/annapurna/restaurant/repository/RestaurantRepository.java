/**
 * 
 */
package com.capgemini.annapurna.restaurant.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.annapurna.restaurant.entity.Restaurant;

/**
 * @author ugawari
 * 
 * The repository class uses mongoDb to store data.
 * and extends mongoRepository interface to perform crud operations.
 */
@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, Integer>{

}
