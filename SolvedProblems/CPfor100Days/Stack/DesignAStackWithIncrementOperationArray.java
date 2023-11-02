package Stack;

public class DesignAStackWithIncrementOperationArray {
    public static void main(String[] args) {
        CustomStack1 stack = new CustomStack1(3);
        // for (int i = 1; i < 10; i++) {
        //     stack.push(i * 2);
        // }

        // System.out.println(stack.pop());
        // stack.display();
        // stack.increment(6, 1);
        // stack.display();

        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.display();
        stack.increment(5, 100);
        stack.increment(2, 100);
        stack.display();
        // System.out.println(stack.pop());

    }
}

class CustomStack1 {
    int[] stack;
    int end;
    int size;

    public CustomStack1(int maxSize) {
        stack = new int[maxSize];
        end = -1;
        size = 0;
    }

    public void push(int x) {
        if (size == stack.length) {
            return;
        }

        stack[++end] = x;
        size++;
        return;
    }

    public int pop() {
        if (size == 0) {
            return -1;
        }

        size--;
        return stack[end--];
    }

    public void increment(int k, int val) {
        if(size == 0){
            return;
        }

        int limit = (k < size)? k : end + 1;
        for (int i = 0; i < limit; i++) {
            stack[i] += val;
        }
    }

    public void display() {
        for (int i = 0; i < end + 1; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}
