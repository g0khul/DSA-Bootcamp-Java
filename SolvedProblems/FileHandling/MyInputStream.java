package SolvedProblems.FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MyInputStream {

    public static void main(String[] args) {
        // usingInputStreamReader();
        // usingFileReader();
        // usingBufferedReaderConsoleInput();
        // usingBufferedReaderFileInput();

    }

    public static void usingInputStreamReader() {
        // InputStreamReader isr = new InputStreamReader(System.in);
        try (InputStreamReader isr = new InputStreamReader(System.in)) {
            System.out.print("Enter some characters : ");
            char letter = (char) isr.read();
            while (isr.ready()) {
                System.out.print(letter + " ");
                letter = (char) isr.read();
            }
            System.out.println();
            // isr.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void usingFileReader() {
        try (FileReader fr = new FileReader("SolvedProblems/FileHandling/content.txt")) {
            Scanner sc = new Scanner(fr);
            String str = sc.next();
            while (sc.hasNext()) {
                System.out.println(str);
                str = sc.next();
            }
            System.out.println();
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void usingBufferedReaderConsoleInput() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = br.readLine();
            System.out.println("I typed " + str);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void usingBufferedReaderFileInput() {
        try (BufferedReader br = new BufferedReader(new FileReader("SolvedProblems/FileHandling/content.txt"))) {
            while (br.ready()) {
                String str = br.readLine();
                System.out.println(str);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
