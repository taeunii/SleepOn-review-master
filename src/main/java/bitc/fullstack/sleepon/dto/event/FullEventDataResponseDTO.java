package bitc.fullstack.sleepon.dto.event;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class FullEventDataResponseDTO {
    private FullEventDataHeaderDTO header;
    private FullEventDataBodyDTO body;

    @XmlElement(name="header")
    public FullEventDataHeaderDTO getHeader() {
        return header;
    }

    public void setHeader(FullEventDataHeaderDTO header) {
        this.header = header;
    }

    @XmlElement(name="body")
    public FullEventDataBodyDTO getBody() {
        return body;
    }

    public void setBody(FullEventDataBodyDTO body) {
        this.body = body;
    }
}