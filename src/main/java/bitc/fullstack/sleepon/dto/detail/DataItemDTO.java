package bitc.fullstack.sleepon.dto.detail;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
public class DataItemDTO {
    private String contentid;
    private String contenttypeid;
    private String roomcode; // 객실코드
    private String roomtitle; // 객실이름
    private String roomsize1; // 객실크기
    private String roomcount; // 객실수
    private String roombasecount; // 기준인원
    private String roommaxcount; // 최대인원
    private String roomoffseasonminfee1; // 비수기 주중 
    private String roomoffseasonminfee2; // 비수기 주말
    private String roompeakseasonminfee1; // 성수기 주중 
    private String roompeakseasonminfee2; // 성수기 주말
    private String roomintro; // 소개
    private String roombathfacility; // 목욕시설
    private String roombath; // 욕조
    private String roomhometheater; // 홈시어터
    private String roomaircondition; // 에어컨
    private String roomtv; // 티비
    private String roompc; // PC
    private String roomcable; // 케이블 설치
    private String roominternet; //인터넷
    private String roomrefrigerator; // 냉장고
    private String roomtoiletries; // 세면도구
    private String roomsofa; // 소파
    private String roomcook; // 취사여부
    private String roomtable; // 테이블
    private String roomhairdryer; // 드라이기
    private String roomsize2;
    private String roomimg1;
    private String roomimg1alt;
    private String cpyrhtDivCd1;
    private String roomimg2;
    private String roomimg2alt;
    private String cpyrhtDivCd2;
    private String roomimg3;
    private String roomimg3alt;
    private String cpyrhtDivCd3;
    private String roomimg4;
    private String roomimg4alt;
    private String cpyrhtDivCd4;
    private String roomimg5;
    private String roomimg5alt;
    private String cpyrhtDivCd5;

    @XmlElement
    public String getContentid() {
        return contentid;
    }

    public void setContentid(String contentid) {
        this.contentid = contentid;
    }

    @XmlElement
    public String getContenttypeid() {
        return contenttypeid;
    }

    public void setContenttypeid(String contenttypeid) {
        this.contenttypeid = contenttypeid;
    }

    @XmlElement
    public String getRoomcode() {
        return roomcode;
    }

    public void setRoomcode(String roomcode) {
        this.roomcode = roomcode;
    }

    @XmlElement
    public String getRoomtitle() {
        return roomtitle;
    }

    public void setRoomtitle(String roomtitle) {
        this.roomtitle = roomtitle;
    }

    @XmlElement
    public String getRoomsize1() {
        return roomsize1;
    }

    public void setRoomsize1(String roomsize1) {
        this.roomsize1 = roomsize1;
    }

    @XmlElement
    public String getRoomcount() {
        return roomcount;
    }

    public void setRoomcount(String roomcount) {
        this.roomcount = roomcount;
    }

    @XmlElement
    public String getRoombasecount() {
        return roombasecount;
    }

    public void setRoombasecount(String roombasecount) {
        this.roombasecount = roombasecount;
    }

    @XmlElement
    public String getRoommaxcount() {
        return roommaxcount;
    }

    public void setRoommaxcount(String roommaxcount) {
        this.roommaxcount = roommaxcount;
    }

    @XmlElement
    public String getRoomoffseasonminfee1() {
        return roomoffseasonminfee1;
    }

    public void setRoomoffseasonminfee1(String roomoffseasonminfee1) {
        this.roomoffseasonminfee1 = roomoffseasonminfee1;
    }

    @XmlElement
    public String getRoomoffseasonminfee2() {
        return roomoffseasonminfee2;
    }

    public void setRoomoffseasonminfee2(String roomoffseasonminfee2) {
        this.roomoffseasonminfee2 = roomoffseasonminfee2;
    }

    @XmlElement
    public String getRoompeakseasonminfee1() {
        return roompeakseasonminfee1;
    }

    public void setRoompeakseasonminfee1(String roompeakseasonminfee1) {
        this.roompeakseasonminfee1 = roompeakseasonminfee1;
    }

    @XmlElement
    public String getRoompeakseasonminfee2() {
        return roompeakseasonminfee2;
    }

    public void setRoompeakseasonminfee2(String roompeakseasonminfee2) {
        this.roompeakseasonminfee2 = roompeakseasonminfee2;
    }

    @XmlElement
    public String getRoomintro() {
        return roomintro;
    }

    public void setRoomintro(String roomintro) {
        this.roomintro = roomintro;
    }

    @XmlElement
    public String getRoombathfacility() {
        return roombathfacility;
    }

    public void setRoombathfacility(String roombathfacility) {
        this.roombathfacility = roombathfacility;
    }

    @XmlElement
    public String getRoombath() {
        return roombath;
    }

    public void setRoombath(String roombath) {
        this.roombath = roombath;
    }

    @XmlElement
    public String getRoomhometheater() {
        return roomhometheater;
    }

    public void setRoomhometheater(String roomhometheater) {
        this.roomhometheater = roomhometheater;
    }

    @XmlElement
    public String getRoomaircondition() {
        return roomaircondition;
    }

    public void setRoomaircondition(String roomaircondition) {
        this.roomaircondition = roomaircondition;
    }

    @XmlElement
    public String getRoomtv() {
        return roomtv;
    }

