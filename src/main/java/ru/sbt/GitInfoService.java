package ru.sbt;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GitInfoService {
    private String pathToRepository;

    public GitInfoService(String pathToRepository) {
        this.pathToRepository = pathToRepository;
    }

    public Map<String, Double> getClassCommitNumber() throws IOException {
        getCommitInfo();
        return readFileToMap();
    }

    private void getCommitInfo() throws IOException {
        String command = "git log --output gitLog.txt --name-status --pretty=format:\"\"";

        Runtime runtime = Runtime.getRuntime();
        Process proc = runtime.exec(command, null, new File(pathToRepository));

        InputStream is = proc.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    private Map<String, Double> readFileToMap() {
        Map<String, Double> map = new HashMap();
        List<String> testList = new ArrayList<>();
        try {
            FileInputStream fstream = new FileInputStream(pathToRepository + "\\gitLog.txt");
            //String pathBeforeDir = pathToRepository.substring(0, pathToRepository.lastIndexOf('\\'));
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (!strLine.equals("")) {
                    // отделяю вид коммита
                    String[] addresses = strLine.split("\t");
                    String address = pathToRepository + '\\' + addresses[1];
                    // TODO: везед слеши заменить на бэкслеши
                    address = address.replace('/', '\\');
                    //testList.add(address);
                    // если ээлемент есть, увеличиваем счетчик
                    Double amount = map.get(address);
                    if (amount != null) {
                        map.put(address, amount + 1);
                    } else {
                        map.put(address, 1.0);
                    }
                }
            }
            System.out.println(map.get("C:\\Users\\Enjeru\\MIPT\\Diplom\\ForAnalysis\\cassandra\\src\\java\\org\\apache\\cassandra\\service\\StorageProxy.java"));
        } catch (IOException e) {
            System.out.println("Ошибка Чтения/записи файла gitLog.txt\"");
        }
        return map;
    }


}
