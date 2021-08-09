package com.didadiandi.soapXml.domain.parse;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@XmlRootElement(name = "SubmitContentResponse", namespace = "http://www.w3.org/")
public class SubmitContentResponse {

    private TransReplyClass transReplyClass;


    @XmlElement(name = "TransReplyClass")
    public void setTransReplyClass(TransReplyClass transReplyClass) {
        this.transReplyClass = transReplyClass;
    }
}
