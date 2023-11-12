package BigIntegers;

import java.math.BigDecimal;

public class BigDec {
    public static void main(String[] args) {
        double a = 0.03;
        double b = 0.04;
        // 0.010000000000000002 --> Wrong answer
        System.out.println(b - a);


        BigDecimal A = new BigDecimal("0.03");
        BigDecimal B = new BigDecimal("0.04");
        System.out.println(B.subtract(A));

        A = new BigDecimal("3474598324753.252305");
        B = new BigDecimal("235235.23523235");
        System.out.println(B.add(A));
        System.out.println(B.pow(23));
        System.out.println(B.equals(A));
        


    }
}
