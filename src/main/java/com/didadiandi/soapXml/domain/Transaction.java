package com.didadiandi.soapXml.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * @author vincentchen
 * @date 2020/8/18.
 */
@Setter
@XmlRootElement(name = "AVS_TRANSACTIONS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlType(propOrder = {"version", "dateCreated", "record"})
public class Transaction {

    // VERSION
    private String version;

    // DATE_CREATED
    private String dateCreated;

    // RECORDS > RECORD
    private List<Record> record;

    @XmlElement(name = "VERSION")
    public String getVersion() {
        return version;
    }

    @XmlElement(name = "DATE_CREATED")
    public String getDateCreated() {
        return dateCreated;
    }

    @XmlElementWrapper(name = "RECORDS")
    @XmlElement(name = "RECORD")
    public List<Record> getRecord() {
        return record;
    }

    public static Transaction of(String version, String dateCreated, List<Record> record) {
        return Transaction.builder()
                .version(version)
                .dateCreated(dateCreated)
                .record(record)
                .build();
    }
}
