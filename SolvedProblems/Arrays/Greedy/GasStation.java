import java.util.Arrays;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = { 5, 1, 2, 3, 4 };
        int[] cost = { 4, 4, 1, 5, 1 };

        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int gasRemains = 0;

        for (int i = 0; i < cost.length; i++) {
            gasRemains = gasRemains + (gas[i] - cost[i]);
        }

        if (gasRemains < 0) {
            return -1;
        }

        int start = 0;
        int total = 0;

        for (int i = 0; i < cost.length; i++) {
            total = total + (gas[i] - cost[i]);

            if (total < 0) {
                total = 0;
                start = i + 1;
            }
        }

        return start;
    }
}
