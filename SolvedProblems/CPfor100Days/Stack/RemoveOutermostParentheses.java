package CPfor100Days.Stack;

public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        String s = "(()())(())(()(()))"; // ()() () ()(())
        System.out.println(removeOuterParentheses(s));
    }

    public static String removeOuterParentheses(String s) {
        // Stack<Character> stack = new Stack<>();
        // StringBuilder sb = new StringBuilder();

        // for (int i = 0; i < s.length();) {
        //     // Add one block of paranthesis
        //     int paris = 0;
        //     boolean first = true;
        //     while (paris != 0 || first) {
        //         if (s.charAt(i) == '(') {
        //             paris++;
        //             stack.push(s.charAt(i));
        //         } else {
        //             paris--;
        //             stack.push(s.charAt(i));
        //         }
        //         first = false;
        //         i++;
        //     }

        //     // Build result from stack
        //     stack.pop();
        //     int start = sb.length();
        //     int size = stack.size() - 1;
        //     for (int j = 0; j < size; j++) {
        //         sb.insert(start, stack.pop());
        //     }
        //     stack.pop();
        // }

        // return sb.toString();

        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' && open++ > 0) {
                sb.append(c);
            } else if (c == ')' && open-- > 1) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
