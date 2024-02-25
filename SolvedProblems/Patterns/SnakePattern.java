public class SnakePattern {
    public static void main(String[] args) {
        int n = 6;

        int value = 1;
        for (int i = 0; i < n; i++) {
            if(i % 2 == 0){
                for (int j = 0; j < n; j++) {
                    System.out.print(value++ + "\t");
                }
            } else {
                int temp = 2 * (value - 1);
                for (int j = 0; j < n; j++) {
                    System.out.print(temp-- + "\t");
                }
                value += n;
            }
            System.out.println();
        }
    }
}
