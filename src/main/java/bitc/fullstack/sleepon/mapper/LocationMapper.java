package bitc.fullstack.sleepon.mapper;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LocationMapper {
    public String getAreaMap(String areaCode){
        String areaName = "";
        switch (areaCode) {
            case "1":
                areaName = "서울";
                break;
            case "6":
                areaName = "부산";
                break;
            case "39":
                areaName = "제주";
                break;
            case "31":
                areaName = "경기";
                break;
            case "2":
                areaName = "인천";
                break;
            case "32":
                areaName = "강원";
                break;
            case "36":
                areaName = "경상남도";
                break;
            case "35":
                areaName = "경상북도";
                break;
            case "38":
                areaName = "전라";
                break;
            case "34":
                areaName = "충청남도";
                break;
            case "33":
                areaName = "충청북도";
                break;
            default:
                break;
        }
        return areaName;
    }
    public Map<String, String> getSigunguMapList(String areaCode) {
        Map<String, String> sigunguMap = new HashMap<>();
        switch (areaCode) {
            case "1":
                sigunguMap.put("1", "강남구");
                sigunguMap.put("2", "강동구");
                sigunguMap.put("3", "강북구");
                sigunguMap.put("4", "강서구");
                sigunguMap.put("5", "관악구");
                sigunguMap.put("6", "광진구");
                sigunguMap.put("7", "구로구");
                sigunguMap.put("8", "금천구");
                sigunguMap.put("9", "노원구");
                sigunguMap.put("10", "도봉구");
                sigunguMap.put("11", "동대문구");
                sigunguMap.put("12", "동작구");
                sigunguMap.put("13", "마포구");
                sigunguMap.put("14", "서대문구");
                sigunguMap.put("15", "서초구");
                sigunguMap.put("16", "성동구");
                sigunguMap.put("17", "성북구");
                sigunguMap.put("18", "송파구");
                sigunguMap.put("19", "양천구");
                sigunguMap.put("20", "영등포구");
                sigunguMap.put("21", "용산구");
                sigunguMap.put("22", "은평구");
                sigunguMap.put("23", "종로구");
                sigunguMap.put("24", "중구");
                sigunguMap.put("25", "중랑구");
                break;
            case "6":
                sigunguMap.put("1", "강서구");
                sigunguMap.put("2", "금정구");
                sigunguMap.put("3", "기장군");
                sigunguMap.put("4", "남구");
                sigunguMap.put("5", "동구");
                sigunguMap.put("6", "동래구");
                sigunguMap.put("7", "부산진구");
                sigunguMap.put("8", "북구");
                sigunguMap.put("9", "사상구");
                sigunguMap.put("10", "사하구");
                sigunguMap.put("11", "서구");
                sigunguMap.put("12", "수영구");
                sigunguMap.put("13", "연제구");
                sigunguMap.put("14", "영도구");
                sigunguMap.put("15", "중구");
                sigunguMap.put("16", "해운대구");
                break;
            case "39":
                sigunguMap.put("1", "서귀포시");
                sigunguMap.put("2", "제주시");
                break;
            case "31":
                sigunguMap.put("1", "가평군");
                sigunguMap.put("2", "고양시");
                sigunguMap.put("3", "과천시");
                sigunguMap.put("4", "광명시");
                sigunguMap.put("5", "광주시");
                sigunguMap.put("6", "구리시");
                sigunguMap.put("7", "군포시");
                sigunguMap.put("8", "김포시");
                sigunguMap.put("9", "남양주시");
                sigunguMap.put("10", "동두천시");
                sigunguMap.put("11", "부천시");
                sigunguMap.put("12", "성남시");
                sigunguMap.put("13", "수원시");
                sigunguMap.put("14", "시흥시");
                sigunguMap.put("15", "안산시");
                sigunguMap.put("16", "안성시");
                sigunguMap.put("17", "안양시");
                sigunguMap.put("18", "양주시");
                sigunguMap.put("19", "양평군");
                sigunguMap.put("20", "여주시");
                sigunguMap.put("21", "연천군");
                sigunguMap.put("22", "오산시");
                sigunguMap.put("23", "용인시");
                sigunguMap.put("24", "의왕시");
                sigunguMap.put("25", "의정부시");
                sigunguMap.put("26", "이천시");
                sigunguMap.put("27", "파주시");
                sigunguMap.put("28", "평택시");
                sigunguMap.put("29", "포천시");
                sigunguMap.put("30", "하남시");
                sigunguMap.put("31", "화성시");
                break;
            case "2":
                sigunguMap.put("1", "강화군");
                sigunguMap.put("2", "계양구");
                sigunguMap.put("3", "남동구");
                sigunguMap.put("4", "동구");
                sigunguMap.put("5", "미추홀구");
                sigunguMap.put("6", "부평구");
                sigunguMap.put("7", "서구");
                sigunguMap.put("8", "연수구");
                sigunguMap.put("9", "옹진군");
                sigunguMap.put("10", "중구");
                break;
            case "32":
                sigunguMap.put("1", "강릉시");
                sigunguMap.put("2", "고성군");
                sigunguMap.put("3", "동해시");
                sigunguMap.put("4", "삼척시");
                sigunguMap.put("5", "속초시");
                sigunguMap.put("6", "양구군");
                sigunguMap.put("7", "양양군");
                sigunguMap.put("8", "영월군");
                sigunguMap.put("9", "원주시");
                sigunguMap.put("10", "인제군");
                sigunguMap.put("11", "정선군");
                sigunguMap.put("12", "철원군");
                sigunguMap.put("13", "춘천시");
                sigunguMap.put("14", "태백시");
                sigunguMap.put("15", "평창군");
                sigunguMap.put("16", "홍천군");
                sigunguMap.put("17", "화천군");
                sigunguMap.put("18", "횡성군");
                break;
            case "36":
                sigunguMap.put("1", "거제시");
                sigunguMap.put("2", "거창군");
                sigunguMap.put("3", "고성군");
                sigunguMap.put("4", "김해시");
                sigunguMap.put("5", "남해군");
                sigunguMap.put("6", "밀양시");
                sigunguMap.put("7", "사천시");
                sigunguMap.put("8", "산청군");
                sigunguMap.put("9", "양산시");
                sigunguMap.put("10", "의령군");
                sigunguMap.put("11", "진주시");
                sigunguMap.put("12", "창녕군");
                sigunguMap.put("13", "창원시");
                sigunguMap.put("14", "통영시");
                sigunguMap.put("15", "하동군");
                sigunguMap.put("16", "함안군");
                sigunguMap.put("17", "함양군");
                sigunguMap.put("18", "합천군");
                break;
            case "35":
                sigunguMap.put("1", "경산시");
                sigunguMap.put("2", "경주시");
                sigunguMap.put("3", "고령군");
                sigunguMap.put("4", "구미시");
                sigunguMap.put("5", "군위군");
                sigunguMap.put("6", "김천시");
                sigunguMap.put("7", "문경시");
                sigunguMap.put("8", "봉화군");
                sigunguMap.put("9", "상주시");
                sigunguMap.put("10", "성주군");
                sigunguMap.put("11", "안동시");
                sigunguMap.put("12", "영덕군");
                sigunguMap.put("13", "영양군");
                sigunguMap.put("14", "영주시");
                sigunguMap.put("15", "영천시");
                sigunguMap.put("16", "예천군");
                sigunguMap.put("17", "울릉군");
                sigunguMap.put("18", "울진군");
                sigunguMap.put("19", "의성군");
                sigunguMap.put("20", "청도군");
                sigunguMap.put("21", "청송군");
                sigunguMap.put("22", "칠곡군");
                sigunguMap.put("23", "포항시");
                break;
            case "38":
                sigunguMap.put("1", "강진군");
                sigunguMap.put("2", "고흥군");
                sigunguMap.put("3", "곡성군");
                sigunguMap.put("4", "광양시");
                sigunguMap.put("5", "구례군");
                sigunguMap.put("6", "나주시");
                sigunguMap.put("7", "담양군");
                sigunguMap.put("8", "목포시");
                sigunguMap.put("9", "무안군");
                sigunguMap.put("10", "보성군");
                sigunguMap.put("11", "순천시");
                sigunguMap.put("12", "신안군");
                sigunguMap.put("13", "여수시");
                sigunguMap.put("14", "영광군");
                sigunguMap.put("15", "영암군");
                sigunguMap.put("16", "완도군");
                sigunguMap.put("17", "장성군");
                sigunguMap.put("18", "장흥군");
                sigunguMap.put("19", "진도군");
                sigunguMap.put("20", "함평군");
                sigunguMap.put("21", "해남군");
                sigunguMap.put("22", "화순군");
                break;
            case "34":
                sigunguMap.put("1", "계룡시");
                sigunguMap.put("2", "공주시");
                sigunguMap.put("3", "금산군");
                sigunguMap.put("4", "논산시");
                sigunguMap.put("5", "당진시");
                sigunguMap.put("6", "보령시");
                sigunguMap.put("7", "부여군");
                sigunguMap.put("8", "서산시");
                sigunguMap.put("9", "서천군");
                sigunguMap.put("10", "아산시");
                sigunguMap.put("11", "연기군");
                sigunguMap.put("12", "예산군");
                sigunguMap.put("13", "천안시");
                sigunguMap.put("14", "청양군");
                sigunguMap.put("15", "태안군");
                sigunguMap.put("16", "홍성군");
                break;
            case "33":
                sigunguMap.put("1", "괴산군");
                sigunguMap.put("2", "단양군");
                sigunguMap.put("3", "보은군");
                sigunguMap.put("4", "영동군");
                sigunguMap.put("5", "옥천군");
                sigunguMap.put("6", "음성군");
                sigunguMap.put("7", "제천시");
                sigunguMap.put("8", "증평군");
                sigunguMap.put("9", "진천군");
                sigunguMap.put("10", "청주시");
                sigunguMap.put("11", "충주시");
                break;
            default:
                break;
        }

        return sigunguMap;
    }

    public String getSmallClassificationName(String code) {
        String name = "";
        switch (code) {
            case "B02010100":
                name = "관광호텔";
                break;
            case "B02010500":
                name = "콘도미니엄";
                break;
            case "B02010600":
                name = "유스호스텔";
                break;
            case "B02010700":
                name = "펜션";
                break;
            case "B02010900":
                name = "모텔";
                break;
            case "B02011000":
                name = "민박";
                break;
            case "B02011100":
                name = "게스트하우스";
                break;
            case "B02011200":
                name = "홈스테이";
                break;
            case "B02011300":
                name = "서비스드레지던스";
                break;
            case "B02011600":
                name = "한옥";
                break;
            default:
                name = "알 수 없음";
                break;
        }
        return name;
    }
}