package CPfor100Days.Strings;

public class ReturnRobotToOrigin {
    public static void main(String[] args) {
        System.out.println(judgeCircle("UDLLRR"));
    }

    public static boolean judgeCircle(String moves) {
        int row = 0;
        int col = 0;

        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    row -= 1;
                    break;
                case 'D':
                    row += 1;
                    break;
                case 'L':
                    col -= 1;
                    break;
                case 'R':
                    col += 1;
                    break;
            }
        }

        return row == 0 && col == 0;
    }
}
