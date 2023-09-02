public class MedianTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0){
            return 0;
        }

        int[] result = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }

        if (i < nums1.length) {
            while (i < nums1.length) {
                result[k++] = nums1[i++];
            }
        }

        if (j < nums2.length) {
            while (j < nums2.length) {
                result[k++] = nums2[j++];
            }
        }

        if(result.length == 1){
            return result[0];
        }

        if(result.length == 2){
            return result[0] + result[1];
        }

        if (result.length % 2 == 0) {
            return (result[result.length / 2] + result[result.length / 2 - 1]) / 2;
        }

        return result[(result.length) / 2];
    }

    public static void main(String[] args) {
        int[] num1 = { 1, 2 };
        int[] num2 = { 3, 4 };
        System.out.println(findMedianSortedArrays(num1, num2));
    }
}
