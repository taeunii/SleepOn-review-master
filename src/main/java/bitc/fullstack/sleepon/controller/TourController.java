package bitc.fullstack.sleepon.controller;

import bitc.fullstack.sleepon.dto.FullDataItemDTO;
import bitc.fullstack.sleepon.dto.detail.DataItemDTO;
import bitc.fullstack.sleepon.dto.event.FullEventDataItemDTO;
import bitc.fullstack.sleepon.dto.infor.DataComItemDTO;
import bitc.fullstack.sleepon.model.SleepOnUser;
import bitc.fullstack.sleepon.model.UserCancel;
import bitc.fullstack.sleepon.model.UserReservation;
import bitc.fullstack.sleepon.model.UserReview;
import bitc.fullstack.sleepon.repository.UserCancleRepository;
import bitc.fullstack.sleepon.repository.UserReservationRepository;
import bitc.fullstack.sleepon.repository.UserReviewRepository;
import bitc.fullstack.sleepon.service.TourService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/SleepOn")
public class TourController {

    @Autowired
    TourService tourService;

    @Value("${SleepOn.service.key}")
    private String APIkey;

    @Value("${SleepOn.service.Url}")
    private String APIUrl;

    // 숙소 기본 정부 ( 시설 정보, 이용 안내)
    @Value("${SleepOn.service.Infor.Url}")
    private String APIInforUrl;

    // 숙소 세부 정부 (객실, 가격)
    @Value("${SleepOn.service.detail.Url}")
    private String APIDetailUrl;

    // 지역 행사
    @Value("${SleepOnEvent.service.Url}")
    private String eventApiurl;

    @Autowired
    private UserReservationRepository userReservationRepository;
    @Autowired
    private UserCancleRepository userCancleRepository;
    @Autowired
    private UserReviewRepository userReviewRepository;

    @RequestMapping(value = {"", "/"})
    public String SleepOnService(HttpServletRequest request, Model model) {
        addSessionAttributesToModel(request, model);
        return "page/SleepOnMain";
    }

    @GetMapping("/login")
    public String SleepOnLogin() throws Exception {
        return "member/login";
    }

    @GetMapping("/register")
    public String SleepOnRegister() throws Exception {
        return "member/register";
    }

