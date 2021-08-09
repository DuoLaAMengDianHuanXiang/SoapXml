package com.didadiandi.soapXml.domain.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum(value = String.class)
public enum SexEnums {
    @XmlEnumValue(value = "MAN")
    MAN,
    @XmlEnumValue(value = "WOMAN")
    WOMAN
}
