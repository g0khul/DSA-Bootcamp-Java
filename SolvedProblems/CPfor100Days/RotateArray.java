public class RotateArray {
    public static void rotate(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }

        k = k % nums.length;

        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }

        int[] copy = new int[k];
        for(int i = nums.length - 1, j = 0; i > nums.length - 1 - k; i--, j++){
            copy[j] = nums[i];
        }
        for(int i = nums.length - 1; i > k - 1; i--){

        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        rotate(arr, 4);
    }
}
