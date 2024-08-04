package bitc.fullstack.sleepon.repository;

import bitc.fullstack.sleepon.model.UserCancel;
import bitc.fullstack.sleepon.model.UserReservation;
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

    @Query("SELECT COUNT(u) FROM UserReview u WHERE u.user.id = :id AND u.reviewSubmitted = 'Y'")
    int countByUserId(@Param("id") String id); // 고객 전용 내가 작성한 리뷰 개수

    void deleteByIdx(int id); // 리뷰 삭제

//    @Query("SELECT u FROM UserReview u WHERE u.contentId = :contentId ORDER BY u.createdAt DESC")
//    List<UserReview> findByContentIdOrderByCreatedAtDesc(String contentId); // 호텔별 고객 리뷰 목록 보기
    @Query("SELECT u FROM UserReview u WHERE u.reservation.contentId = :contentId ORDER BY u.createdAt DESC")
    List<UserReview> findByContentIdOrderByCreatedAtDesc(@Param("contentId") String contentId);

    @Query("SELECT COUNT(u) FROM UserReview u WHERE u.reservation.contentId = :contentId AND u.reviewSubmitted = 'Y'")
    int countByContentId(@Param("contentId") String contentId); // 숙소별 작성된 리뷰 개수

}