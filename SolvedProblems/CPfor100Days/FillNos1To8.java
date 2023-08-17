public class FillNos1To8 {
    public static void main(String[] args) {
        int[][] nums = new int[3][4];
        fillNos(nums);
        display(nums);
    }

    private static void display(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] != -1) {
                    System.out.print(nums[i][j] + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    private static void fillNos(int[][] nums) {
        boolean[][] marker = new boolean[3][4];
        marker[0][0] = true;
        marker[2][0] = true;
        marker[0][3] = true;
        marker[2][3] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (isValid(marker[i][j])) {

                }
            }
        }

        getNumbersFilled(nums, marker, 8);
    }

    private static boolean isValid(boolean marker) {

        return false;
    }

    private static void getNumbersFilled(int[][] nums, boolean[][] marker, int end) {

    }
}
