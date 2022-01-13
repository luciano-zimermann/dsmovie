package com.lucianozimermann.dsmovie.repositories;
 
import org.springframework.data.jpa.repository.JpaRepository;

import com.lucianozimermann.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}
