package bitc.fullstack.sleepon.dto.event;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "items")
public class FullEventDataItemsDTO {
    private List<FullEventDataItemDTO> itemList;

    @XmlElement(name = "item")
    public List<FullEventDataItemDTO> getItemList() {
        return itemList;
    }

    public void setItemList(List<FullEventDataItemDTO> itemList) {
        this.itemList = itemList;
    }
}
