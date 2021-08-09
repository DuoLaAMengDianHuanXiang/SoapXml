package com.didadiandi.soapXml.utils;

import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import java.util.ArrayList;
import java.util.List;

public class SoapUtils {
    static String pUsername = "pUsername";
    static String pPassword = "pPassword";

    public static List<SOAPElement> baseSoapElement(SOAPFactory soapFactory) throws SOAPException {
        List<SOAPElement> soapElementList = new ArrayList<>();

        SOAPElement userName = soapFactory.createElement("pUsername");
        userName.setTextContent(pUsername);
        soapElementList.add(userName);

        SOAPElement password = soapFactory.createElement("pPassword");
        password.setTextContent(pPassword);
        soapElementList.add(password);

        SOAPElement origin = soapFactory.createElement("pMyOrigin");
        origin.setTextContent("pMyOrigin");
        soapElementList.add(origin);

        SOAPElement version = soapFactory.createElement("pVersion");
        version.setTextContent("1.0");
        soapElementList.add(version);
        return soapElementList;
    }
}
