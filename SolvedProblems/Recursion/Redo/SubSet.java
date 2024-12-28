import java.util.ArrayList;
import java.util.Arrays;

public interface SubSet {
    public static void helper(ArrayList<Integer> unprocessed, ArrayList<Integer> processed, int index) {
        if (index == unprocessed.size()) {
            System.out.println(processed);
            return;
        }

        // Take it
        processed.add(unprocessed.get(index));
        helper(unprocessed, processed, index + 1);

        processed.remove(processed.size() - 1);

        // Leave it
        helper(unprocessed, processed, index + 1);
    }

    public static void subset(ArrayList<Integer> nums) {
        helper(nums, new ArrayList<>(), 0);
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3));
        subset(nums);
    }
}
