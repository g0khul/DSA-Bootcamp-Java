import java.util.*;

public class Pairing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        if (num % 2 != 0) {
            System.out.println("Pairing not possible");
        } else {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(1);
            result.add(2);

            for (int i = 2; i < num; i++) {
                result.add(i, result.get(i - 1) + (i * result.get(i - 2)));
            }
            System.out.println(result.get(num - 1));
        }
    }
}