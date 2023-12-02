package Random;

import java.util.*;

public class InputPairs {

    public static String sumMethod(int arr[], int num, int len) {

        // This loop will find by iterating and adding each values
        // and return in the given format else return (0,0)

        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len ; j++) {
                System.out.println(arr[i] + ":" + arr[j]);
                if (num == arr[i] + arr[j])
                    return "(" + arr[i] + "," + arr[j] + ")";
            }
        }
        return "(0,0)";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /* 
         * Sample input
         * len = 5
         * arr = [1,2,4,7,5]
         * num = 7
         * result = (1,4)
         */

        int len = sc.nextInt();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++)
            arr[i] = sc.nextInt();

        int num = sc.nextInt();

        // Method to find which two pair gives the sum that is equal to num
        System.out.println(sumMethod(arr, num, len));
        sc.close();
    }
}