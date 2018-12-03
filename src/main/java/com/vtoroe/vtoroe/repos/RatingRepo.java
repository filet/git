package com.vtoroe.vtoroe.repos;


import com.vtoroe.vtoroe.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepo extends JpaRepository<Rating,Long> {
    List<Rating> findByRating(int rating);
}
