package Recursion;

import java.util.ArrayList;
import java.util.List;

public class BalancedParanthesisCombination {
    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        System.out.println(result);
    }

    private static List<String> generateParenthesis(int n) {
        return getParanthesis(n, "", 0, 0);
    }
     
    private static List<String> getParanthesis(int n, String paranthesis, int open, int close) {
        if (open == n && close == n) {
            List<String> list = new ArrayList<>();
            list.add(paranthesis);
            return list;
        }

        List<String> list = new ArrayList<>();
        if (open < n) {
            list.addAll(getParanthesis(n, paranthesis + '{', open + 1, close));
        }

        if (close < open) {
            list.addAll(getParanthesis(n, paranthesis + '}', open, close + 1));
        }

        return list;
    }
}
