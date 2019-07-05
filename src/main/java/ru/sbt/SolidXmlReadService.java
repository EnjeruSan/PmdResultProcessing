package ru.sbt;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ru.sbt.ClassMetaData;
import ru.sbt.RulesInfo;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashSet;
import java.util.Set;


public class SolidXmlReadService {
    public Set<ClassMetaData> readXmlFile(String pathname) {
        Set<ClassMetaData> metaDataSet = new HashSet<>();
        try {
            // Подготовка документа
            File fXmlFile = new File(pathname);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            // Анализируем каждый файл, который есть в отчете
            NodeList nFiles = doc.getElementsByTagName("file");

            for (int fileNumber = 0; fileNumber < nFiles.getLength(); fileNumber++) {
                ClassMetaData classMetaData = new ClassMetaData();

                // Вытаскиваем имя файла
                Node nFile = nFiles.item(fileNumber);
                Element eFile = (Element) nFile;
                String fileName = eFile.getAttribute("name");
                classMetaData.setClassName(fileName);

                // Для каждого файла анализируем нарушения
                // Надо исправить. Брать violations не по всему документу, а внутри файла
                NodeList nViolations = eFile.getElementsByTagName("violation");
                System.out.println(nViolations);
                for (int vNumber = 0; vNumber < nViolations.getLength(); vNumber++) {
                    Node vNode = nViolations.item(vNumber);
                    Element vElement = (Element) vNode;
                    // Вытаскиваем данные о нарушении: название правила, имя элемента и строки
                    String ruleName = vElement.getAttribute("rule");
                    Double value;

                    // Вместо использования Factory
                    String argument = vElement.getFirstChild().toString().split("\\n")[1];
                    if(argument.equals("{0}")) {
                        value = null;
                    } else {
                        value = Double.parseDouble(argument);
                    }
                    //
                    if (value != null) {
                        String methodName = vElement.getAttribute("method");
                        if (methodName.length() == 0) {
                            methodName = null;
                        }
                        //System.out.println(fileName + "\\" + methodName + ": \nName: " + ruleName + ", value: " + value + " \n");
                        RulesInfo rulesInfo = new RulesInfo(methodName, ruleName, value);
                        classMetaData.addRuleInfo(rulesInfo);
                    }
                }
                // Добавляем информацию о классе
                metaDataSet.add(classMetaData);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return metaDataSet;
    }

}
