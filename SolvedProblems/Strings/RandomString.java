package SolvedProblems.Strings;

import java.util.Random;

public class RandomString {
    String generateString(int size){
        StringBuilder sb = new StringBuilder(size);
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            int randomVal = 97 + random.nextInt(27);
            sb.append((char) randomVal);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        RandomString rs = new RandomString();
        System.out.println(rs.generateString(10));
    }
}
