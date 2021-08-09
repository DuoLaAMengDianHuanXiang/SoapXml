package com.didadiandi.soapXml.domain.parse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * TODO
 *
 * @author wj
 * @date 2021/8/6 16:55
 */
@Data
@XmlAccessorType(value = XmlAccessType.FIELD)
public class TransReplyClass {

    private Boolean transactionCompleted;

    private String retData;
}
