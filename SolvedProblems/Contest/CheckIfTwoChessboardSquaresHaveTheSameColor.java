public class CheckIfTwoChessboardSquaresHaveTheSameColor {
    public static void main(String[] args) {
        String coordinate1 = "a1";
        String coordinate2 = "c2";
        System.out.println(checkTwoChessboards(coordinate1, coordinate2));
    }

    public static boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        return check(coordinate1) == check(coordinate2);
    }

    public static boolean check(String coordinate) {
        boolean c = false;
        switch (coordinate.charAt(0)) {
            case 'a':
            case 'c':
            case 'e':
            case 'g': {
                if (checkNum(coordinate, true)) {
                    if (coordinate.charAt(1) % 2 != 0) {
                        // black cell
                        c = true;
                    }
                }
            }
                ;
                break;
            default: {
                if (checkNum(coordinate, false)) {
                    if (coordinate.charAt(1) % 2 == 0) {
                        // black cell
                        c = true;
                    }
                }
            }
        }
        return c;
    }

    public static boolean checkNum(String coordinate, boolean startWithBlack) {
        if (startWithBlack) {
            return coordinate.charAt(1) % 2 != 0;
        } else {
            return coordinate.charAt(1) % 2 == 0;
        }
    }
}
