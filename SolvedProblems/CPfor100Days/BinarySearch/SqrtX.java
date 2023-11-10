

public class SqrtX {
    public static void main(String[] args) {
        int x = 2147395599;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        long start = 1;
        long end = x;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == (long) x) {
                return (int) mid;
            } else if (mid * mid > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return (int) end;
    }
}
