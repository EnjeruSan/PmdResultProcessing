package ru.sbt;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class GitInfoServiceTest {

    @Test
    public void test() throws IOException {
        GitInfoService service = new GitInfoService();
        service.getCommitInfo("C:\\Users\\Enjeru\\MIPT\\Diplom\\ForAnalysis\\microconfig\\microconfig");
    }

}