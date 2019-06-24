package ru.sbt;


import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class SaveInfoService {
    private SolidXmlReader reader = new SolidXmlReader();
    private GitInfoService infoService = new GitInfoService("C:\\Users\\Enjeru\\MIPT\\Diplom\\ForAnalysis\\cassandra");

    // связь "название анализируемого элемента - информация о классе"
    // Получить данные из xml
    Set<ClassMetaData> classMetaDataSet = reader.readXmlFile("C:/Users/11007122/Documents/Diplom/Results/MyResult.xml");

    // ПОлучить данные о коммитах в гите для существующих классов
    public void getActualGitInfo() throws IOException {
        final Map<String, Double> gitMap = infoService.getClassCommitNumber();
        for (ClassMetaData classMeta : classMetaDataSet) {
            String classsName = classMeta.getClassName();
            if (gitMap.containsKey(classMeta.getClassName())) {
                classMeta.addRuleInfo(new RulesInfo(null, "GitCommitNuber", gitMap.get(classsName)));
            }
        }
    }

    //Если такой класс есть, записываем для него новое правило
    //Записать данные

}