    public void setRoomtv(String roomtv) {
        this.roomtv = roomtv;
    }

    @XmlElement
    public String getRoompc() {
        return roompc;
    }

    public void setRoompc(String roompc) {
        this.roompc = roompc;
    }

    @XmlElement
    public String getRoomcable() {
        return roomcable;
    }

    public void setRoomcable(String roomcable) {
        this.roomcable = roomcable;
    }

    @XmlElement
    public String getRoominternet() {
        return roominternet;
    }

    public void setRoominternet(String roominternet) {
        this.roominternet = roominternet;
    }

    @XmlElement
    public String getRoomrefrigerator() {
        return roomrefrigerator;
    }

    public void setRoomrefrigerator(String roomrefrigerator) {
        this.roomrefrigerator = roomrefrigerator;
    }

    @XmlElement
    public String getRoomtoiletries() {
        return roomtoiletries;
    }

    public void setRoomtoiletries(String roomtoiletries) {
        this.roomtoiletries = roomtoiletries;
    }

    @XmlElement
    public String getRoomsofa() {
        return roomsofa;
    }

    public void setRoomsofa(String roomsofa) {
        this.roomsofa = roomsofa;
    }

    @XmlElement
    public String getRoomcook() {
        return roomcook;
    }

    public void setRoomcook(String roomcook) {
        this.roomcook = roomcook;
    }

    @XmlElement
    public String getRoomtable() {
        return roomtable;
    }

    public void setRoomtable(String roomtable) {
        this.roomtable = roomtable;
    }

    @XmlElement
    public String getRoomhairdryer() {
        return roomhairdryer;
    }

    public void setRoomhairdryer(String roomhairdryer) {
        this.roomhairdryer = roomhairdryer;
    }

    @XmlElement
    public String getRoomsize2() {
        return roomsize2;
    }

    public void setRoomsize2(String roomsize2) {
        this.roomsize2 = roomsize2;
    }

    @XmlElement
    public String getRoomimg1() {
        return roomimg1;
    }

    public void setRoomimg1(String roomimg1) {
        this.roomimg1 = roomimg1;
    }

    @XmlElement
    public String getRoomimg1alt() {
        return roomimg1alt;
    }

    public void setRoomimg1alt(String roomimg1alt) {
        this.roomimg1alt = roomimg1alt;
    }

    @XmlElement
    public String getCpyrhtDivCd1() {
        return cpyrhtDivCd1;
    }

    public void setCpyrhtDivCd1(String cpyrhtDivCd1) {
        this.cpyrhtDivCd1 = cpyrhtDivCd1;
    }

    @XmlElement
    public String getRoomimg2() {
        return roomimg2;
    }

    public void setRoomimg2(String roomimg2) {
        this.roomimg2 = roomimg2;
    }

    @XmlElement
    public String getRoomimg2alt() {
        return roomimg2alt;
    }

    public void setRoomimg2alt(String roomimg2alt) {
        this.roomimg2alt = roomimg2alt;
    }

    @XmlElement
    public String getCpyrhtDivCd2() {
        return cpyrhtDivCd2;
    }

    public void setCpyrhtDivCd2(String cpyrhtDivCd2) {
        this.cpyrhtDivCd2 = cpyrhtDivCd2;
    }

    @XmlElement
    public String getRoomimg3() {
        return roomimg3;
    }

    public void setRoomimg3(String roomimg3) {
        this.roomimg3 = roomimg3;
    }

    @XmlElement
    public String getRoomimg3alt() {
        return roomimg3alt;
    }

    public void setRoomimg3alt(String roomimg3alt) {
        this.roomimg3alt = roomimg3alt;
    }

    @XmlElement
    public String getCpyrhtDivCd3() {
        return cpyrhtDivCd3;
    }

    public void setCpyrhtDivCd3(String cpyrhtDivCd3) {
        this.cpyrhtDivCd3 = cpyrhtDivCd3;
    }

    @XmlElement
    public String getRoomimg4() {
        return roomimg4;
    }

    public void setRoomimg4(String roomimg4) {
        this.roomimg4 = roomimg4;
    }

    @XmlElement
    public String getRoomimg4alt() {
        return roomimg4alt;
    }

    public void setRoomimg4alt(String roomimg4alt) {
        this.roomimg4alt = roomimg4alt;
    }

    @XmlElement
    public String getCpyrhtDivCd4() {
        return cpyrhtDivCd4;
    }

    public void setCpyrhtDivCd4(String cpyrhtDivCd4) {
        this.cpyrhtDivCd4 = cpyrhtDivCd4;
    }

    @XmlElement
    public String getRoomimg5() {
        return roomimg5;
    }

    public void setRoomimg5(String roomimg5) {
        this.roomimg5 = roomimg5;
    }

    @XmlElement
    public String getRoomimg5alt() {
        return roomimg5alt;
    }

    public void setRoomimg5alt(String roomimg5alt) {
        this.roomimg5alt = roomimg5alt;
    }

    @XmlElement
    public String getCpyrhtDivCd5() {
        return cpyrhtDivCd5;
    }

    public void setCpyrhtDivCd5(String cpyrhtDivCd5) {
        this.cpyrhtDivCd5 = cpyrhtDivCd5;
    }
}