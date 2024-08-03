package bitc.fullstack.sleepon.service;

import bitc.fullstack.sleepon.dto.FullDataItemDTO;
import bitc.fullstack.sleepon.dto.FullDataResponseDTO;
import bitc.fullstack.sleepon.dto.detail.DataItemDTO;
import bitc.fullstack.sleepon.dto.detail.DataResponseDTO;
import bitc.fullstack.sleepon.dto.event.FullEventDataItemDTO;
import bitc.fullstack.sleepon.dto.event.FullEventDataResponseDTO;
import bitc.fullstack.sleepon.dto.infor.DataComItemDTO;
import bitc.fullstack.sleepon.dto.infor.DataComResponseDTO;
import bitc.fullstack.sleepon.mapper.LocationMapper;
import bitc.fullstack.sleepon.model.UserCancel;
import bitc.fullstack.sleepon.model.UserReservation;
import bitc.fullstack.sleepon.model.UserReview;
import bitc.fullstack.sleepon.repository.SleepOnUserRepository;
import bitc.fullstack.sleepon.repository.UserCancleRepository;
import bitc.fullstack.sleepon.repository.UserReservationRepository;
import bitc.fullstack.sleepon.repository.UserReviewRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TourServiceImpl implements TourService{
    @Autowired
    LocationMapper locationMapper;

    @Autowired
    UserReservationRepository reservationRepository;

    @Autowired
    UserCancleRepository ucRepository;

    @Autowired
    UserReviewRepository reviewRepository;
    @Autowired
    private UserReviewRepository userReviewRepository;
    @Autowired
    private SleepOnUserRepository sleepOnUserRepository;

    @Override
    public List<FullDataItemDTO> getItemListUrl(String serviceUrl) throws Exception {
        List<FullDataItemDTO> itemList = new ArrayList<>();
        URL url = null;
        HttpURLConnection urlConn = null;

        try{
            url = new URL(serviceUrl);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod("GET");

            JAXBContext jc = JAXBContext.newInstance(FullDataResponseDTO.class);
            Unmarshaller um = jc.createUnmarshaller();

            FullDataResponseDTO fullData = (FullDataResponseDTO)
 um.unmarshal(url);
            itemList = fullData.getBody().getItems().getItemList();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Failed to retrieve data from the service URL: " + serviceUrl, e);
        }
        finally {
            if (urlConn != null) { urlConn.disconnect(); }
        }
        return itemList;
    }
    // 지역 행사
    @Override
    public List<FullEventDataItemDTO> getEventItemListUrl(String serviceUrl) throws Exception {
        System.out.println("\n지역행사 : " + serviceUrl);
        List<FullEventDataItemDTO> itemList = new ArrayList<>();
        URL url = null;
        HttpURLConnection urlConn = null;

        try {
            url = new URL(serviceUrl);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod("GET");

            JAXBContext jc = JAXBContext.newInstance(FullEventDataResponseDTO.class);
            Unmarshaller um = jc.createUnmarshaller();

            FullEventDataResponseDTO fullData = (FullEventDataResponseDTO) um.unmarshal(url);
            itemList = fullData.getBody().getItems().getItemList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Failed to retrieve data from the service URL: " + serviceUrl, e);
        } finally {
            if (urlConn != null) {
                urlConn.disconnect();
            }
        }
        return itemList;
    }

    @Override
    public Map<String, String> getSigunguMap(String areaCode) {
        return locationMapper.getSigunguMapList(areaCode);
    }

    @Override
    public String getSigunguName(String areaCode, String key) {
        return locationMapper.getSigunguMapList(areaCode).get(key);
    }

    @Override
    public String getAreaName(String areaCode) throws Exception {
        return locationMapper.getAreaMap(areaCode);
    }

    // 숙소 공통 정보
    @Override
    public List<DataComItemDTO> getInforItemList(String serviceUrl) throws Exception {
        List<DataComItemDTO> itemList = new ArrayList<>();
        URL url = null;
        HttpURLConnection urlConn = null;

        try{
            url = new URL(serviceUrl);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod("GET");

            JAXBContext jc = JAXBContext.newInstance(DataComResponseDTO.class);
            Unmarshaller um = jc.createUnmarshaller();

            DataComResponseDTO fullData = (DataComResponseDTO)
                    um.unmarshal(url);

            itemList = fullData.getBody().getItems().getItemList();

            // 소분류 코드에 해당하는 이름 가져오기
            for (DataComItemDTO item : itemList) {
                String smallClassificationCode = item.getCat3();
                String smallClassificationName = locationMapper.getSmallClassificationName(smallClassificationCode);
                item.setSmallClassificationName(smallClassificationName); // 수동으로 필드 설정
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Failed to retrieve data from the service URL: " + serviceUrl, e);
        }
        finally {
            if (urlConn != null) { urlConn.disconnect(); }
        }
        return itemList;
    }

    // 숙소 세부 정보 (객실 가격)
    @Override
    public List<DataItemDTO> getDetailItemList(String serviceUrl) throws Exception {
        List<DataItemDTO> itemList = new ArrayList<>();
        URL url = null;
        HttpURLConnection urlConn = null;

        try {
            url = new URL(serviceUrl);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod("GET");

            JAXBContext jc = JAXBContext.newInstance(DataResponseDTO.class);
            Unmarshaller um = jc.createUnmarshaller();

            DataResponseDTO fullData = (DataResponseDTO) um.unmarshal(url);
            itemList = fullData.getBody().getItems().getItemList();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Failed to retrieve data from the service URL: " + serviceUrl, e);
        }
        finally {
            if (urlConn != null) { urlConn.disconnect(); }
        }
        return itemList;
    }

    // 예약 디비 저장
    @Override
    public void saveReservation(UserReservation reservation) {
        reservationRepository.save(reservation);
    }

    // 예약 내역 가져오기
    @Override
    public List<UserReservation> getUserReservation(String userId) throws Exception{
        return reservationRepository.findByUserId(userId);
    }

    // 내 예약 정보 가져오기 (체크인 예정만)
    @Override
    public List<UserReservation> getUserReservationDesc(String userId) throws Exception {
        List<UserReservation> reservations = reservationRepository.findByUserIdOrderByReservDataDesc(userId);
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 필터링을 통해 현재 날짜 이후의 체크인 날짜를 가진 예약만 반환
        return reservations.stream()
                .filter(reservation -> {
                    LocalDate checkinDate = LocalDate.parse(reservation.getCheckinTime() , formatter);
                    return checkinDate.isAfter(currentDate);
                })
                .collect(Collectors.toList());
    }

    // 지난 예약 정보 - 취소 안한 것만
    @Override
    public List<UserReservation> getUserLastReserv(String userId) throws Exception {
        List<UserReservation> reservations = reservationRepository.findByUserIdLastReserv(userId);
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 필터링을 통해 체크아웃 날짜가 현재 날짜 이전인 예약만 반환
        return reservations.stream()
                .filter(reservation -> {
                    LocalDate checkoutDate = LocalDate.parse(reservation.getCheckoutTime(), formatter);
                    return checkoutDate.isBefore(currentDate);
                })
                .collect(Collectors.toList());
    }

    // 관리자 고객 상담 게시글 목록
    @Override
    public List<UserCancel> getAdminCancelList() throws Exception {
        return ucRepository.findAllByOrderByIdxDesc();
    }

    // 관리자 전용 상담 답글
    @Override
    public void saveReply(int id, String reply) throws Exception {
        ucRepository.updateReply(id, reply);
    }

    // 문의 내역
    @Override
    public int getCountCancelUser(String id) throws Exception {
        return ucRepository.countByUserId(id);
    }

    // 고객 전용 내 문의 내역 보기
    @Override
    public List<UserCancel> getUserCancelList(String id) throws Exception {
        return ucRepository.findByUserIdOrderByIdxDesc(id);
    }

    // 고객 전용 문의 작성
    @Override
    public void saveUserCancel(UserCancel userCancel) throws Exception {
        ucRepository.save(userCancel);
    }

    // 고객 문의 삭제
    @Override
    @Transactional
    public void deleteUserCancel(int id) throws Exception {
        ucRepository.deleteByIdx(id);
    }

    // 고객 전용 내가 작성한 리뷰 내역 보기
    @Override
    public List<UserReview> getUserReviewList(String id) throws Exception {
        return reviewRepository.findByUserIdOrderByCreatedAtDesc(id);
    }

    // 내가 작성한 리뷰 수
    @Override
    public int getCountReviewUser(String id) throws Exception {
        return reviewRepository.countByUserId(id);
    }

    // 내가 작성한 리뷰
    @Override
    public UserReview getReviewById(int id) throws Exception {
        return reviewRepository.findById(id).orElse(null);
    }

    // 내가 예약한 숙소 정보 가져오기
    @Override
    public UserReservation getUserReservationIdx(int idx) throws Exception {
        return reservationRepository.findByIdx(idx);
    }


    // 고객 전용 리뷰 저장
    @Override
    public void saveUserReview(UserReview userReview) throws Exception {
        reviewRepository.save(userReview);
    }

    // 고객 전용 리뷰 수정
    @Override
    public void updateUserReview(int id,
                                 int reviewLocationNum,
                                 int reviewCheckinNum,
                                 int reviewCommunicationNum,
                                 int reviewCleanlinessNum,
                                 int reviewSatisfactionNum,
                                 String reviewText) throws Exception {
        userReviewRepository.updateReview(id, reviewLocationNum, reviewCheckinNum, reviewCommunicationNum, reviewCleanlinessNum, reviewSatisfactionNum, reviewText);
    }


    // 고객 리뷰 삭제
    @Override
    @Transactional
    public void deleteUserReview(int id) throws Exception {
        reviewRepository.deleteByIdx(id);
    }
}
