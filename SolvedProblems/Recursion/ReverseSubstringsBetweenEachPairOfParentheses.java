import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses {
    public static void main(String[] args) {
        String s = "a(bcdefghijkl(mno)p)q";
        System.out.println(reverseParentheses(s));
        System.out.println(reverseParenthesesRecursion(s));
    }

    public static String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder(s);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                stack.push(i);
            } else if (sb.charAt(i) == ')') {
                int start = stack.pop();
                int end = i + 1;
                StringBuilder substring = new StringBuilder(sb.substring(start, end));
                substring = substring.reverse();
                sb.replace(start, end, substring.toString());
            }
        }

        for (int i = 0; i < sb.length();) {
            if (sb.charAt(i) == '(' || sb.charAt(i) == ')') {
                sb.deleteCharAt(i);
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    public static String reverseParenthesesRecursion(String s) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                result.append('[');
            } else if (c == ')') {
                StringBuilder temp = new StringBuilder();
                for (int i = result.length() - 1; i >= 0; i--) {
                    if (result.charAt(i) == '[') {
                        result.deleteCharAt(i);
                        break;
                    } else {
                        temp.append(result.charAt(i));
                    }
                }
                result.replace(result.length() - temp.length(), result.length() + 1, temp.toString());
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
