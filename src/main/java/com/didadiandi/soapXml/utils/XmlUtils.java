package com.didadiandi.soapXml.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class XmlUtils {

    public static <T> String objToXml(T t) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(t.getClass());
        Marshaller ms = jaxbContext.createMarshaller();
        ms.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter stringWriter = new StringWriter();
        ms.marshal(t, stringWriter);
        return stringWriter.toString();
    }

    public static <T> T xmlToObj(String xml, String elementName, Class<T> classes) throws JAXBException, DocumentException {
        Document document = DocumentHelper.parseText(xml);
        //如果不是SOAP返回的报文，是XML字符串则不需要这行代码
        String beanXml = document.getRootElement().element("Body").element(
                elementName).asXML();
        JAXBContext jaxbContext = JAXBContext.newInstance(classes);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (T) unmarshaller.unmarshal(new StringReader(beanXml));
    }
}
