package com.didadiandi.soapXml.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@XmlRootElement(name = "request")
@NoArgsConstructor
public class Request extends BaseRequest{

    private Object content = "";

    @XmlElement(name = "pContent")
    public Object getContent() {
        return content;
    }

    public static Request of(String username, String password) {
        return Request.builder()
                .username(username)
                .password(password)
                .build();
    }

    @Builder
    public Request(String username, String password) {
        super(username, password);
    }
}
