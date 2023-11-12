package CPfor100Days.Strings;

public class GoalParser {
    public static String interpret(String command) {
        String result = "";

        for (int i = 0; i < command.length(); ) {
            if(command.charAt(i) == 'G'){
                result += "G";
                i++;
            } else if(command.charAt(i) == '(' && command.charAt(i + 1) == ')'){
                result += "o";
                i += 2;
            } else {
                result += "al";
                i += 4;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        
    }
}
