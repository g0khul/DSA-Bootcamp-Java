import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement1 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = 0; i < nums1.length; i++) {
            stack1.push(nums1[i]);
            stack2.push(nums2[i]);
        }

        for (int i = nums1.length; i < nums2.length; i++) {
            stack2.push(nums2[i]);
        }

        boolean flag = false;
        int i = nums1.length - 1;
        int num = 0;

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek() < stack2.peek()) {
                flag = true;
                num = stack2.pop();
            } else {
                if (flag) {
                    result[i] = num;
                } else {
                    result[i] = -1;
                }
                stack1.pop();
                i--;
                flag = false;
            }
        }

        return result;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2, boolean val) {
        int[] result = new int[nums1.length];

        int z = 0;
        for (int i = 0; i < nums1.length; i++) {
            boolean flag = false;
            boolean resultflag = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    flag = true;
                }

                if (flag && nums1[i] < nums2[j]) {
                    result[z++] = nums2[j];
                    resultflag = true;
                    break;
                }
            }
            if (!resultflag) {
                result[z++] = -1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };
        int[] result = nextGreaterElement(nums1, nums2, true);
        System.out.println(Arrays.toString(result));
    }
}
