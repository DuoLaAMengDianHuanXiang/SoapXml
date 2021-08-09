package com.didadiandi.soapXml.domain.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * TODO
 *
 * @author wj
 * @date 2021/8/9 15:42
 */
@XmlEnum(value = String.class)
public enum SexEnums {
    @XmlEnumValue(value = "MAN")
    MAN,
    @XmlEnumValue(value = "WOMAN")
    WOMAN
}
