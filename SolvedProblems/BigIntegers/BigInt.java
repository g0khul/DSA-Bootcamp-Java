package SolvedProblems.BigIntegers;

import java.math.BigInteger;

public class BigInt {
    static BigInteger factorial(int num){
        BigInteger fact = new BigInteger("1");

        for (int i = 2; i < num; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        return fact;
    }
    public static void main(String[] args) {
        // Both are converting int into long
        BigInteger A = BigInteger.valueOf(10);
        BigInteger B = BigInteger.valueOf(20);
        BigInteger C = A.add(B);
        System.out.println(C);

        // Converting String to really long int value
        A = new BigInteger("230523589237589364852789473857299704375262346346");
        B = new BigInteger("365865434638246385789478378957578934789374897348973467834768947");
        System.out.println(A.multiply(B));

        // Constants
        A = BigInteger.TWO;
        System.out.println(A);

        // Really large answer
        System.out.println(factorial(23532));
    }
}
