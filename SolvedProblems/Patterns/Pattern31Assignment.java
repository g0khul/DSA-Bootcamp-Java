/*
31.      4 4 4 4 4 4 4  
         4 3 3 3 3 3 4   
         4 3 2 2 2 3 4   
         4 3 2 1 2 3 4   
         4 3 2 2 2 3 4   
         4 3 3 3 3 3 4   
         4 4 4 4 4 4 4 
 */
package Patterns;

public class Pattern31Assignment {
    public static void main(String[] args) {
        int n = 5;

        // for (int i = n; i >= 1; i--) {
        //     for (int j = n; j >= i + 1; j--) {
        //         System.out.print(j);
        //     }

        //     for (int j = 1; j <= 2 * i - 1; j++) {
        //         System.out.print(i);
        //     }

        //     for (int j = i + 1; j <= n; j++) {
        //         System.out.print(j);
        //     }

        //     System.out.println();
        // }

        // for (int i = 1; i <= n; i++) {
        //     for (int j = n; j >= i + 1; j--) {
        //         System.out.print(j);
        //     }

        //     for (int j = 1; j <= 2 * i - 1; j++) {
        //         System.out.print(i);
        //     }

        //     for (int j = i + 1; j <= n; j++) {
        //         System.out.print(j);
        //     }

        //     System.out.println();
        // }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.printf("%2d",n - j);
            }

            for (int j = 0; j < 2 * (n - i) - 1; j++) {
                System.out.printf("%2d",n - i);
            }

            for (int j = n - i+ 1; j <= n; j++) {
                System.out.printf("%2d",j);
            }
            
            System.out.println();
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.printf("%2d",n - j);
            }

            for (int j = 0; j < 2 * (n - i) - 1; j++) {
                System.out.printf("%2d",n - i);
            }

            for (int j = n - i + 1; j <= n; j++) {
                System.out.printf("%2d",j);
            }

            System.out.println();
        }
        
    }
}
