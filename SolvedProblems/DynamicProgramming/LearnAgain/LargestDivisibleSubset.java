import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] nums = { 1, 16, 7, 8, 4 };
        System.out.println(largestDivisibleSubsetRecursion(nums));
        System.out.println(largestDivisibleSubsetMemoization(nums));
        // Array method --> Refer longest increasing subsequence lengthOfLISPrint
        System.out.println(largestDivisibleSubsetDp(nums));
    }

    public static List<Integer> largestDivisibleSubsetRecursion(int[] nums) {
        Arrays.sort(nums);
        return helperRecursion(nums, 0, -1);
    }

    public static List<Integer> helperRecursion(int[] nums, int index, int last) {
        if (index == nums.length) {
            return new ArrayList<>();
        }

        List<Integer> leaveIt = helperRecursion(nums, index + 1, last);
        List<Integer> takeIt = new ArrayList<>();
        if (last == -1 || nums[index] % last == 0) {
            takeIt.add(nums[index]);
            takeIt.addAll(helperRecursion(nums, index + 1, nums[index]));
        }

        return (leaveIt.size() > takeIt.size()) ? leaveIt : takeIt;
    }

    public static List<Integer> largestDivisibleSubsetMemoization(int[] nums) {
        Arrays.sort(nums);
        Map<String, List<Integer>> memo = new HashMap<>();
        return helperMemoization(nums, 0, -1, memo);
    }

    public static List<Integer> helperMemoization(int[] nums, int index, int prev, Map<String, List<Integer>> memo) {
        if (index == nums.length) {
            return new ArrayList<>();
        }

        String key = index + "" + prev;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        List<Integer> leaveIt = helperMemoization(nums, index + 1, prev, memo);
        List<Integer> takeIt = new ArrayList<>();
        if (prev == -1 || nums[index] % prev == 0) {
            takeIt.add(nums[index]);
            takeIt.addAll(helperMemoization(nums, index + 1, nums[index], memo));
        }

        List<Integer> currResult = (takeIt.size() > leaveIt.size()) ? takeIt : leaveIt;
        memo.put(key, currResult);
        return currResult;
    }

    public static List<Integer> largestDivisibleSubsetDp(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int[] hash = new int[nums.length];
        int max = 1;
        int maxIndex = 0;
        int maxValue = nums[0];
        Arrays.sort(nums);

        for (int index = 0; index < nums.length; index++) {
            hash[index] = index;
            for (int prev = 0; prev < index; prev++) {
                if (nums[index] % nums[prev] == 0) {
                    if (1 + dp[prev] > dp[index]) {
                        dp[index] = 1 + dp[prev];
                        hash[index] = prev;
                    }
                }
            }
            if (dp[index] > max) {
                max = dp[index];
                maxIndex = index;
                maxValue = nums[index];
            }
        }

        int index = maxIndex;
        List<Integer> result = new ArrayList<>();
        result.add(0, maxValue);
        while (index != 0) {
            result.add(0, nums[hash[index]]);
            index = hash[index];
        }

        return result;
    }
}
