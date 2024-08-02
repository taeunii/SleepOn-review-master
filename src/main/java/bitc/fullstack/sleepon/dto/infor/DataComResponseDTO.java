package bitc.fullstack.sleepon.dto.infor;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class DataComResponseDTO {
    private DataComHeaderDTO header;
    private DataComBodyDTO body;

    @XmlElement(name = "header")
    public DataComHeaderDTO getHeader() {
        return header;
    }

    public void setHeader(DataComHeaderDTO header) {
        this.header = header;
    }

    @XmlElement(name = "body")
    public DataComBodyDTO getBody() {
        return body;
    }

    public void setBody(DataComBodyDTO body) {
        this.body = body;
    }
}
