package ru.sbt;


import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class PmdResultProcessing {

    // связь "название анализируемого элемента - информация о классе"
    // Получить данные из xml


    // Получить данные о коммитах в гите для существующих классов
    public void main(String[] args) {

        //String repositoryPath = args[0];

        SolidXmlReadService reader = new SolidXmlReadService();
        GitInfoService infoService = new GitInfoService("C:\\Users\\Enjeru\\MIPT\\Diplom\\ForAnalysis\\cassandra");

        Set<ClassMetaData> classMetaDataSet = reader.readXmlFile("C:\\Users\\Enjeru\\MIPT\\Diplom\\XmlResults\\CassandraResult2.xml");
        Map<String, Double> gitMap = infoService.getClassCommitNumber();

        System.out.println("breakpoint");

        for (ClassMetaData classMeta : classMetaDataSet) {
            String className = classMeta.getClassName();
            if (gitMap.containsKey(classMeta.getClassName())) {
                classMeta.addRuleInfo(new RulesInfo(null, "GitCommitNumberRule", gitMap.get(className)));
            }
        }


        ResultWriteService resultWriteService = new ExcelResultWriterService("C:\\Users\\Enjeru\\MIPT\\Diplom\\ExcelResults\\CassandraResult.xls");
        resultWriteService.writeResult(classMetaDataSet);
    }



}
