package ru.sbt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class TextWriteService implements ResultWriteService {

    String outputFileName;

    public TextWriteService(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    @Override
    public void writeResult(Set<ClassMetaData> metaDataMap) {

        for (ClassMetaData metaData : metaDataMap) {

        }

        try {
            FileOutputStream out = new FileOutputStream(new File(outputFileName));
            //workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
