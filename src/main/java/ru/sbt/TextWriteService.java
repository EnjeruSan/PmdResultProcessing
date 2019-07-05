package ru.sbt;

import java.util.Set;

public class TextWriteService implements ResultWriteService {

    String inputFileName;

    public TextWriteService(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    @Override
    public void writeResult(Set<ClassMetaData> metaDataMap) {

    }
}
