package StackQueue;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        int maxHeight = 0;
        for (int i = 0; i < heights.length; i++) {
            int currentResult = 0;
            int leftRange = i;
            int rightRange = i;

            // Left range
            for (int j = i; j >= 0; j--) {
                if (heights[i] <= heights[j]) {
                    leftRange = j;
                } else {
                    break;
                }
            }

            // Right range
            for (int j = i; j < heights.length; j++) {
                if (heights[i] <= heights[j]) {
                    rightRange = j;
                } else {
                    break;
                }
            }

            currentResult = heights[i] * (rightRange - leftRange + 1);
            if (maxHeight < currentResult) {
                maxHeight = currentResult;
            }
        }

        return maxHeight;
    }

    public int largest1RectangleArea(int[] heights) {
        int maxHeight = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[i] < heights[stack.peek()])) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = height * width;
                maxHeight = Math.max(maxHeight, area);
            }
            stack.push(i);
        }

        return maxHeight;
    }

    // Redo with left and right small method
    public static int largestRectangleAreaRedo(int[] heights) {
        int[] leftSmall = new int[heights.length];
        int[] rightSmall = new int[heights.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < rightSmall.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                leftSmall[i] = 0;
            } else {
                leftSmall[i] = stack.peek() + 1;
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rightSmall[i] = heights.length - 1;
            } else {
                rightSmall[i] = stack.peek() - 1;
            }
            stack.push(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int area = (rightSmall[i] - leftSmall[i] + 1) * heights[i];
            max = Math.max(max, area);
        }

        return max;
    }

    // Compute in single pass
    public static int largestRectangleAreaOOfN(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] >= heights[i])) {
                int height = heights[stack.pop()];
                int width = 0;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, width * height);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(arr));
        System.out.println(largestRectangleAreaRedo(arr));
        System.out.println(largestRectangleAreaOOfN(arr));
    }
}
