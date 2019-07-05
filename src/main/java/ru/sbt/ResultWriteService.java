package ru.sbt;

import java.util.Set;

public interface ResultWriteService {

    void writeResult(Set<ClassMetaData> metaDataMap);
}
