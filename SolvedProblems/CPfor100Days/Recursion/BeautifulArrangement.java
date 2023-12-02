package CPfor100Days.Recursion;

public class BeautifulArrangement {
    public static void main(String[] args) {
        System.out.println(countArrangement(10));
    }

    public static int countArrangement(int n) {
        StringBuilder unprocessed = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            unprocessed.append(i);
        }

        return helper("", unprocessed.toString());
    }

    private static int helper(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            return (isValid(processed)) ? 1 : 0;
        }

        int count = 0;
        for (int i = 0; i < processed.length() + 1; i++) {
            count += helper(processed.substring(0, i) + unprocessed.charAt(0) + processed.substring(i),
                    unprocessed.substring(1));
        }

        return count;
    }

    private static boolean isValid(String str) {
        for (int i = 0; i < str.length(); i++) {
            int n = str.charAt(i) - 48;
            if (n % (i + 1) != 0 && (i + 1) % n != 0) {
                return false;
            }
        }

        return true;
    }
}
