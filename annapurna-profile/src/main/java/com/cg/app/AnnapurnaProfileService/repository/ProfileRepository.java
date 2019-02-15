package com.cg.app.AnnapurnaProfileService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.cg.app.AnnapurnaProfileService.entity.Profile;


@Repository
public interface ProfileRepository extends MongoRepository<Profile, Object>{

	Profile findByUserName(String userName);
}
