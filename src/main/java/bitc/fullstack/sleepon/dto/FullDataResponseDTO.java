package bitc.fullstack.sleepon.dto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class FullDataResponseDTO {
    private FullDataHeaderDTO header;
    private FullDataBodyDTO body;

    @XmlElement(name = "header")
    public FullDataHeaderDTO getHeader() {
        return header;
    }

    public void setHeader(FullDataHeaderDTO header) {
        this.header = header;
    }

    @XmlElement(name = "body")
    public FullDataBodyDTO getBody() {
        return body;
    }

    public void setBody(FullDataBodyDTO body) {
        this.body = body;
    }
}
