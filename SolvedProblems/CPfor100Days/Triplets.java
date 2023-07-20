import java.util.Scanner;

public class Triplets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (i * i + j * j == k * k) {
                        System.out.println(i + " " + j + " " + k);
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
        sc.close();
    }
}
