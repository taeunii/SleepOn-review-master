package bitc.fullstack.sleepon.dto.infor;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
public class DataComBodyDTO {
    private String numOfRows;
    private String pageNo;
    private String totalCount;
    private DataComItemsDTO items;

    @XmlElement
    public String getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(String numOfRows) {
        this.numOfRows = numOfRows;
    }

    @XmlElement
    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    @XmlElement
    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    @XmlElement(name = "items")
    public DataComItemsDTO getItems() {
        return items;
    }

    public void setItems(DataComItemsDTO items) {
        this.items = items;
    }
}
