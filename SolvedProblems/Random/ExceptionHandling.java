import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) throws Exception {

        try (/*
              * Using this parameter will skip the lines to close the scanner in the finally
              * block
              */
                Scanner sc = new Scanner(System.in)) {

            int num = sc.nextInt();
            if (num < 10) {
                throw new UserDefinedException("This is a user defined exception");
            }
        }

        catch (UserDefinedException e) {
            System.out.println(e);
        }

    }
}

class UserDefinedException extends Exception {

    UserDefinedException(String exception) {
        super(exception);
    }
}