package StackQueue;

import java.util.Stack;

class MyQueue {
    Stack<Integer> stack;
    public MyQueue() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        Stack<Integer> temp = new Stack<>();
        while(!stack.empty()){
            temp.push(stack.pop());
        }
        int pop = temp.pop();

        while(!temp.empty()){
            stack.push(temp.pop());
        }

        return pop;
    }
    
    public int peek() {
        Stack<Integer> temp = new Stack<>();
        while(!stack.empty()){
            temp.push(stack.pop());
        }
        int peek = temp.pop();
        temp.push(peek);
        while(!temp.empty()){
            stack.push(temp.pop());
        }

        return peek;
    }
    
    public boolean empty() {
        return stack.empty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */