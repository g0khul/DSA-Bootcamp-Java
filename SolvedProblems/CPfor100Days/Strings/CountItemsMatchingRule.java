import java.util.List;

public class CountItemsMatchingRule {
    public static void main(String[] args) {

    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = -1;
        switch (ruleKey) {
            case "type":
                index = 0;
                break;
            case "color":
                index = 1;
                break;
            case "name":
                index = 2;
                break;
            default:
                index = -2;
        }

        int result = 0;

        for (List<String> list : items) {
            if(list.get(index).equals(ruleValue)){
                result++;
            }
        }

        return result;
    }
}
