package Array;
import java.util.ArrayList;

public class CreateTargetArray {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }

        // Time complexity is more for stream()
        // return list.stream().mapToInt(Integer::intValue).toArray();

        int[] target = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            target[i] = list.get(i);
        }
        
        return target;
    }

    public static void main(String[] args) {
        
    }
}
