package ru.sbt;

import org.junit.Test;

import java.io.IOException;

public class GitInfoServiceTest {

    @Test
    public void test() throws IOException {
        GitInfoService service = new GitInfoService("C:\\Users\\Enjeru\\MIPT\\Diplom\\ForAnalysis\\cassandra");
        service.getClassCommitNumber();
    }

}