import java.util.Arrays;

public class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        int[] result = new int[nums1.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i != m && j != n) {
            if (nums1[i] < nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }

        while (i < m) {
            result[k++] = nums1[i++];
        }

        while (j < n) {
            result[k++] = nums2[j++];
        }

        for (i = 0; i < result.length; i++) {
            nums1[i] = result[i];
        }

    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };

        merge(nums1, 3, nums2, nums2.length);

        System.out.println(Arrays.toString(nums1));
    }
}
