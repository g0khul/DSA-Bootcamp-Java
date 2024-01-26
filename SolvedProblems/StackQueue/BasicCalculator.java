import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        String s = "1-(     -2)";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        index = 0;

        return helper(s);
    }

    static int index = 0;

    public static int helper(String s) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int sign = 1;

        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                int num = 0;
                while (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                    index++;
                    if (index < s.length()) {
                        c = s.charAt(index);
                    } else {
                        break;
                    }
                }
                num = (sign == -1) ? num * sign : num;
                operands.push(num);
                sign = 1;
            }
            if (c == '+' || c == '-') {
                index++;
                sign = (c == '-') ? -1 : 1;
                if (!operands.isEmpty()) {
                    operators.push('+');
                }
            } else if (c == '(') {
                index++;
                operands.push(sign * helper(s));
            } else if (c == ')') {
                while (!operators.isEmpty()) {
                    int num2 = operands.pop();
                    int num1 = operands.pop();
                    operators.pop();

                    operands.push(num1 + num2);
                }
                index++;

                return operands.peek();
            } else {
                index++;
            }
        }

        while (!operators.isEmpty()) {
            int num2 = operands.pop();
            int num1 = operands.pop();
            operators.pop();

            operands.push(num1 + num2);
        }

        return operands.peek();
    }
}
