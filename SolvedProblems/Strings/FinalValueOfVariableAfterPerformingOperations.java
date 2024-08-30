public class FinalValueOfVariableAfterPerformingOperations {
    public static void main(String[] args) {
        String[] operations = { "--X", "X++", "X++" };
        System.out.println(finalValueAfterOperations(operations));
    }

    public static int finalValueAfterOperations(String[] operations) {
        int sum = 0;
        for (String operation : operations) {
            switch (operation) {
                case "++X":
                case "X++":
                    sum++;
                    break;

                case "--X":
                case "X--":
                    sum--;
                    break;
            }
        }

        return sum;
    }
}
