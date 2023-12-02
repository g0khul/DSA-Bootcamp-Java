package Random;

public class EnhancedForLoop {
    public static void main(String[] args) {
        int arr[][] = new int[3][3];
        int val = 1;
        // Regular for loop used to store input values
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = val++;
            }
        }


        // Enhanced for loop used to display the values
        for (int i[] : arr) {
            for (int j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
