package ru.sbt;


import java.util.Set;

public class SaveInfoService {
    private SolidXmlReader reader = new SolidXmlReader();
    // связь "название анализируемого элемента - информация о классе"
    // Получить данные из xml
    Set<ClassMetaData> classMetaDataSet = reader.readXmlFile("C:/Users/11007122/Documents/Diplom/Results/MyResult.xml");

    //Записать данные

}
