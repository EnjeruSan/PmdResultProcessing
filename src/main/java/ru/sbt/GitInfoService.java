package ru.sbt;

import java.io.*;

public class GitInfoService {

    public void getCommitInfo(String path) throws IOException {
        String command = "git log --output filenameForEx.txt --name-status";
        File file = new File(path);

        Runtime runtime = Runtime.getRuntime();
        Process proc = runtime.exec(command, null, file);

        InputStream is = proc.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
