package com.onlineshopping.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineshopping.model.Review;
import com.onlineshopping.model.User;
//@Repository
//public interface ReviewDao extends JpaRepository<Review, Integer>  {
//
//  Review addReview(Review review) ;
//	
//	
//}

@Repository
public interface ReviewDao extends JpaRepository<Review, Long> {
    Review save(Review review);

	Optional<Review> findByProductId(int productId);

	List<Review> findByProduct_Id(int productId);
}
