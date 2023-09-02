public class ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        int val = (int) Math.sqrt(num);
        return val * val == num;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }
}
