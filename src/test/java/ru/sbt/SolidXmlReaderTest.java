package ru.sbt;

import org.junit.Test;

import java.util.Set;

public class SolidXmlReaderTest {

    @Test
    public void readTest() {
        SolidXmlReader reader = new SolidXmlReader();
        Set<ClassMetaData> map = reader.readXmlFile("C:\\Users\\Enjeru\\MIPT\\Diplom\\XmlResults\\MicroconfigResult.xml");
        System.out.println(map);

        ResultWriter writer = new ResultWriter();
        writer.writeResult(map, "C:\\Users\\Enjeru\\MIPT\\Diplom\\ExcelResults\\Microconfig.xls");
    }
}
