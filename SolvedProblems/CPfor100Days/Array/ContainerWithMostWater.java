package CPfor100Days.Array;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = { 1, 2, 4, 3 };
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;

        int result = 0;
        while (start < end) {
            int area = Math.min(height[start], height[end]) * (end - start);
            result = Math.max(result, area);

            if (height[start] < height[end]) {
                start++;
                while (start < end && height[start] < height[start + 1]) {
                    start++;
                }
                continue;
            } else {
                end--;
                while (start < end && height[end] > height[end - 1]) {
                    end--;
                }
                continue;
            }
        }

        return result;
    }
}
