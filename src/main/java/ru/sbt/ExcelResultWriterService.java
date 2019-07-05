package ru.sbt;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class ExcelResultWriterService implements ResultWriteService {

    private String exitFilePath;

    ExcelResultWriterService(String exitFilePath) {
        this.exitFilePath = exitFilePath;
    }

    public void writeResult(Set<ClassMetaData> metaDataMap) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("ResultExcelList");
        // счетчик для строк
        int rowNum = 0;
        // создаем подписи к столбцам (это будет первая строчка в листе Excel файла)
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("Класс");
        row.createCell(1).setCellValue("Метод (если есть)");
        row.createCell(2).setCellValue("Метрика");
        row.createCell(3).setCellValue("значение");

        for (ClassMetaData classMetaData : metaDataMap) {
            String classNme = classMetaData.getClassName();
            for (RulesInfo ruleInfo : classMetaData.getRulesInfoList()) {
                writeRow(sheet, ++rowNum, ruleInfo, classNme);
            }
        }

        try {
            FileOutputStream out = new FileOutputStream(new File(exitFilePath));
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeRow(HSSFSheet sheet, int rowNum, RulesInfo rulesInfo, String className) {
        Row row = sheet.createRow(rowNum);
        String metName = rulesInfo.getMethodName();
        if (rulesInfo.getMethodName() == null) {
            metName = " ";
        }

        row.createCell(0).setCellValue(className);
        row.createCell(1).setCellValue(metName);
        row.createCell(2).setCellValue(rulesInfo.getRuleName());
        row.createCell(3).setCellValue(rulesInfo.getValue());
    }
}
