package bitc.fullstack.sleepon.repository;

import bitc.fullstack.sleepon.model.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserReviewRepository extends JpaRepository<UserReview, Integer> {

    @Query("SELECT u FROM UserReview u WHERE u.user.id = :id AND u.reviewSubmitted = 'Y' ORDER BY u.createdAt DESC")
    List<UserReview> findByUserIdOrderByCreatedAtDesc(@Param("id") String id); // 고객 전용 작성한 내 리뷰 내용

    @Query("SELECT COUNT(c) FROM UserReview c WHERE c.user.id = :id AND c.reviewSubmitted = 'Y'")
    int countByUserId(@Param("id") String id); // 고객 전용 내가 작성한 리뷰 개수
}