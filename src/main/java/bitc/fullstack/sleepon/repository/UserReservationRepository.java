
package bitc.fullstack.sleepon.repository;

import bitc.fullstack.sleepon.model.UserReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserReservationRepository extends JpaRepository<UserReservation, Long> {
    List<UserReservation> findByUserId(String userId);

    @Query("SELECT u FROM UserReservation u WHERE u.user.id = :userId ORDER BY u.idx DESC, u.reservCancel ASC")
    List<UserReservation> findByUserIdOrderByReservDataDesc(@Param("userId") String userId);

    // 지난 예약 목록 - 리뷰 작성 안한 예약 목록만 출력
    @Query("SELECT r FROM UserReservation r LEFT JOIN UserReview u ON r.idx = u.reservation.idx " +
            "WHERE r.user.id = :userId AND r.reservCancel = 'N' AND u.idx IS NULL ORDER BY r.idx DESC")
    List<UserReservation> findUserLastReservWithoutReview(@Param("userId") String userId);


    UserReservation findByIdx(int idx);
}
