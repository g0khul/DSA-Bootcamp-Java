package SolvedProblems.FileHandling;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MyOutputStream {
    public static void main(String[] args) {
        // writingSomething();
        // usingFileWriter();
        // usingBufferedWriter();
    }

    private static void writingSomething() {
        OutputStream os = System.out;

        // os.write(😀); // Range is exceeded
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out)) {
            osw.write("Hello World\n");
            osw.write(65);
            osw.write("\n");
            osw.write('b');
            // osw.write(😀);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void usingFileWriter() {
        try (FileWriter fw = new FileWriter("SolvedProblems/FileHandling/new.txt", true)) {
            fw.write(" Hello world I'm writing something that needs to be appended");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void usingBufferedWriter() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("SolvedProblems/FileHandling/new.txt", true))) {
            bw.write("\nHello world I'm writing it from BufferedWriter");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
