package bitc.fullstack.sleepon.service;

import bitc.fullstack.sleepon.dto.FullDataItemDTO;
import bitc.fullstack.sleepon.dto.detail.DataItemDTO;
import bitc.fullstack.sleepon.dto.infor.DataComItemDTO;
import bitc.fullstack.sleepon.dto.event.FullEventDataItemDTO;
import bitc.fullstack.sleepon.model.UserCancel;
import bitc.fullstack.sleepon.model.UserReservation;
import bitc.fullstack.sleepon.model.UserReview;

import java.util.List;
import java.util.Map;

public interface TourService {
    List<FullDataItemDTO> getItemListUrl(String serviceUrl) throws Exception;

    List<FullEventDataItemDTO> getEventItemListUrl(String serviceUrl) throws Exception;

    Map<String, String> getSigunguMap(String areaCode) throws Exception;
    String getSigunguName(String areaCode, String key) throws Exception;
    String getAreaName(String areaCode) throws Exception;

    List<DataComItemDTO> getInforItemList(String serviceUrl) throws Exception;

    List<DataItemDTO> getDetailItemList(String serviceUrl) throws Exception;

    // 예약
    void saveReservation(UserReservation reservation);
    // 예약 정보 가져오기
    List<UserReservation> getUserReservation(String userId) throws Exception;
    // 고객 전용 예약 정보
    List<UserReservation> getUserReservationDesc(String userId) throws Exception;
    // 지난 예약 목록 - 예약 취소 안한 목록만
    List<UserReservation> getUserLastReservWithoutReview(String userId) throws Exception;

    // 관리자 전용 상담 게시글 목록
    List<UserCancel> getAdminCancelList() throws Exception;
    // 관리자 전용 답변 업로드
    void saveReply(int id, String reply) throws Exception;

    // 문의 내역 개수 조회
    int getCountCancelUser(String id) throws Exception;

    // 고객 전용 내가 작성한 문의 내역 목록
    List<UserCancel> getUserCancelList(String id) throws Exception;
    // 고객 전용 문의 작성
    void saveUserCancel(UserCancel userCancel) throws Exception;
    // 고객 문의 삭제
    void deleteUserCancel(int id) throws Exception;

    // 고객 전용 내가 작성한 리뷰 내역
    List<UserReview> getUserReviewList(String id) throws Exception;
    // 내가 작성한 리뷰 수
    int getCountReviewUser(String id) throws Exception;

    // 내가 작성한 리뷰 보기
    UserReview getReviewById(int id) throws Exception;

    // 내가 예약한 숙소정보 가져오기
    UserReservation getUserReservationIdx(int idx) throws Exception;

    // 고객 전용 리뷰 작성
    void saveUserReview(UserReview userReview) throws Exception;

    // 고객 전용 리뷰 수정
    void updateUserReview(int id,
                          int reviewLocationNum,
                          int reviewCheckinNum,
                          int reviewCommunicationNum,
                          int reviewCleanlinessNum,
                          int reviewSatisfactionNum,
                          String reviewText) throws Exception;

    // 고객 리뷰 삭제
    void deleteUserReview(int id) throws Exception;

    // 호텔별 리뷰 목록
//    List<UserReview> getReviewsByContentId(String contentId) throws Exception;
    List<UserReview> getReviewsByContentId(String contentId) throws Exception;

    // 숙소별 작성한 리뷰 수
    int getCountReviewContentId(String contentId) throws Exception;
}