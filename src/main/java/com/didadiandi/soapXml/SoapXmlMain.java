package com.didadiandi.soapXml;

import com.didadiandi.soapXml.domain.Record;
import com.didadiandi.soapXml.domain.Request;
import com.didadiandi.soapXml.domain.Transaction;
import com.didadiandi.soapXml.domain.enums.SexEnums;
import com.didadiandi.soapXml.domain.parse.SubmitContentResponse;
import com.didadiandi.soapXml.utils.SoapUtils;
import com.didadiandi.soapXml.utils.XmlUtils;
import org.dom4j.DocumentException;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author wj
 * @date 2021/8/9 15:29
 */
public class SoapXmlMain {
    static String prefix = "soapenv";
    static String myNamespace = "web";

    public static void main(String[] args) throws JAXBException, DocumentException, SOAPException, IOException, ParserConfigurationException {
        parse();



        String resultResponse = "<?xml version='1.0' encoding='UTF-8'?><S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\"><SOAP-ENV:Header/><S:Body xmlns:ns2=\"http://www.w3.org/\"><ns2:SubmitContentResponse xmlns:ns2=\"http://www.w3.org/\"><TransReplyClass><transactionCompleted>true</transactionCompleted><retData>1436248</retData></TransReplyClass></ns2:SubmitContentResponse></S:Body></S:Envelope>";
        SubmitContentResponse contentResponse = XmlUtils.xmlToObj(resultResponse, "SubmitContentResponse", SubmitContentResponse.class);
        System.out.println(contentResponse);

    }

    public static void parse() throws SOAPException, JAXBException, IOException, ParserConfigurationException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        // SOAP Header
        SOAPHeader header = soapMessage.getSOAPHeader();
        // SOAP Body
        SOAPBody body = soapMessage.getSOAPBody();
        // 移除xmlns:SOAP-ENV
        envelope.removeNamespaceDeclaration(envelope.getPrefix());
        // 设置前缀，默认为SOAP-ENV
        envelope.setPrefix(prefix);
        header.setPrefix(prefix);
        body.setPrefix(prefix);

        envelope.addNamespaceDeclaration(prefix, "http://www.w3.org/2001/12/soap-envelope");
        envelope.addNamespaceDeclaration(myNamespace, "http://www.w3.org/");
        SOAPBody soapBody = envelope.getBody();

        // 给soap添加内容
        {
            body2(soapBody);
        }

        soapMessage.saveChanges();

        soapMessage.writeTo(System.out);
    }

    /**
     * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://www.w3.org/">
     * <soapenv:Header/>
     * <soapenv:Body>
     * <web:SubmitContent>
     * <pUsername>pUsername</pUsername>
     * <pPassword>pPassword</pPassword>
     * <pMyOrigin>pMyOrigin</pMyOrigin>
     * <pVersion>1.0</pVersion>
     * <pContent>
     * <![CDATA[<AVS_TRANSACTIONS><VERSION>1.0</VERSION><DATE_CREATED>20120806</DATE_CREATED><RECORDS><RECORD num="1"><USER_NAME>哆啦A梦丶幻想</USER_NAME><USER_AGE>18</USER_AGE><USER_SEX>MAN</USER_SEX><PHONE_NUMBER>1111111111111</PHONE_NUMBER></RECORD>
     * </RECORDS>
     * </AVS_TRANSACTIONS>]]>
     * </pContent>
     * </web:SubmitContent>
     * </soapenv:Body>
     * </soapenv:Envelope>
     */
    public static void body1(SOAPBody soapBody) throws SOAPException, JAXBException {
        // SOAP Body
        SOAPElement soapBodyElem = soapBody.addChildElement("SubmitContent", myNamespace);

        SOAPFactory soapFactory = SOAPFactory.newInstance();

        List<SOAPElement> baseSoapElementList = SoapUtils.baseSoapElement(soapFactory);
        for (SOAPElement soapElement : baseSoapElementList) {
            soapBodyElem.addChildElement(soapElement);
        }

        List<Record> recordList = new ArrayList<>();
        Record record = Record.builder()
                .num("1")
                .userName("哆啦A梦丶幻想")
                .age(18)
                .sex(SexEnums.MAN)
                .phone("1111111111111")
                .build();
        recordList.add(record);
        Transaction transaction = Transaction.of("1.0", "20120806", recordList);
        String test = XmlUtils.objToXml(transaction);


        SOAPElement names = soapFactory.createElement("pContent");
        Document soapBodyDoc = names.getOwnerDocument();
        CDATASection cdata = soapBodyDoc.createCDATASection(test);
        names.appendChild(cdata);

        soapBodyElem.addChildElement(names);
    }


    /**
     * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://www.w3.org/">
     * <soapenv:Header/>
     * <soapenv:Body>
     * <web:SubmitContent>
     * <request>
     * <pMyOrigin>myOrigin</pMyOrigin>
     * <pPassword>password</pPassword>
     * <pUsername>username</pUsername>
     * <pVersion>version</pVersion>
     * <pContent xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:type="xs:string">
     * <![CDATA[<AVS_TRANSACTIONS><VERSION>1.0</VERSION><DATE_CREATED>20120806</DATE_CREATED><RECORDS><RECORD num="1"><USER_NAME>哆啦A梦丶幻想</USER_NAME><USER_AGE>18</USER_AGE><USER_SEX>MAN</USER_SEX><PHONE_NUMBER>1111111111111</PHONE_NUMBER></RECORD>
     * </RECORDS>
     * </AVS_TRANSACTIONS>]]>
     * </pContent>
     * </request>
     * </web:SubmitContent>
     * </soapenv:Body>
     * </soapenv:Envelope>
     */
    public static void body2(SOAPBody soapBody) throws SOAPException, JAXBException, ParserConfigurationException {
        Request request = Request.of("username", "password");
        JAXBContext jc = JAXBContext.newInstance(request.getClass());
        Marshaller marshaller = jc.createMarshaller();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document requestDoc = db.newDocument();
        marshaller.marshal(request, requestDoc);
        Node pContent = requestDoc.getFirstChild().getLastChild();
        List<Record> recordList = new ArrayList<>();
        Record record = Record.builder()
                .num("1")
                .userName("哆啦A梦丶幻想")
                .age(18)
                .sex(SexEnums.MAN)
                .phone("1111111111111")
                .build();
        recordList.add(record);
        Transaction transaction = Transaction.of("1.0", "20120806", recordList);
        String test = XmlUtils.objToXml(transaction);
        CDATASection cdataSection = pContent.getOwnerDocument().createCDATASection(test);
        pContent.appendChild(cdataSection);


        SOAPElement soapBodyElement = soapBody.addChildElement("SubmitContent", myNamespace);
        Document soapBodyDoc = soapBodyElement.getOwnerDocument();
        Node child = soapBodyDoc.importNode(requestDoc.getFirstChild(), true);
        soapBodyElement.appendChild(child);
    }


}
