package com.lucianozimermann.dsmovie.repositories;
 
import org.springframework.data.jpa.repository.JpaRepository;

import com.lucianozimermann.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
}
