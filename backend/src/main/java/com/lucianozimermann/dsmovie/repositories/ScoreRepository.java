package com.lucianozimermann.dsmovie.repositories;
 
import org.springframework.data.jpa.repository.JpaRepository;

import com.lucianozimermann.dsmovie.entities.Score;
import com.lucianozimermann.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{

}
