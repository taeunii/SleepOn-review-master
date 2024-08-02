package bitc.fullstack.sleepon.dto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
public class FullDataItemDTO {
    private String addr1; // 주소
    private String addr2; // 상세주소
    private String areacode; // 지역코드
    // 베니키아 여부
    // 한국관광공사가 운영하는 한국형 비즈니스 호텔체인 브랜드
    private String benikia;
    private String cat1; // 대분류
    private String cat2; // 중분류
    private String cat3; // 소분류
    private String contentid; // 콘텐츠 ID
    private String contenttypeid; // 콘텐츠타입 (관광타입)
    private String createdtime; // 등록일
    private String firstimage; // 대표이미지
    private String firstimage2; // 썸네일
    private String cpyrhtDivCd; // 저작권
    private String goodstay; // 굿스테이 여부
    private String hanok; // 한옥 여부
    private String mapx; // GPS X 좌표
    private String mapy; // GPS Y 좌표
    private String mlevel; // map level
    private String modifiedtime; // 수정일
    private String tel; // 전화번호
    private String title; // 제목
    private String booktour; // 교과서 속 여행지 여부
    private String sigungucode; // 시군구 코드

    @XmlElement
    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getBenikia() {
        return benikia;
    }

    public void setBenikia(String benikia) {
        this.benikia = benikia;
    }

    public String getCat1() {
        return cat1;
    }

    public void setCat1(String cat1) {
        this.cat1 = cat1;
    }

    public String getCat2() {
        return cat2;
    }

    public void setCat2(String cat2) {
        this.cat2 = cat2;
    }

    public String getCat3() {
        return cat3;
    }

    public void setCat3(String cat3) {
        this.cat3 = cat3;
    }

    public String getContentid() {
        return contentid;
    }

    public void setContentid(String contentid) {
        this.contentid = contentid;
    }

    public String getContenttypeid() {
        return contenttypeid;
    }

    public void setContenttypeid(String contenttypeid) {
        this.contenttypeid = contenttypeid;
    }

    public String getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(String createdtime) {
        this.createdtime = createdtime;
    }

    public String getFirstimage() {
        return firstimage;
    }

    public void setFirstimage(String firstimage) {
        this.firstimage = firstimage;
    }

    public String getFirstimage2() {
        return firstimage2;
    }

    public void setFirstimage2(String firstimage2) {
        this.firstimage2 = firstimage2;
    }

    public String getCpyrhtDivCd() {
        return cpyrhtDivCd;
    }

    public void setCpyrhtDivCd(String cpyrhtDivCd) {
        this.cpyrhtDivCd = cpyrhtDivCd;
    }

    public String getGoodstay() {
        return goodstay;
    }

    public void setGoodstay(String goodstay) {
        this.goodstay = goodstay;
    }

    public String getHanok() {
        return hanok;
    }

    public void setHanok(String hanok) {
        this.hanok = hanok;
    }

    public String getMapx() {
        return mapx;
    }

    public void setMapx(String mapx) {
        this.mapx = mapx;
    }

    public String getMapy() {
        return mapy;
    }

    public void setMapy(String mapy) {
        this.mapy = mapy;
    }

    public String getMlevel() {
        return mlevel;
    }

    public void setMlevel(String mlevel) {
        this.mlevel = mlevel;
    }

    public String getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(String modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBooktour() {
        return booktour;
    }

    public void setBooktour(String booktour) {
        this.booktour = booktour;
    }

    public String getSigungucode() {
        return sigungucode;
    }

    public void setSigungucode(String sigungucode) {
        this.sigungucode = sigungucode;
    }
}

