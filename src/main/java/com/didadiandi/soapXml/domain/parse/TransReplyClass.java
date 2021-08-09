package com.didadiandi.soapXml.domain.parse;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Data
@XmlAccessorType(value = XmlAccessType.FIELD)
public class TransReplyClass {

    private Boolean transactionCompleted;

    private String retData;
}
