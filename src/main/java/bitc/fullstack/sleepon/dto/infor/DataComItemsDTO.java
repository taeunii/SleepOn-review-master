package bitc.fullstack.sleepon.dto.infor;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "items")
public class DataComItemsDTO {
    private List<DataComItemDTO> itemList;

    @XmlElement(name = "item")
    public List<DataComItemDTO> getItemList() {
        return itemList;
    }

    public void setItemList(List<DataComItemDTO> itemList) {
        this.itemList = itemList;
    }
}
