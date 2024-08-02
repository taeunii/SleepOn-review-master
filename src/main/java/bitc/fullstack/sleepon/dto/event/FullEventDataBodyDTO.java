package bitc.fullstack.sleepon.dto.event;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="body")
public class FullEventDataBodyDTO {
    private String numOfRows;
    private String pageNo;
    private String totalCount;
    private FullEventDataItemsDTO items;

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
    public FullEventDataItemsDTO getItems() {
        return items;
    }

    public void setItems(FullEventDataItemsDTO items) {
        this.items = items;
    }
}
