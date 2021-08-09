package com.didadiandi.soapXml.domain.parse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * TODO
 *
 * @author wj
 * @date 2021/8/9 12:19
 */
@Getter
@XmlRootElement(name = "SubmitContentResponse", namespace = "http://www.w3.org/")
public class SubmitContentResponse {

    private TransReplyClass transReplyClass;


    @XmlElement(name = "TransReplyClass")
    public void setTransReplyClass(TransReplyClass transReplyClass) {
        this.transReplyClass = transReplyClass;
    }
}
