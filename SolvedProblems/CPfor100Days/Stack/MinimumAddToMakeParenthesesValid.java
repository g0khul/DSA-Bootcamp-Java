package Stack;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        String s = ")(";
        System.out.println(minAddToMakeValid(s));
    }

    public static int minAddToMakeValid(String s) {
        int counter = 0;
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else if(!stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            } else {
                counter++;
            }
        }

        return counter + stack.size();
    }    
}
