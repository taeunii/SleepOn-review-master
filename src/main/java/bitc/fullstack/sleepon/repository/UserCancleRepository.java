package bitc.fullstack.sleepon.repository;

import bitc.fullstack.sleepon.model.UserCancel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserCancleRepository extends JpaRepository<UserCancel, Integer> {
    List<UserCancel> findAllByOrderByIdxDesc(); // 관리자 전용 모든 상담 문의 목록 보기

    @Modifying
    @Transactional
    @Query("UPDATE UserCancel uc SET uc.reply = :reply, uc.replyDate = CURRENT_TIMESTAMP WHERE uc.idx = :id")
    void updateReply(@Param("id") int id, @Param("reply") String reply);


    @Query("SELECT COUNT(c) FROM UserCancel c WHERE c.user.id = :id")
    int countByUserId(@Param("id") String id); // 고객 전용 내 문의 개수

    List<UserCancel> findByUserIdOrderByIdxDesc(@Param("id") String id); // 고객 전용 내 문의 내용

    void deleteByIdx(int id); // 고객 전용 삭제
}
