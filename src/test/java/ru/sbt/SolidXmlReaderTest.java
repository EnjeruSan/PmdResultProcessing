package ru.sbt;

import org.junit.Test;

import java.io.IOException;
import java.util.Set;

public class SolidXmlReaderTest {

    @Test
    public void readTest() {
        SolidXmlReadService reader = new SolidXmlReadService();
        Set<ClassMetaData> map = reader.readXmlFile("C:\\Users\\Enjeru\\MIPT\\Diplom\\XmlResults\\CassandraResult2.xml");
        System.out.println(map);

        PmdResultProcessing pmdResultProcessing = new PmdResultProcessing();
        pmdResultProcessing.main(null);

        //ResultWriterService writer = new ResultWriterService();
        //writer.writeResult(map, );
    }
}
