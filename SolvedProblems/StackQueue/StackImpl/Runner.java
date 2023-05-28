public class Runner {
    public static void main(String[] args) {
        StackImpl stack = new StackImpl();
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);

        stack.display();

        stack.pop();

        stack.peek();
        stack.display();

        System.out.println(stack.isEmpty());
    }
}
