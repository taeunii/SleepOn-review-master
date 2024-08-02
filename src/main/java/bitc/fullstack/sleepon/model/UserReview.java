package bitc.fullstack.sleepon.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sleep_on_review")
public class UserReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private SleepOnUser user; // 유저

    @ManyToOne
    @JoinColumn(name = "reserv_id", nullable = false)
    private UserReservation reservation; // 예약번호

    @Column(name = "review_location_num", nullable = false)
    private int reviewLocationNum; // 별점(위치)

    @Column(name = "review_checkin_num", nullable = false)
    private int reviewCheckinNum; // 별점(체크인)

    @Column(name = "review_communication_num", nullable = false)
    private int reviewCommunicationNum; // 별점(의사소통)

    @Column(name = "review_cleanliness_num", nullable = false)
    private int reviewCleanlinessNum; // 별점(청결도)

    @Column(name = "review_satisfaction_num", nullable = false)
    private int reviewSatisfactionNum; // 별점(만족도)

    @Column(name = "review_text", nullable = false, length = 2000)
    private String reviewText; // 후기

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt; // 리뷰 등록일

    @Column(name = "updated_at")
    private LocalDateTime updatedAt; //리뷰 수정일

    @Column(name = "content_id", nullable = false)
    private String contentId; // 숙소번호

    @Column(name = "review_submitted", length = 1, nullable = false)
    private String reviewSubmitted = "N"; // 리뷰 제출 여부


    // Getters and Setters
    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public SleepOnUser getUser() {
        return user;
    }

    public void setUser(SleepOnUser user) {
        this.user = user;
    }

    public UserReservation getReservation() {
        return reservation;
    }

    public void setReservation(UserReservation reservation) {
        this.reservation = reservation;
    }

    public int getReviewLocationNum() {
        return reviewLocationNum;
    }

    public void setReviewLocationNum(int reviewLocationNum) {
        this.reviewLocationNum = reviewLocationNum;
    }

    public int getReviewCheckinNum() {
        return reviewCheckinNum;
    }

    public void setReviewCheckinNum(int reviewCheckinNum) {
        this.reviewCheckinNum = reviewCheckinNum;
    }

    public int getReviewCommunicationNum() {
        return reviewCommunicationNum;
    }

    public void setReviewCommunicationNum(int reviewCommunicationNum) {
        this.reviewCommunicationNum = reviewCommunicationNum;
    }

    public int getReviewCleanlinessNum() {
        return reviewCleanlinessNum;
    }

    public void setReviewCleanlinessNum(int reviewCleanlinessNum) {
        this.reviewCleanlinessNum = reviewCleanlinessNum;
    }

    public int getReviewSatisfactionNum() {
        return reviewSatisfactionNum;
    }

    public void setReviewSatisfactionNum(int reviewSatisfactionNum) {
        this.reviewSatisfactionNum = reviewSatisfactionNum;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getReviewSubmitted() {
        return reviewSubmitted;
    }

    public void setReviewSubmitted(String reviewSubmitted) {
        this.reviewSubmitted = reviewSubmitted;
    }

    //    별점 평균
    public int avg_reviewnum() {
        int avgReviewNum = 0;

        avgReviewNum = (getReviewLocationNum() + getReviewCheckinNum() + getReviewCommunicationNum() + getReviewCleanlinessNum() + getReviewSatisfactionNum()) / 5;

        return avgReviewNum;
    }

    //    리뷰가 제출된 경우 true 반환
    public boolean isReviewSubmitted() {
        return "Y".equals(reviewSubmitted);
    }
}
