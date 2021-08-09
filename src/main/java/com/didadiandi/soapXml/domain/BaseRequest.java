package com.didadiandi.soapXml.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseRequest {
    private String username;
    private String password;
    private String myOrigin = "myOrigin";
    private String version = "version";

    @XmlElement(name = "pUsername")
    public String getUsername() {
        return username;
    }

    @XmlElement(name = "pPassword")
    public String getPassword() {
        return password;
    }

    @XmlElement(name = "pMyOrigin")
    public String getMyOrigin() {
        return myOrigin;
    }

    @XmlElement(name = "pVersion")
    public String getVersion() {
        return version;
    }


    public BaseRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
