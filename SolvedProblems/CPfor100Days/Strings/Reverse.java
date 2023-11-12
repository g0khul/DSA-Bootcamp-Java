
import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder s = new StringBuilder(str);
        System.out.println(s.reverse().toString());
        sc.close();
    }
}
