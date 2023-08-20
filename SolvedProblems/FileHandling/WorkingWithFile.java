package SolvedProblems.FileHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class WorkingWithFile {
    public static void main(String[] args) {
        MyFile myFile = new MyFile("Hello_World");
        myFile.createFile();
        myFile.writeOnFile("Hello world I'm writing this on my file");
        myFile.readOnFile();
        myFile.writeOnFile("\nI'm appending this conetent to the exisiting file.", true);
        myFile.readOnFile();
        // myFile.deleteFile();
    }
}

class MyFile {
    File file;
    String fileName;

    MyFile(String fileName) {
        file = new File(fileName);
        this.fileName = fileName;
    }

    protected boolean createFile() {
        try {
            file.createNewFile();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    protected boolean writeOnFile(String content) {
        return writeOnFile(content, false);
    }

    protected boolean writeOnFile(String content, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, append))) {
            bw.write(content);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    protected void readOnFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            while(br.ready()){
                String str = br.readLine();
                System.out.println(str);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteFile() {
        if(file.delete()){
            System.out.println(file.getName());
        } else {
            System.out.println("File cannot be deleted");
        }
    }
}