    @GetMapping("/logout")
    public String SleepOnLogout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/SleepOn";
    }

    // 숙소 정보 보기 ajax 통신
    @ResponseBody
    @RequestMapping("/selectArea")
    public Object SleepOnService(@RequestParam("areaCode") String areaCode, @RequestParam("sigunguCode") String sigunguCode, @RequestParam("arrange") String arrange, @RequestParam("numOfRows") String numOfRows, @RequestParam("pageNo") String pageNo) throws Exception {
        System.out.println("main 페이지에서 선택 : " + areaCode);
//http://apis.data.go.kr/B551011/KorService1/searchStay1?areaCode=&sigunguCode=&ServiceKey=인증키&listYN=Y&MobileOS=ETC&MobileApp=AppTest&arrange=A&numOfRows=12&pageNo=1
        String opt1 = "?areaCode="; // 지역코드
        String opt2 = "&sigunguCode="; // 시군구코드
        String opt3 = "&ServiceKey=";
        String opt4 = "&listYN=Y&MobileOS=ETC&MobileApp=AppTest";
        String opt5 = "&arrange="; // 정렬순(사진있는거만)
        String opt6 = "&numOfRows=";
        String opt7 = "&pageNo=";

        List<FullDataItemDTO> itemList = tourService.getItemListUrl(APIUrl + opt1 + areaCode + opt2 + sigunguCode + opt3 + APIkey + opt4 + opt5 + arrange + opt6 + numOfRows + opt7 + pageNo);

        return itemList;
    }

    // 지역 축제 조회 ajax 통신
    @ResponseBody
    @RequestMapping("/FestivalArea")
    public Object SearchFestival(@RequestParam("areaCode") String areaCode) throws Exception {
        //https://apis.data.go.kr/B551011/KorService1/searchFestival1?areaCode=1&serviceKey=&numOfRows=200&pageNo=1&MobileOS=ETC&MobileApp=AppTest&listYN=Y&arrange=R&eventStartDate=20240101

        String dateFormat = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println("\n 날짜 : " + dateFormat);

        String opt1 = "?areaCode=";
        String opt2 = "&serviceKey=";
        String opt3 = "&numOfRows=200&pageNo=1&MobileOS=ETC&MobileApp=AppTest&listYN=Y&arrange=R&eventStartDate=" + dateFormat;

        List<FullEventDataItemDTO> itemList = tourService.getEventItemListUrl(eventApiurl + opt1 + areaCode + opt2 + APIkey + opt3);

        return itemList;
    }

    // 지역 축제
    @RequestMapping("/SearchFestival")
    public String SearchFestival(@RequestParam("areaCode") String areaCode, HttpSession session) throws Exception {
        System.out.println("searchFestival : " + areaCode);
        String areaName = tourService.getAreaName(areaCode);
        session.setAttribute("areaCode", areaCode);
        session.setAttribute("areaName", areaName);

        return "redirect:/SleepOn/Festival";
    }

    // 지역 축제 View 페이지
    @RequestMapping("/Festival")
    public ModelAndView AreaFestival(HttpSession session, HttpServletRequest request, Model model) throws Exception {
        addSessionAttributesToModel(request, model);
        ModelAndView mv = new ModelAndView("page/SleepOnFestival");

        String areaCode = (String) session.getAttribute("areaCode");
        mv.addObject("areaCode", areaCode);

        String areaName = (String) session.getAttribute("areaName");
        mv.addObject("areaName", areaName);

        return mv;
    }

    // 지역 선택시 시군구
    @ResponseBody
    @RequestMapping("/SigunguSelect")
    public Map<String, String> selectSigungu(@RequestParam("areaCode") String areaCode) throws Exception {
        System.out.println("\nsearch 창에 지역 선택 : " + areaCode + "\n");

        Map<String, String> sigunguMap = tourService.getSigunguMap(areaCode);

        return sigunguMap;
    }

    // 검색 창에 지역, 시군구, 날짜, 인원 선택하면 세션 저장하여 리다이렉트
    @RequestMapping("/Search")
    public String SleepOnSearch(@RequestParam("areaCode") String areaCode, @RequestParam("sigunguCode") String sigunguCode, @RequestParam("checkIn") String checkIn, @RequestParam("checkOut") String checkOut, @RequestParam("userCnt") String userCnt, HttpSession session) throws Exception {

        // 값 저장
        session.setAttribute("areaCode", areaCode);
        session.setAttribute("sigunguCode", sigunguCode);
        session.setAttribute("checkIn", checkIn);
        session.setAttribute("checkOut", checkOut);
        session.setAttribute("userCnt", userCnt);

        String areaName = tourService.getAreaName(areaCode);
        String sigunguName = tourService.getSigunguName(areaCode, sigunguCode);

        session.setAttribute("areaName", areaName);
        session.setAttribute("sigunguName", sigunguName);

        return "redirect:/SleepOn/SleepOnList";
    }

    @ResponseBody
    @RequestMapping("/SleepOnList")
    public ModelAndView SleepOnList(HttpSession session, HttpServletRequest request, Model model) throws Exception {
        addSessionAttributesToModel(request, model);
        // 세션에서 값 가져오기
        String areaCode = (String) session.getAttribute("areaCode");
        String sigunguCode = (String) session.getAttribute("sigunguCode");
        String checkIn = (String) session.getAttribute("checkIn");
        String checkOut = (String) session.getAttribute("checkOut");
        String userCnt = (String) session.getAttribute("userCnt");
        String areaName = (String) session.getAttribute("areaName");
        String sigunguName = (String) session.getAttribute("sigunguName");

        ModelAndView mv = new ModelAndView("page/SleepOnList");
        mv.addObject("areaCode", areaCode);
        mv.addObject("sigunguCode", sigunguCode);
        mv.addObject("checkIn", checkIn);
        mv.addObject("checkOut", checkOut);
        mv.addObject("userCnt", userCnt);
        mv.addObject("areaName", areaName);
        mv.addObject("sigunguName", sigunguName);

        return mv;
    }

    // 숙소 상세정보, contentId, sigunguCode 값 받아오기
    @RequestMapping("/Detail")
    public String SleepOnDetail(@RequestParam("contentId") String contentId, @RequestParam("userCnt") String userCnt, @RequestParam("checkIn") String checkIn, @RequestParam("checkOut") String checkOut, HttpSession session) throws Exception {
        session.setAttribute("contentId", contentId);
        session.setAttribute("userCnt", userCnt);
        session.setAttribute("checkIn", checkIn);
        session.setAttribute("checkOut", checkOut);

        return "redirect:/SleepOn/HotelDetail";
    }

    @RequestMapping("/HotelDetail")
    public ModelAndView SleepOnDetail(HttpSession session, HttpServletRequest request, Model model) throws Exception {
        addSessionAttributesToModel(request, model);
        ModelAndView mv = new ModelAndView("page/SleepOnHotelDetail");

        String contentId = (String) session.getAttribute("contentId");
        String userCnt = (String) session.getAttribute("userCnt");
        String checkIn = (String) session.getAttribute("checkIn");
        String checkOut = (String) session.getAttribute("checkOut");

        mv.addObject("contentId", contentId);
        mv.addObject("userCnt", userCnt);
        mv.addObject("checkIn", checkIn);
        mv.addObject("checkOut", checkOut);

        return mv;
    }

    @ResponseBody
    @RequestMapping("/HotelDetailInfo")
    public Object SleepOnDetail(@RequestParam("contentId") String contentId) throws Exception {
        System.out.println("\n객실 공통 정보\n");
        // 공통 정보
        //http://apis.data.go.kr/B551011/KorService1/detailCommon1?ServiceKey=인증키&contentTypeId=32&contentId=142785&MobileOS=ETC&MobileApp=AppTest&defaultYN=Y&firstImageYN=Y&areacodeYN=Y&catcodeYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y

        String opt1 = "?ServiceKey=";
        String opt2 = "&contentTypeId=32";
        String opt3 = "&contentId=";
        String opt4 = "&MobileOS=ETC&MobileApp=AppTest&defaultYN=Y&firstImageYN=Y&areacodeYN=Y&catcodeYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y";

        List<DataComItemDTO> itemList = tourService.getInforItemList(APIInforUrl + opt1 + APIkey + opt2 + opt3 + contentId + opt4);

        System.out.println(APIInforUrl + opt1 + APIkey + opt2 + opt3 + contentId + opt4);

        return itemList;
    }

    @ResponseBody
    @RequestMapping("/HotelDetailRoom")
    public Object SleepOnDetailRoom(@RequestParam("contentId") String contentId) throws Exception{
        System.out.println("\n객실 상세 정보\n");
        // 객실 요금
        //https://apis.data.go.kr/B551011/KorService1/detailInfo1?serviceKey=&MobileOS=ETC&MobileApp=AppTest&contentId=2465071&contentTypeId=32&numOfRows=3&pageNo=1

        String opt1 = "?serviceKey=";
        String opt2 = "&MobileOS=ETC&MobileApp=AppTest";
        String opt3 = "&contentId=";
        String opt4 = "&contentTypeId=32&numOfRows=10&pageNo=1";

        List<DataItemDTO> RoomList = tourService.getDetailItemList(APIDetailUrl + opt1 + APIkey + opt2 + opt3 + contentId + opt4);

        System.out.println(APIDetailUrl + opt1 + APIkey + opt2 + opt3 + contentId + opt4);
        
        return RoomList;
    }

    @GetMapping("/myPage")
    public String myPage(HttpServletRequest request, Model model) throws Exception {
        addSessionAttributesToModel(request, model);

        HttpSession session = request.getSession(false);
        if (session != null) {
            SleepOnUser user = (SleepOnUser) session.getAttribute("user");
            if (user != null) {
                // 상담문의 수를 가져와서 모델에 추가
                String userId = user.getId();
                int cancelCount = tourService.getCountCancelUser(userId);
                model.addAttribute("cancelCount", cancelCount);

                // 예약 내역 리스트
                List<UserReservation> reservations = tourService.getUserReservationDesc(userId);
                model.addAttribute("reservations", reservations);

                // 지난 예약 - 취소 안한 것만
                List<UserReservation> LastReserv = tourService.getUserLastReserv(userId);
                model.addAttribute("lastReserv", LastReserv);

                // 리뷰 수 가져와 모델에 추가
                int reviewCount = tourService.getCountReviewUser(userId);
                model.addAttribute("reviewCount", reviewCount);
            } else {
                return "redirect:/SleepOn/login";
            }
        } else {
            return "redirect:/SleepOn/login";
        }

        return "member/myPage";
    }

    private void addSessionAttributesToModel(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            model.addAttribute("user", session.getAttribute("user"));
        }
    }

    // 결제창 view
    @RequestMapping("/Credit")
    public String SleepOnCredit(@RequestParam("contentId") String contentId, @RequestParam("checkIn") String checkIn, @RequestParam("checkOut") String checkOut, @RequestParam("userCnt") String userCnt, @RequestParam("roomtitle") String roomtitle, HttpSession session) throws Exception{
        session.setAttribute("contentId", contentId);
        session.setAttribute("checkIn", checkIn);
        session.setAttribute("checkOut", checkOut);
        session.setAttribute("userCnt", userCnt);
        session.setAttribute("roomtitle", roomtitle);

        return "redirect:/SleepOn/Payment";
    }

    // 결제 후 DB 저장
    @RequestMapping("/Payment")
    public ModelAndView SleepOnCredit(HttpSession session, HttpServletRequest request, Model model) {
        addSessionAttributesToModel(request, model);

        ModelAndView mv = new ModelAndView("page/SleepOnPayment");

        String contentId = (String) session.getAttribute("contentId");
        String userCnt = (String) session.getAttribute("userCnt");
        String checkIn = (String) session.getAttribute("checkIn");
        String checkOut = (String) session.getAttribute("checkOut");
        String roomtitle = (String) session.getAttribute("roomtitle");

        System.out.println(contentId);
        System.out.println(userCnt);

        mv.addObject("contentId", contentId);
        mv.addObject("userCnt", userCnt);
        mv.addObject("checkIn", checkIn);
        mv.addObject("checkOut", checkOut);
        mv.addObject("roomtitle", roomtitle);

        return mv;
    }

    // my page 예약 취소
    @PostMapping("/cancelReservation/{reservationId}")
    public ResponseEntity<String> cancelReservation(@PathVariable Long reservationId) {
        UserReservation reservation = userReservationRepository.findById(reservationId).orElse(null);

        if (reservation != null) {
            LocalDate checkinDate = LocalDate.parse(reservation.getCheckinTime());
            LocalDate currentDate = LocalDate.now();

            if (ChronoUnit.DAYS.between(currentDate, checkinDate) < 6) {
                return ResponseEntity.badRequest().body("체크인 날짜가 6일 이내여서 취소할 수 없습니다. 고객센터에 문의해주세요.");
            }

            reservation.setReservCancel('Y');
            userReservationRepository.save(reservation);
            return ResponseEntity.ok("예약이 취소되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("예약을 찾을 수 없습니다.");
        }
    }
    // 예약 불러오기
    @GetMapping("/reservations")
    public ResponseEntity<List<UserReservation>> getReservations(HttpSession session) throws Exception {
        SleepOnUser user = (SleepOnUser) session.getAttribute("user");
        if (user != null) {
            List<UserReservation> reservations = tourService.getUserReservationDesc(user.getId());
            return ResponseEntity.ok(reservations);
        }
        return ResponseEntity.ok(List.of());
    }

    // 예약
    @RequestMapping(value = "/reserve")
    public String reserve(@RequestParam("contentId") String contentId,
                          @RequestParam("checkIn") String checkIn,
                          @RequestParam("checkOut") String checkOut,
                          @RequestParam("roomtitle") String roomtitle,
                          @RequestParam("userCnt") String userCnt,
                          HttpSession session){
        SleepOnUser user = (SleepOnUser) session.getAttribute("user");

        System.out.println("\n예약시작\n");
        if (user == null) {
            return "redirect:/SleepOn/login";
        }
        UserReservation reservation = new UserReservation();
        reservation.setUser(user);
        reservation.setReservData(LocalDateTime.now());
        reservation.setCheckinTime(checkIn);
        reservation.setCheckoutTime(checkOut);
        reservation.setContentId(contentId);
        reservation.setReservCancel('N');
        reservation.setRoomTitle(roomtitle);
        reservation.setUserCnt(Integer.parseInt(userCnt));

        tourService.saveReservation(reservation);

        return "redirect:/SleepOn/reservationSuccess";
    }

    @RequestMapping("/reservationSuccess")
    public String reservationSuccess(HttpServletRequest request, Model model) {
        addSessionAttributesToModel(request, model);
        return "member/reservationSuccess";
    }

    // 관리자 전용 페이지
    @RequestMapping("/admin")
    public ModelAndView admin(HttpServletRequest request, Model model) throws Exception {
        addSessionAttributesToModel(request, model);

        ModelAndView mv = new ModelAndView("inquiry/adminPage");

        List<UserCancel> itemList = tourService.getAdminCancelList();
        mv.addObject("itemList", itemList);

        return mv;
    }
    @RequestMapping("/saveReply")
    public String saveReply(@RequestParam("id") int id, @RequestParam("reply") String reply, HttpServletRequest request, Model model) throws Exception {
        addSessionAttributesToModel(request, model);

        tourService.saveReply(id, reply);
        return "redirect:/SleepOn/admin";
    }

    // 고객 상담문의 페이지
    @RequestMapping("/inquiry")
    public String userInquiry (HttpServletRequest request, Model model) throws Exception {
        addSessionAttributesToModel(request, model);

        HttpSession session = request.getSession(false);
        if (session != null) {
            SleepOnUser user = (SleepOnUser) session.getAttribute("user");
            if (user != null) {
                String userId = user.getId();

                List<UserCancel> userCancelList = tourService.getUserCancelList(userId);
                model.addAttribute("userCancelList", userCancelList);

                return "inquiry/UserInquiryList";
            } else {
                return "redirect:/SleepOn/login";
            }
        } else {
            return "redirect:/SleepOn/login";
        }
    }

    // 고객 문의글 작성 페이지
    @RequestMapping("/inquiryWrite")
    public String userInquiryWrite (HttpServletRequest request, Model model) throws Exception {
        addSessionAttributesToModel(request, model);

        HttpSession session = request.getSession(false);
        if (session != null) {
            SleepOnUser user = (SleepOnUser) session.getAttribute("user");
            if (user != null) {
                List<UserReservation> reservations = tourService.getUserReservation(user.getId());
                model.addAttribute("reservations", reservations);
                model.addAttribute("user", user);
                return "inquiry/inquiryWrite";
            }
        }
        return "redirect:/SleepOn/login";
    }

    // 고객 문의 접수
    @RequestMapping("/SubmitInquiry")
    public String submitInquiry (@RequestParam("title") String title, @RequestParam("inquiry") String inquiry, @RequestParam(name="reservId", required = false) String reservId,
            HttpSession session, HttpServletRequest request, Model model) throws Exception {
        addSessionAttributesToModel(request, model);

        SleepOnUser user = (SleepOnUser) session.getAttribute("user");

        System.out.println("\n문의 등록\n");
        if (user == null) {
            return "redirect:/SleepOn/login";
        }
        UserCancel userCancel = new UserCancel();
        userCancel.setUser(user);
        userCancel.setTitle(title);
        userCancel.setInquiry(inquiry);
        if (reservId != null && !reservId.isEmpty()) {
            try {
                Long reservationId = Long.parseLong(reservId);
                UserReservation reservation = userReservationRepository.findById(reservationId).orElse(null);
                userCancel.setReservation(reservation);
            }
            catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        userCancel.setCreateDate(LocalDateTime.now());


        tourService.saveUserCancel(userCancel);

        return "redirect:/SleepOn/inquiryDetail?id=" + userCancel.getIdx();
    }

    // 문의 내용 보기
    @RequestMapping("/inquiryDetail")
    public String inquiryDetail (@RequestParam("id") int id, Model model, HttpServletRequest request) {
        addSessionAttributesToModel(request, model);
        HttpSession session = request.getSession(false);
        if (session != null) {
            SleepOnUser user = (SleepOnUser) session.getAttribute("user");
            if (user != null) {
                UserCancel inquiry = userCancleRepository.findById(id).orElse(null);
                if (inquiry != null) {
                    model.addAttribute("inquiry", inquiry);
                    model.addAttribute("user", user);
                    model.addAttribute("isManager", user.isManager());

                    if (inquiry.getReservation() != null) {
                        UserReservation reservation = inquiry.getReservation();
                        model.addAttribute("reservation", reservation);
                    }
                    return "inquiry/inquiryDetail";
                }
                else {
                    System.out.println("Inquiry is null");
                }
            } else {
                System.out.println("User is null in session.");
            }
        } else {
            System.out.println("Session is null.");
        }
        return "redirect:/SleepOn/login";
    }

    // 문의 삭제 (고객만)
    @RequestMapping("/deleteInquiry")
    public String deleteInquiry(@RequestParam("id") int id) throws Exception {
        tourService.deleteUserCancel(id);
        return "redirect:/SleepOn/inquiry";
    }

    // 고객 리뷰목록 페이지 - 작성한 댓글
    @GetMapping("/review")
    public String userReview (HttpServletRequest request, Model model) throws Exception {
        addSessionAttributesToModel(request, model);

        HttpSession session = request.getSession(false);
        if (session != null) {
            SleepOnUser user = (SleepOnUser) session.getAttribute("user");
            if (user != null) {
                String userId = user.getId();

                List<UserReview> myReviewList = tourService.getUserReviewList(userId);
                model.addAttribute("myReviewList", myReviewList);

                return "review/UserReviewList";
            } else {
                return "redirect:/SleepOn/login";
            }
        } else {
            return "redirect:/SleepOn/login";
        }
    }

    // 리뷰 내역 상세보기 (일단 내가 쓴 것만)
    @GetMapping("/reviewDetail")
    public String reviewDetail(@RequestParam("id") int id, Model model) throws Exception {
        UserReview review = tourService.getReviewById(id);
        model.addAttribute("review", review);
        return "review/UserReviewDetail";
    }


    // 리뷰 작성 페이지
    @GetMapping("/reviewWrite")
    public String userReviewWrite (@RequestParam("idx") int idx, HttpServletRequest request, Model model) throws Exception {
        addSessionAttributesToModel(request, model);

        HttpSession session = request.getSession(false);
        if (session != null) {
            SleepOnUser user = (SleepOnUser) session.getAttribute("user");
            if (user != null) {
                UserReservation reservation = tourService.getUserReservationIdx(idx);
                model.addAttribute("reservation", reservation);
                model.addAttribute("user", user);
                return "review/UserReviewWrite";
            }
        }
        return "redirect:/SleepOn/login";
    }

    // 리뷰 접수
    @RequestMapping("/SubmitReview")
    public String submitReview (@RequestParam(value = "reviewLocationNum") int reviewLocationNum,
                                 @RequestParam(value = "reviewCheckinNum") int reviewCheckinNum,
                                 @RequestParam(value = "reviewCommunicationNum") int reviewCommunicationNum,
                                 @RequestParam(value = "reviewCleanlinessNum") int reviewCleanlinessNum,
                                 @RequestParam(value = "reviewSatisfactionNum") int reviewSatisfactionNum,
                                 @RequestParam("reviewText") String reviewText,
                                 @RequestParam("contentId") String contentId,
                                 @RequestParam("reservId") String reservId,
                                 HttpSession session, HttpServletRequest request, Model model) throws Exception {
        addSessionAttributesToModel(request, model);

        SleepOnUser user = (SleepOnUser) session.getAttribute("user");

        System.out.println("\n리뷰 등록\n");
        if (user == null) {
            return "redirect:/SleepOn/login";
        }
        UserReview userReview = new UserReview();
        userReview.setUser(user);
        userReview.setReviewLocationNum(reviewLocationNum);
        userReview.setReviewCheckinNum(reviewCheckinNum);
        userReview.setReviewCommunicationNum(reviewCommunicationNum);
        userReview.setReviewCleanlinessNum(reviewCleanlinessNum);
        userReview.setReviewSatisfactionNum(reviewSatisfactionNum);
        userReview.setReviewText(reviewText);
        userReview.setContentId(contentId);
        userReview.setReviewSubmitted("Y");
        userReview.setCreatedAt(LocalDateTime.now());
        userReview.avg_reviewnum();
        if (reservId != null && !reservId.isEmpty()) {
            try {
                Long reservationId = Long.parseLong(reservId);
                UserReservation reservation = userReservationRepository.findById(reservationId).orElse(null);
                userReview.setReservation(reservation);
            }
            catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        tourService.saveUserReview(userReview);

        return "redirect:/SleepOn/review";
    }


    // 리뷰 상세보기
    @RequestMapping("/reviewDetail")
    public String reviewDetail (@RequestParam("idx") int idx, Model model, HttpServletRequest request) {
        addSessionAttributesToModel(request, model);
        HttpSession session = request.getSession(false);
        if (session != null) {
            SleepOnUser user = (SleepOnUser) session.getAttribute("user");
            if (user != null) {
                UserReview review = userReviewRepository.findById(idx).orElse(null);
                if (review != null) {
                    model.addAttribute("review", review);
                    model.addAttribute("user", user);

                    if (review.getReservation() != null) {
                        UserReservation reservation = review.getReservation();
                        model.addAttribute("reservation", reservation);
                    }
                    return "review/UserReviewDetail";
                }
                else {
                    System.out.println("Review is null");
                }
            } else {
                System.out.println("User is null in session.");
            }
        } else {
            System.out.println("Session is null.");
        }
        return "redirect:/SleepOn/login";
    }

    // 리뷰 수정
    @RequestMapping("/updateReview")
    public String updateReview(@RequestParam("id") int id,
                               @RequestParam("reviewLocationNum") int reviewLocationNum,
                               @RequestParam("reviewCheckinNum") int reviewCheckinNum,
                               @RequestParam("reviewCommunicationNum") int reviewCommunicationNum,
                               @RequestParam("reviewCleanlinessNum") int reviewCleanlinessNum,
                               @RequestParam("reviewSatisfactionNum") int reviewSatisfactionNum,
                               @RequestParam("reviewText") String reviewText,
                               HttpServletRequest request, Model model) throws Exception {
        addSessionAttributesToModel(request, model);

        tourService.updateUserReview(id, reviewLocationNum, reviewCheckinNum, reviewCommunicationNum, reviewCleanlinessNum, reviewSatisfactionNum, reviewText);

        return "redirect:/SleepOn/review";
    }

    // 리뷰 삭제
    @RequestMapping("/deleteReview")
    public String deleteReview(@RequestParam("id") int id) throws Exception {
        tourService.deleteUserReview(id);
        return "redirect:/SleepOn/review";
    }

    // 호텔별 리뷰목록 페이지 - 작성한 댓글
    @RequestMapping("/hotelReviewList")
    public ModelAndView hotelReviewList(@RequestParam("contentId") String contentId, HttpServletRequest request, Model model) throws Exception {
        addSessionAttributesToModel(request, model);

        ModelAndView mv = new ModelAndView("review/HotelReviewList");

        List<UserReview> itemList = tourService.getHotelReviewList();
        mv.addObject("itemList", itemList);

        return mv;
    }
}

