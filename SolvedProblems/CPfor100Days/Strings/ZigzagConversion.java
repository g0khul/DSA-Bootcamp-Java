package CPfor100Days.Strings;

public class ZigzagConversion {
    public static void main(String[] args) {
        String s = "ABC";
        int numRows = 2;
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        } 

        int numCols = s.length();
        char[][] zigzagArray = new char[numRows][numCols];

        zigzagArray[0][0] = s.charAt(0);
        int row = 0;
        int col = 0;
        for (int i = 1; i < s.length();) {
            // fill column
            // row changes and col stays the same
            while (row < numRows - 1 && i < s.length()) {
                zigzagArray[++row][col] = s.charAt(i++);
            }
            row = numRows - 2;

            // fill row
            // col increases and row decreases
            while (row >= 0 && i < s.length()) {
                zigzagArray[row--][++col] = s.charAt(i++);
            }
            row = (row < 0) ? 0 : row;
        }

        StringBuilder sb = new StringBuilder();
        for (int rows = 0; rows < zigzagArray.length; rows++) {
            for (int cols = 0; cols < zigzagArray[rows].length; cols++) {
                if (zigzagArray[rows][cols] != '\0') {
                    sb.append(zigzagArray[rows][cols]);
                }
            }
        }

        return sb.toString();
    }

    private static void fillRow(char[][] string, String s, int row, int col, int i) {
        // col increases and row decreases
        while (row != 0 && i < s.length()) {
            string[--row][++col] = s.charAt(i++);
        }
    }

    private static void fillColumn(char[][] string, String s, int row, int col, int i) {
        // row changes and col stays the same
        while (row < string.length - 1 && i < s.length()) {
            string[++row][col] = s.charAt(i++);
        }
    }
}
