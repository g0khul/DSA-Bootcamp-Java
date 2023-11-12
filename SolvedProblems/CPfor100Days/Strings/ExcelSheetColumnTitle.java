public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle(52));
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber > 26) {
            result.insert(0, (char) ((columnNumber - 1) % 26 + 65));
            columnNumber = (columnNumber - 1) / 26;
        }

        if (columnNumber != 0) {
            result.insert(0, (char) (columnNumber - 1 + 65));
        }

        return result.toString();
    }
}
