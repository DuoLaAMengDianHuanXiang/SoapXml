package com.didadiandi.soapXml.domain;

import com.didadiandi.soapXml.domain.enums.SexEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlType(propOrder = {"userName", "age", "sex", "phone"})
public class Record {

    @XmlAttribute(name = "num")
    private String num;

    private String userName;

    private Integer age;

    private SexEnums sex;

    private String phone;


    @XmlElement(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    @XmlElement(name = "USER_AGE")
    public Integer getAge() {
        return age;
    }

    @XmlElement(name = "USER_SEX")
    public SexEnums getSex() {
        return sex;
    }

    @XmlElement(name = "PHONE_NUMBER")
    public String getPhone() {
        return phone;
    }
}
