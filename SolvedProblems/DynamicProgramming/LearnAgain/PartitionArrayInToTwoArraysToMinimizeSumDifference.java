public class PartitionArrayInToTwoArraysToMinimizeSumDifference {
    public static void main(String[] args) {
        int[] nums = { -36, 36 };
        // Doesn't work for negative numbers
        // System.out.println(minimumDifferenceDp(nums));
        System.out.println(minimumDifferenceDpNegative(nums));
    }

    public static int minimumDifferenceDp(int[] nums) {
        int k = 0;
        for (int n : nums) {
            k += n;
        }

        boolean[] prev = new boolean[k + 1];
        prev[0] = true;
        prev[nums[0]] = true;

        for (int index = 1; index < nums.length; index++) {
            boolean[] curr = new boolean[k + 1];
            curr[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean leaveIt = prev[target];
                boolean takeIt = false;
                if (target - nums[index] >= 0) {
                    takeIt = prev[target - nums[index]];
                }
                curr[target] = takeIt || leaveIt;
            }
            prev = curr;
        }

        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i < prev.length / 2; i++) {
            if (!prev[i]) {
                continue;
            }

            int s1 = i;
            int s2 = k - s1;
            int currDifference = Math.abs(s1 - s2);
            minDifference = (minDifference > currDifference) ? currDifference : minDifference;
        }

        return minDifference;
    }

    public static int minimumDifferenceDpNegative(int[] nums) {
        int offset = 0;
        for (int i : nums) {
            offset += Math.abs(i);
        }

        offset = offset / 2;
        boolean[] prev = new boolean[2 * offset + 1];
        prev[offset] = true;
        if (nums[0] <= offset) {
            prev[nums[0] + offset] = true;
        }

        for (int index = 1; index < nums.length; index++) {
            boolean[] curr = new boolean[2 * offset + 1];
            curr[offset] = true;
            for (int target = -offset; target <= offset; target++) {
                if (target + offset >= 0 && target + offset < offset + 1) {
                    boolean leaveIt = prev[target + offset];
                    boolean takeIt = false;
                    if (target + offset - nums[index] >= 0 && target + offset - nums[index] < offset + 1) {
                        takeIt = prev[(target + offset) - nums[index]];
                    }
                    curr[target + offset] = takeIt || leaveIt;
                }
            }
            prev = curr;
        }

        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i < prev.length; i++) {
            if (!prev[i]) {
                continue;
            }

            int s1 = i - offset;
            int s2 = offset - s1;
            int currDifference = Math.abs(s1 - s2);
            minDifference = Math.min(minDifference, currDifference);
        }

        return minDifference;
    }
}
