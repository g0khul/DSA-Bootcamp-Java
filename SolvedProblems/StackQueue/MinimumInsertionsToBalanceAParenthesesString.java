import java.util.Stack;

public class MinimumInsertionsToBalanceAParenthesesString {
    public static void main(String[] args) {
        String s = "))()))";
        System.out.println(minInsertions(s));
    }

    public static int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();

        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (stack.peek() == ')') {
                        count++;
                        stack.pop();
                        stack.pop();
                    }
                    stack.push(c);
                }
            } else {
                if (stack.isEmpty()) {
                    count++;
                    stack.push('(');
                    stack.push(c);
                } else {
                    if (stack.peek() == '(') {
                        stack.push(c);
                    } else {
                        stack.pop();
                        stack.pop();
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == '(') {
                count += 2;
            } else {
                count++;
                stack.pop();
            }
        }

        return count;
    }
}
