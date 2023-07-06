package SolvedProblems.Random;

import java.util.Stack;

public class RemoveDuplicates {
    public static String removeDuplicateLetters(String str) {
        int frequency[] = new int[26];
        boolean visited[] = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for(char c : str.toCharArray()){
            frequency[c - 'a']++;
        }

        for(char c : str.toCharArray()){
            frequency[c - 'a']--;

            if(visited[c - 'a']){
                continue;
            }

            while(!stack.isEmpty() && c < stack.peek() && frequency[stack.peek() - 'a'] > 0){
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            visited[c - 'a'] = true;
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String result = removeDuplicateLetters("bcabc");
        System.out.println(result);
    }
}
    
