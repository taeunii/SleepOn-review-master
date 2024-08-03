package bitc.fullstack.sleepon.repository;

import bitc.fullstack.sleepon.model.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserReviewRepository extends JpaRepository<UserReview, Integer> {

    @Query("SELECT u FROM UserReview u WHERE u.user.id = :id AND u.reviewSubmitted = 'Y' ORDER BY u.createdAt DESC")
    List<UserReview> findByUserIdOrderByCreatedAtDesc(@Param("id") String id); // 고객 전용 작성한 내 리뷰 내용

    @Query("SELECT COUNT(c) FROM UserReview c WHERE c.user.id = :id AND c.reviewSubmitted = 'Y'")
    int countByUserId(@Param("id") String id); // 고객 전용 내가 작성한 리뷰 개수

    @Modifying
    @Transactional
    @Query("UPDATE UserReview ur " +
            "SET ur.reviewLocationNum = :reviewLocationNum, " +
            "ur.reviewCheckinNum = :reviewCheckinNum, " +
            "ur.reviewCommunicationNum = :reviewCommunicationNum, " +
            "ur.reviewCleanlinessNum = :reviewCleanlinessNum, " +
            "ur.reviewSatisfactionNum = :reviewSatisfactionNum, " +
            "ur.reviewText = :reviewText, " +
            "ur.updatedAt = CURRENT_TIMESTAMP " +
            "WHERE ur.idx = :id")
    void updateReview(@Param("id") int id,
                      @Param("reviewLocationNum") int reviewLocationNum,
                      @Param("reviewCheckinNum") int reviewCheckinNum,
                      @Param("reviewCommunicationNum") int reviewCommunicationNum,
                      @Param("reviewCleanlinessNum") int reviewCleanlinessNum,
                      @Param("reviewSatisfactionNum") int reviewSatisfactionNum,
                      @Param("reviewText") String reviewText);

    void deleteByIdx(int id);
}