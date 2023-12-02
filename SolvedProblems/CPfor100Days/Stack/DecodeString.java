package CPfor100Days.Stack;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a2[c]]v";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int n = 0;

        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder sb = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    sb.insert(0, stack.pop());
                }
                stack.pop();

                // Build string
                int times = Integer.parseInt(stack.pop());
                String copy = sb.toString();
                while (--times != 0) {
                    sb.append(copy);
                }

                if (!stack.isEmpty()) {
                    stack.push(sb.toString());
                } else {
                    result.append(sb);
                }

            } else if (Character.isDigit(c)) {
                n = n * 10 + c - 48;
            } else {
                if (n != 0) {
                    stack.push(String.valueOf(n));
                    n = 0;
                }
                stack.push((String.valueOf(c)));
            }
        }

        int length = result.length();
        while (!stack.isEmpty()) {
            result.insert(length, stack.pop());
        }

        return result.toString();
    }
}
