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

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(arr));

    }
}
