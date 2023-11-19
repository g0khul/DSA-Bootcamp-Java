package CPfor100Days.Strings;

import java.util.Arrays;
import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/../";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] paths = path.split("/");
        System.out.println(Arrays.toString(paths));

        for (String dir : paths) {
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!dir.isEmpty() && !dir.equals(".")) {
                stack.push(dir);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop()).insert(0, "/");
        }

        return result.toString();
    }
}
